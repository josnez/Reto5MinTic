package view.componentes.panelIngresarCliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlador.DatosIniciales;
import view.VistaPrincipalComponent;

public class PanelIngresarClienteComponent implements ActionListener {

    private PanelIngresarClienteTemplate panelIngresarClienteTemplate;
    private VistaPrincipalComponent vistaPrincipalComponent;
    
    public PanelIngresarClienteComponent(VistaPrincipalComponent vistaPrincipalComponent, DatosIniciales datosIniciales) {

        panelIngresarClienteTemplate = new PanelIngresarClienteTemplate(this, datosIniciales);
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
