package vista.componentes.panelResultado;

import java.util.ArrayList;

public class PanelResultadoComponent {
    
    private PanelResultadoTemplate panelResultadoTemplate;

    public PanelResultadoComponent() {

        panelResultadoTemplate = new PanelResultadoTemplate();
    }

    public PanelResultadoTemplate gPanelResultadoTemplate() {
        return panelResultadoTemplate;
    }

}
