package view;

import java.util.List;

import javax.swing.JOptionPane;

import access.DAOCliente;
import access.DAOProducto;
import access.DAOVenta;
import controller.DatosIniciales;
import models.ModeloVenta;
import view.componentes.barraSuperior.BarraSuperiorComponent;
import view.componentes.panelBusquedas.PanelBusquedasComponent;
import view.componentes.panelIngresar_ModificarVenta.PanelIngresar_ModificarVentaComponent;
import view.componentes.panelTabla.PanelTablaComponent;

public class VistaPrincipalComponent {

    private VistaPrincipalTemplate vistaPrincipalTemplate;
    private BarraSuperiorComponent barraSuperiorComponent;
    private PanelBusquedasComponent panelBusquedasComponent;
    private PanelIngresar_ModificarVentaComponent panelIngresarClienteComponent;
    private PanelTablaComponent panelTablaComponent;
    private DatosIniciales datosIniciales;
    private DAOVenta daoVenta;
    private DAOCliente daoCliente;
    private DAOProducto daoProducto;

    public VistaPrincipalComponent() {

        datosIniciales = new DatosIniciales();
        daoVenta = new DAOVenta();
        daoCliente = new DAOCliente();
        daoProducto = new DAOProducto();
        vistaPrincipalTemplate = new VistaPrincipalTemplate();
        barraSuperiorComponent = new BarraSuperiorComponent(this);
        panelBusquedasComponent = new PanelBusquedasComponent(this, datosIniciales, daoVenta);
        panelIngresarClienteComponent = new PanelIngresar_ModificarVentaComponent(this, datosIniciales, daoVenta);
        panelTablaComponent = new PanelTablaComponent(datosIniciales);
        vistaPrincipalTemplate.gPBarraSuperior().add(barraSuperiorComponent.gBarraSuperiorTemplate());
        vistaPrincipalTemplate.gPMedio().add(panelBusquedasComponent.gPanelBusquedasTemplate());
        vistaPrincipalTemplate.gPDatos().add(panelTablaComponent.gPanelTablaTemplate());
        vistaPrincipalTemplate.repaint();
    }

    public VistaPrincipalTemplate gVistaPrincipalTemplate() {
        return vistaPrincipalTemplate;
    }

    public void moverFrame(int i, int j) {
        vistaPrincipalTemplate.moverFrame(i, j);
    }

    public void cambiarVista(String vista) {
        vistaPrincipalTemplate.gPMedio().removeAll();
        if (vista.equals("Ingresar Nueva Venta")) {
            panelIngresarClienteComponent.modo();
            vistaPrincipalTemplate.gPMedio().add(panelIngresarClienteComponent.gPanelIngresarClienteTemplate());
        } else if (vista.equals("Modificar Una Venta")) {
            int fila = obtenerFilaSeleccionada();
            if (fila != -1) {

                ModeloVenta venta = datosIniciales.getVentas().get(fila);
                panelIngresarClienteComponent.modo(venta, daoCliente.getCliente(venta.getIdCliente()),
                        daoProducto.getProducto(venta.getIdProducto()));

                vistaPrincipalTemplate.gPMedio().add(panelIngresarClienteComponent.gPanelIngresarClienteTemplate());
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una venta");
                vistaPrincipalTemplate.gPMedio().add(panelBusquedasComponent.gPanelBusquedasTemplate());
            }
        } else {

            vistaPrincipalTemplate.gPMedio().add(panelBusquedasComponent.gPanelBusquedasTemplate());
        }
        vistaPrincipalTemplate.gPMedio().repaint();
    }

    public void enviarDatosATabla(List<ModeloVenta> ventas) {
        panelTablaComponent.enviarDatosATabla(ventas);
    }

    public int obtenerFilaSeleccionada() {
        return panelTablaComponent.gPanelTablaTemplate().getTabla().getSelectedRow();
    }

    public void eliminarVenta() {
        ModeloVenta ventaAEliminar = (ModeloVenta)datosIniciales.getVentas().get(obtenerFilaSeleccionada());
        daoVenta.eliminarVenta(ventaAEliminar);
        enviarDatosATabla(daoVenta.getAllVentas());
    }
}
