package vista.componentes.panelBusquedas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import vista.VistaPrincipalComponent;

public class PanelBusquedasComponent implements ActionListener {
    
    private PanelBusquedasTemplate panelResultadoTemplate;
    private VistaPrincipalComponent vistaPrincipalComponent;

    public PanelBusquedasComponent(VistaPrincipalComponent vistaPrincipalComponent) {

        panelResultadoTemplate = new PanelBusquedasTemplate(this);
        this.vistaPrincipalComponent = vistaPrincipalComponent;
    }

    public PanelBusquedasTemplate gPanelBusquedasTemplate() {
        return panelResultadoTemplate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String boton = e.getActionCommand();
        String vista = "Ingresar Nueva Venta";

        if (boton.equals(vista)) {
            vistaPrincipalComponent.cambiarVista(vista);
        }
    }

}
