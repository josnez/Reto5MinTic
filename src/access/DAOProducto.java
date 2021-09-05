package access;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import models.ModeloProducto;
import utils.ConexionBD;
public class DAOProducto {

    private Connection conn = null;

    public List<ModeloProducto> getAllProductos() {

        ArrayList<ModeloProducto> productos = new ArrayList<>();

        try {
            if (conn == null)
                conn = ConexionBD.getConexion();

            String sql = "SELECT id_producto, referencia, costo FROM productos";

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                ModeloProducto producto = new ModeloProducto(result.getInt(1), result.getString(2), result.getDouble(3));
                productos.add(producto);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "DAOProducto Código : " + ex.getErrorCode() + "\nError :" + ex.getMessage());
        } 
        return productos;
    }
}
