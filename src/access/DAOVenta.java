package access;

import java.sql.Connection;
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

    public List<ModeloVenta> getAllVentas() {

        ArrayList<ModeloVenta> ventas = new ArrayList<>();
        try {
            if (conn == null)
                conn = ConexionBD.getConexion();

            String sql = "SELECT ventas.id_venta, ventas.fecha, clientes.nombre, clientes.apellido, clientes.telefono, productos.referencia, productos.costo\n"
                    + "FROM ventas\n" 
                    + "JOIN clientes ON clientes.id_cli=ventas.id_cliente\n"
                    + "JOIN productos ON productos.id_producto=ventas.id_moto;";

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                ModeloVenta venta = new ModeloVenta(result.getInt(1), result.getDate(2), result.getString(3),
                        result.getString(4), result.getInt(5), result.getString(6), result.getDouble(7));
                ventas.add(venta);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "DAOVenta Código : " + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        return ventas;
    }
}
