package view.componentes.panelTabla;

import controlador.DatosIniciales;

public class PanelTablaComponent {

    private PanelTablaTemplate panelTablaTemplate;
    
    public PanelTablaComponent(DatosIniciales datosIniciales) {

        panelTablaTemplate = new PanelTablaTemplate(datosIniciales);
    }

    public PanelTablaTemplate gPanelTablaTemplate() {
        return panelTablaTemplate;
    }
    
}
