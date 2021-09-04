package vista.componentes.panelTabla;

public class PanelTablaComponent {

    private PanelTablaTemplate panelTablaTemplate;
    
    public PanelTablaComponent() {

        panelTablaTemplate = new PanelTablaTemplate();
    }

    public PanelTablaTemplate gPanelTablaTemplate() {
        return panelTablaTemplate;
    }
    
}
