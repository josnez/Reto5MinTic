package view;

import controlador.DatosIniciales;
import view.componentes.barraSuperior.BarraSuperiorComponent;
import view.componentes.panelBusquedas.PanelBusquedasComponent;
import view.componentes.panelIngresarCliente.PanelIngresarClienteComponent;
import view.componentes.panelTabla.PanelTablaComponent;

public class VistaPrincipalComponent {
    
    private VistaPrincipalTemplate vistaPrincipalTemplate;
    private BarraSuperiorComponent barraSuperiorComponent;
    private PanelBusquedasComponent panelBusquedasComponent;
    private PanelIngresarClienteComponent panelIngresarClienteComponent;
    private PanelTablaComponent panelTablaComponent;
    private DatosIniciales datosIniciales;

    public VistaPrincipalComponent() {

        datosIniciales = new DatosIniciales();
        vistaPrincipalTemplate = new VistaPrincipalTemplate();
        barraSuperiorComponent = new BarraSuperiorComponent(this);
        panelBusquedasComponent = new PanelBusquedasComponent(this, datosIniciales);
        panelIngresarClienteComponent = new PanelIngresarClienteComponent(this, datosIniciales);
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
            vistaPrincipalTemplate.gPMedio().add(panelIngresarClienteComponent.gPanelIngresarClienteTemplate());
        } else {
            vistaPrincipalTemplate.gPMedio().add(panelBusquedasComponent.gPanelBusquedasTemplate());
        }
        vistaPrincipalTemplate.gPMedio().repaint();
    }
}
