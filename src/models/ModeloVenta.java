package models;

import java.sql.Date;

public class ModeloVenta {

    private int idVenta;
    private Date fecha;
    private int idCliente;
    private String nombreCliente;
    private String apellidoCliente;
    private int telefonoCliente;
    private int idProducto;
    private String referencia;
    private Double costo;

    public ModeloVenta(int idVenta, Date fecha, int idCliente, int idProducto) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.idProducto = idProducto;
    }

    public ModeloVenta(int idVenta, Date fecha, String nombreCliente, String apellidoCliente, int telefonoCliente,
            String referencia, Double costo) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.telefonoCliente = telefonoCliente;
        this.referencia = referencia;
        this.costo = costo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
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

    public int getIdVenta() {
        return idVenta;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public int getTelefonoCliente() {
        return telefonoCliente;
    }

    public String getReferencia() {
        return referencia;
    }

    public Double getCosto() {
        return costo;
    }

    public Object[] toArray() {
        Object[] data = {idVenta, fecha, nombreCliente, apellidoCliente, telefonoCliente, referencia, costo};
        return data;
    }
}
