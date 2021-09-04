package vista;

import vista.componentes.barraSuperior.BarraSuperiorComponent;
import vista.componentes.panelBusquedas.PanelBusquedasComponent;
import vista.componentes.panelIngresarCliente.PanelIngresarClienteComponent;
import vista.componentes.panelTabla.PanelTablaComponent;

public class VistaPrincipalComponent {
    
    private VistaPrincipalTemplate vistaPrincipalTemplate;
    private BarraSuperiorComponent barraSuperiorComponent;
    private PanelBusquedasComponent panelBusquedasComponent;
    private PanelIngresarClienteComponent panelIngresarClienteComponent;
    private PanelTablaComponent panelTablaComponent;

    public VistaPrincipalComponent() {

        vistaPrincipalTemplate = new VistaPrincipalTemplate();
        barraSuperiorComponent = new BarraSuperiorComponent(this);
        panelBusquedasComponent = new PanelBusquedasComponent(this);
        panelIngresarClienteComponent = new PanelIngresarClienteComponent(this);
        panelTablaComponent = new PanelTablaComponent();
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
