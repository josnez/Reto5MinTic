package vista.componentes.panelTabla;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PanelTablaTemplate extends JPanel {

    JTable tabla;
    JScrollPane scrollTabla;

    public PanelTablaTemplate() {

        tabla = new JTable();

        scrollTabla = new JScrollPane(tabla);
        scrollTabla.setSize(910, 150);

        this.setSize(910, 150);
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

}
