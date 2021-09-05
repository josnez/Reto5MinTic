package view.componentes.panelBusquedas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import access.DAOVenta;
import controlador.DatosIniciales;
import models.ModeloProducto;
import models.ModeloVenta;
import view.VistaPrincipalComponent;

public class PanelBusquedasComponent implements ActionListener {
    
    private PanelBusquedasTemplate panelBusquedasTemplate;
    private VistaPrincipalComponent vistaPrincipalComponent;
    private int idProducto;
    private String nombreCliente;
    private DAOVenta daoVenta;
    private List<ModeloVenta> ventasFiltradas;

    public PanelBusquedasComponent(VistaPrincipalComponent vistaPrincipalComponent, DatosIniciales datosIniciales, DAOVenta daoVenta) {

        panelBusquedasTemplate = new PanelBusquedasTemplate(this, datosIniciales);
        this.vistaPrincipalComponent = vistaPrincipalComponent;
        this.daoVenta = daoVenta;
    }

    public PanelBusquedasTemplate gPanelBusquedasTemplate() {
        return panelBusquedasTemplate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String boton = e.getActionCommand();
        String vistaIngresar = "Ingresar Nueva Venta";
        String vistaModificar = "Modificar Una Venta";

        if (boton.equals(vistaIngresar) || boton.equals(vistaModificar)){
            vistaPrincipalComponent.cambiarVista(boton);
        } else if (e.getSource() == panelBusquedasTemplate.getBtnBuscar()){
            idProducto = ((ModeloProducto)panelBusquedasTemplate.getCmbProductos().getSelectedItem()).getId();
            nombreCliente = panelBusquedasTemplate.getTxtNombreCliente().getText();
            ventasFiltradas = daoVenta.getFilteredArtPieces(idProducto, nombreCliente);
            vistaPrincipalComponent.enviarDatosATabla(ventasFiltradas);
        } 
    }

}
