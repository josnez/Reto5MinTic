package vista;

import vista.componentes.barraSuperior.BarraSuperiorComponent;
import vista.componentes.panelResultado.PanelResultadoComponent;

public class VistaPrincipalComponent {
    
    private VistaPrincipalTemplate vistaPrincipalTemplate;
    private BarraSuperiorComponent barraSuperiorComponent;
    private PanelResultadoComponent panelResultadoComponent;

    public VistaPrincipalComponent() {

        vistaPrincipalTemplate = new VistaPrincipalTemplate();
        barraSuperiorComponent = new BarraSuperiorComponent(this);
        vistaPrincipalTemplate.gPBarraSuperior().add(barraSuperiorComponent.gBarraSuperiorTemplate());
        vistaPrincipalTemplate.repaint();
    }

    public VistaPrincipalTemplate gVistaPrincipalTemplate() {
        return vistaPrincipalTemplate;
    }

	public void moverFrame(int i, int j) {
        vistaPrincipalTemplate.moverFrame(i, j);
	}
}
