package view.componentes.panelIngresar_ModificarVenta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import access.DAOVenta;
import controller.DatosIniciales;
import models.ModeloCliente;
import models.ModeloProducto;
import models.ModeloVenta;
import view.VistaPrincipalComponent;

public class PanelIngresar_ModificarVentaComponent implements ActionListener {

    private PanelIngresar_ModificarVentaTemplate panelIngresarVentaTemplate;
    private VistaPrincipalComponent vistaPrincipalComponent;
    private DAOVenta daoVenta;
    private ModeloVenta venta;
    private int idVenta, idCliente, idProducto;
    private Date fecha;
    
    public PanelIngresar_ModificarVentaComponent(VistaPrincipalComponent vistaPrincipalComponent, DatosIniciales datosIniciales,
            DAOVenta daoVenta) {

        panelIngresarVentaTemplate = new PanelIngresar_ModificarVentaTemplate(this, datosIniciales);
        this.vistaPrincipalComponent = vistaPrincipalComponent;
        this.daoVenta = daoVenta;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String comando = e.getActionCommand();
        String vista = "Ir a Búsquedas";
        if (comando.equals(vista)) {
            vistaPrincipalComponent.cambiarVista(vista);
        } else if(e.getSource() == panelIngresarVentaTemplate.getbIngresarVenta()){
            idVenta = Integer.parseInt(panelIngresarVentaTemplate.gettID().getText());
            panelIngresarVentaTemplate.gettID().setText("");
            fecha = Date.valueOf(panelIngresarVentaTemplate.gettFecha().getText());
            panelIngresarVentaTemplate.gettFecha().setText("");
            idCliente = ((ModeloCliente)panelIngresarVentaTemplate.getCbxClientes().getSelectedItem()).getId();
            panelIngresarVentaTemplate.getCbxClientes().setSelectedIndex(0);   
            idProducto = ((ModeloProducto)panelIngresarVentaTemplate.getCbxProductos().getSelectedItem()).getId();
            panelIngresarVentaTemplate.getCbxProductos().setSelectedIndex(0);
            venta = new ModeloVenta(idVenta, fecha, idCliente, idProducto);
            daoVenta.insertarVenta(venta);
            vistaPrincipalComponent.enviarDatosATabla(daoVenta.getAllVentas());
        } else if(e.getSource() == panelIngresarVentaTemplate.getbModificarVenta()){
            idVenta = Integer.parseInt(panelIngresarVentaTemplate.gettID().getText());
            panelIngresarVentaTemplate.gettID().setText("");
            fecha = Date.valueOf(panelIngresarVentaTemplate.gettFecha().getText());
            panelIngresarVentaTemplate.gettFecha().setText("");
            idCliente = ((ModeloCliente)panelIngresarVentaTemplate.getCbxClientes().getSelectedItem()).getId();
            panelIngresarVentaTemplate.getCbxClientes().setSelectedIndex(0);   
            idProducto = ((ModeloProducto)panelIngresarVentaTemplate.getCbxProductos().getSelectedItem()).getId();
            panelIngresarVentaTemplate.getCbxProductos().setSelectedIndex(0);
            venta = new ModeloVenta(idVenta, fecha, idCliente, idProducto);
            daoVenta.actualizarVenta(venta);
            vistaPrincipalComponent.enviarDatosATabla(daoVenta.getAllVentas());
            vistaPrincipalComponent.cambiarVista(vista);
        }
        
    }

    public void modo(ModeloVenta venta, ModeloCliente cliente, ModeloProducto producto) {
        panelIngresarVentaTemplate.modoModificar(venta, cliente, producto);
    }

    public void modo() {
        panelIngresarVentaTemplate.modoIngresar();
    }
    
    public PanelIngresar_ModificarVentaTemplate gPanelIngresarClienteTemplate() {
        return panelIngresarVentaTemplate;
    }
    
}
