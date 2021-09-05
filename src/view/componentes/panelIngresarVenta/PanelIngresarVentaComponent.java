package view.componentes.panelIngresarVenta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import access.DAOVenta;
import controlador.DatosIniciales;
import models.ModeloCliente;
import models.ModeloProducto;
import models.ModeloVenta;
import view.VistaPrincipalComponent;

public class PanelIngresarVentaComponent implements ActionListener {

    private PanelIngresarVentaTemplate panelIngresarVentaTemplate;
    private VistaPrincipalComponent vistaPrincipalComponent;
    private DAOVenta daoVenta;
    private ModeloVenta venta;
    private int idVenta, idCliente, idProducto;
    private Date fecha;
    
    public PanelIngresarVentaComponent(VistaPrincipalComponent vistaPrincipalComponent, DatosIniciales datosIniciales,
            DAOVenta daoVenta) {

        panelIngresarVentaTemplate = new PanelIngresarVentaTemplate(this, datosIniciales);
        this.vistaPrincipalComponent = vistaPrincipalComponent;
        this.daoVenta = daoVenta;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String comando = e.getActionCommand();
        String vista = "Ir a Búsquedas";
        if (comando.equals(vista)) {
            vistaPrincipalComponent.cambiarVista(vista);
        } else {
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
        }
        
    }

    public void modo(String vista) {
        if (vista.equals("Ingresar Nueva Venta")) 
            panelIngresarVentaTemplate.modoIngresar();
        else
            panelIngresarVentaTemplate.modoModificar();
    }
    
    public PanelIngresarVentaTemplate gPanelIngresarClienteTemplate() {
        return panelIngresarVentaTemplate;
    }
    
}
