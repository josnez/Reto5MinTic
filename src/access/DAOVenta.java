package access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import models.ModeloVenta;
import utils.ConexionBD;

public class DAOVenta {

    private Connection conn = null;
    private String sql;

    public List<ModeloVenta> getAllVentas() {

        ArrayList<ModeloVenta> ventas = new ArrayList<>();
        try {
            if (conn == null)
                conn = ConexionBD.getConexion();

            sql = "SELECT ventas.id_venta, ventas.fecha, clientes. id_cli, clientes.nombre, clientes.apellido, clientes.telefono, productos.id_producto, productos.referencia, productos.costo\n"
                    + "FROM ventas\n" + "JOIN clientes ON clientes.id_cli=ventas.id_cliente\n"
                    + "JOIN productos ON productos.id_producto=ventas.id_moto;";

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                ModeloVenta venta = new ModeloVenta(result.getInt(1), result.getDate(2), result.getInt(3),
                        result.getString(4), result.getString(5), result.getInt(6), result.getInt(7),
                        result.getString(8), result.getDouble(9));
                ventas.add(venta);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "DAOVenta Código : " + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        return ventas;
    }

    public List<ModeloVenta> getFilteredArtPieces(int idProducto, String nombreCliente) {
        List<ModeloVenta> ventasFiltradas = new ArrayList<>();
        boolean busquedaConProducto = false;
        try {
            if (conn == null)
                conn = ConexionBD.getConexion();

            sql = "SELECT ventas.id_venta, ventas.fecha, clientes. id_cli, clientes.nombre, clientes.apellido, clientes.telefono, productos.id_producto, productos.referencia, productos.costo\n"
                    + "FROM ventas\n" + "JOIN clientes ON clientes.id_cli=ventas.id_cliente\n"
                    + "JOIN productos ON productos.id_producto=ventas.id_moto\n" + "WHERE clientes.nombre LIKE ?";
            if (idProducto != -1) {
                sql += " AND productos.id_producto=?;";
                busquedaConProducto = true;
            }
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "%" + nombreCliente + "%");
            if (busquedaConProducto) {
                statement.setInt(2, idProducto);
            }
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                ModeloVenta venta = new ModeloVenta(result.getInt(1), result.getDate(2), result.getInt(3),
                        result.getString(4), result.getString(5), result.getInt(6), result.getInt(7),
                        result.getString(8), result.getDouble(9));
                ventasFiltradas.add(venta);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "DAOVenta, busqueda filtrada Código : " + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        return ventasFiltradas;
    }

    public void insertarVenta(ModeloVenta venta) {
        try {
            if (conn == null)
                conn = ConexionBD.getConexion();
            sql = "INSERT INTO ventas(id_venta, fecha, id_cliente, id_moto) VALUES(?, ?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, venta.getIdVenta());
            statement.setDate(2, venta.getFecha());
            statement.setInt(3, venta.getIdCliente());
            statement.setInt(4, venta.getIdProducto());

            int filasInsertadas = statement.executeUpdate();
            if (filasInsertadas > 0)
                JOptionPane.showMessageDialog(null, "La venta fue agregada exitosamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Ingresar venta Código : " + e.getErrorCode() + "\nError :" + e.getMessage());
        }
    }

    public void eliminarVenta(ModeloVenta venta) {
        try {
            if (conn == null)
                conn = ConexionBD.getConexion();
            sql = "DELETE FROM ventas WHERE id_venta=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, venta.getIdVenta());

            int filasInsertadas = statement.executeUpdate();
            if (filasInsertadas > 0)
                JOptionPane.showMessageDialog(null, "La venta fue eliminada exitosamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Eliminar venta Código : " + e.getErrorCode() + "\nError :" + e.getMessage());
        }
    }

    public void actualizarVenta(ModeloVenta venta) {
        try {
            if (conn == null)
                conn = ConexionBD.getConexion();
            sql = "UPDATE ventas SET fecha=?, id_cliente=?, id_moto=? WHERE id_venta=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setDate(1, venta.getFecha());
            statement.setInt(2, venta.getIdCliente());
            statement.setInt(3, venta.getIdProducto());
            statement.setInt(4, venta.getIdVenta());

            int filasInsertadas = statement.executeUpdate();
            if (filasInsertadas > 0)
                JOptionPane.showMessageDialog(null, "La venta fue actualizada exitosamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Actualizar venta Código : " + e.getErrorCode() + "\nError :" + e.getMessage());
        }
    }
}
