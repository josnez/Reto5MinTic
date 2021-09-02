package modelo;

public class ModeloVenta {
    
    private String fecha;
    private int idCliente;
    private int idProducto;
    
    public ModeloVenta(String fecha, int idCliente, int idProducto) {
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.idProducto = idProducto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    
}
