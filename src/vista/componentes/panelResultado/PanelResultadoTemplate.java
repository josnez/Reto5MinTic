package vista.componentes.panelResultado;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;

public class PanelResultadoTemplate extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private JLabel lResultados;

    private Font fuente19, fuente;

    public PanelResultadoTemplate() {

        fuente19 = new Font("Comic Sans MS", Font.BOLD, 19);
        fuente = new Font("Comic Sans MS", Font.BOLD, 15);

        lResultados = new JLabel("Resultados");
        lResultados.setBounds(40, 30, 190, 35);
        lResultados.setHorizontalAlignment(SwingConstants.CENTER);
        lResultados.setFont(fuente19);
        this.add(lResultados);

        this.setSize(910, 275);
        this.setLayout(null);
        this.setBackground(new Color(208, 217, 232));
    }

}
