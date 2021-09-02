package modelo;

public class ModeloProducto {
    
    private int id;
    private String referencia;
    private Double costo;
    
    public ModeloProducto(int id, String referencia, Double costo) {
        this.id = id;
        this.referencia = referencia;
        this.costo = costo;
    }

    public int getId() {
        return id;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }    
}
