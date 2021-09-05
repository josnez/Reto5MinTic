package controlador;

import java.util.List;

import access.DAOCliente;
import access.DAOProducto;
import access.DAOVenta;
import models.ModeloCliente;
import models.ModeloProducto;
import models.ModeloVenta;

public class DatosIniciales {
    
    private List<ModeloCliente> clientes;
    private List<ModeloProducto> productos;
    private List<ModeloVenta> ventas;

    public DatosIniciales() {
        DAOVenta daoVenta = new DAOVenta();
        this.ventas = daoVenta.getAllVentas();

        DAOProducto daoProducto = new DAOProducto();
        this.productos = daoProducto.getAllProductos();
        this.productos.add(0, new ModeloProducto(-1, "Seleccionar", -1.0));

        DAOCliente daoCliente = new DAOCliente();
        this.clientes = daoCliente.getAllClientes();
        this.clientes.add(0, new ModeloCliente(-1, "Seleccionar", "", -1));
    }

    public List<ModeloCliente> getClientes() {
        return clientes;
    }

    public List<ModeloProducto> getProductos() {
        return productos;
    }

    public List<ModeloVenta> getVentas() {
        return ventas;
    }
    
}
