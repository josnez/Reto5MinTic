package view.componentes.panelTabla;

import java.util.List;

import controller.DatosIniciales;
import models.ModeloVenta;

public class PanelTablaComponent {

    private PanelTablaTemplate panelTablaTemplate;
    
    public PanelTablaComponent(DatosIniciales datosIniciales) {

        panelTablaTemplate = new PanelTablaTemplate(datosIniciales);
    }

    public PanelTablaTemplate gPanelTablaTemplate() {
        return panelTablaTemplate;
    }
    
    public void enviarDatosATabla(List<ModeloVenta> ventas) {
        panelTablaTemplate.agregarDatosATabla(ventas);
    }
}
