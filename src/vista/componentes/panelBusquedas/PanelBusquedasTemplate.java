package vista.componentes.panelBusquedas;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;

public class PanelBusquedasTemplate extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private JLabel lblMarcas, lblNombreCliente;
    private JButton btnBuscar;
    private JTextField txtNombreCliente;
    private JComboBox cmbMarcas;

    private Font fuente19, fuente;

    public PanelBusquedasTemplate() {

        fuente19 = new Font("Comic Sans MS", Font.BOLD, 19);
        fuente = new Font("Comic Sans MS", Font.BOLD, 15);

        lblMarcas = new JLabel("Marcas");
        lblMarcas.setBounds(40, 30, 190, 35);
        lblMarcas.setHorizontalAlignment(SwingConstants.CENTER);
        lblMarcas.setFont(fuente19);
        this.add(lblMarcas);

        this.setSize(910, 150);
        this.setLayout(null);
        this.setBackground(new Color(208, 217, 232));
    }

}
    