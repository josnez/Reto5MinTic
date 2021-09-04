package vista.componentes.panelIngresarCliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.VistaPrincipalComponent;

public class PanelIngresarClienteComponent implements ActionListener {

    private PanelIngresarClienteTemplate panelIngresarClienteTemplate;
    private VistaPrincipalComponent vistaPrincipalComponent;
    
    public PanelIngresarClienteComponent(VistaPrincipalComponent vistaPrincipalComponent) {

        panelIngresarClienteTemplate = new PanelIngresarClienteTemplate(this);
        this.vistaPrincipalComponent = vistaPrincipalComponent;
    }

    public PanelIngresarClienteTemplate gPanelIngresarClienteTemplate() {
        return panelIngresarClienteTemplate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String comando = e.getActionCommand();
        String vista = "Ir a Búsquedas";
        if (comando.equals(vista)){
            vistaPrincipalComponent.cambiarVista(vista);
        }
    }
    
}
