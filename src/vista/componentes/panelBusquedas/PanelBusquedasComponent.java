package vista.componentes.panelBusquedas;

import java.util.ArrayList;

public class PanelBusquedasComponent {
    
    private PanelBusquedasTemplate panelResultadoTemplate;

    public PanelBusquedasComponent() {

        panelResultadoTemplate = new PanelBusquedasTemplate();
    }

    public PanelBusquedasTemplate gPanelResultadoTemplate() {
        return panelResultadoTemplate;
    }

}
