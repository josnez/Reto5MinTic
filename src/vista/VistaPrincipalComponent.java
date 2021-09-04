package vista;

import vista.componentes.barraSuperior.BarraSuperiorComponent;
import vista.componentes.panelBusquedas.PanelBusquedasComponent;

public class VistaPrincipalComponent {
    
    private VistaPrincipalTemplate vistaPrincipalTemplate;
    private BarraSuperiorComponent barraSuperiorComponent;
    private PanelBusquedasComponent panelBusquedasComponent;

    public VistaPrincipalComponent() {

        vistaPrincipalTemplate = new VistaPrincipalTemplate();
        barraSuperiorComponent = new BarraSuperiorComponent(this);
        panelBusquedasComponent = new PanelBusquedasComponent();
        vistaPrincipalTemplate.gPBarraSuperior().add(barraSuperiorComponent.gBarraSuperiorTemplate());
        vistaPrincipalTemplate.gPMedio().add(panelBusquedasComponent.gPanelResultadoTemplate());
        vistaPrincipalTemplate.repaint();
    }

    public VistaPrincipalTemplate gVistaPrincipalTemplate() {
        return vistaPrincipalTemplate;
    }

	public void moverFrame(int i, int j) {
        vistaPrincipalTemplate.moverFrame(i, j);
	}
}
