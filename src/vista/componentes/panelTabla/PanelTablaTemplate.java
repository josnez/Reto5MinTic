package vista.componentes.panelTabla;

import java.awt.Font;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class PanelTablaTemplate extends JPanel {

    private JTable tabla;
    private JScrollPane scrollTabla;
    private Color colorFuenteN;

    public PanelTablaTemplate() {

        String nombreFuente = "Comic Sans MS";
        colorFuenteN = new Color(12, 36, 47);

        tabla = new JTable();

        scrollTabla = new JScrollPane(tabla);
        scrollTabla.setSize(800, 300);

        this.setSize(800, 300);
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(46, 46, 46)),
                "Registros", SwingConstants.LEFT, 0, new Font(nombreFuente, Font.PLAIN, 17), colorFuenteN));
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

}
