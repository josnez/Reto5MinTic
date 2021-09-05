package access;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import models.ModeloCliente;
import utils.ConexionBD;

public class DAOCliente {

    private Connection conn = null;

    public List<ModeloCliente> getAllClientes() {

        ArrayList<ModeloCliente> clientes = new ArrayList<>();
        try {
            if (conn == null)
                conn = ConexionBD.getConexion();

            String sql = "SELECT id_cli, nombre, apellido, telefono FROM clientes";

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                ModeloCliente cliente = new ModeloCliente(result.getInt(1), result.getString(2), result.getString(3),
                        result.getInt(4));
                clientes.add(cliente);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "DAOCliente Código : " + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        return clientes;
    }
}
