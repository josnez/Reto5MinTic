package vista.componentes.panelBusquedas;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

public class PanelBusquedasTemplate extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private JLabel lblMarcas, lblNombreCliente;
    private JButton btnBuscar, btnIngresarNuevaCompra;
    private JTextField txtNombreCliente;
    private JComboBox cmbMarcas;
    private Color colorFuenteN, colorFuenteG;

    private Font fuente16, fuente, fuenteG;

    public PanelBusquedasTemplate(PanelBusquedasComponent panelBusquedasComponent) {

        String nombreFuente = "Comic Sans MS";
        fuenteG = new Font(nombreFuente, Font.PLAIN, 17);
        fuente16 = new Font(nombreFuente, Font.BOLD, 16);
        fuente = new Font(nombreFuente, Font.BOLD, 15);
        colorFuenteN = new Color(12, 36, 47);
        colorFuenteG = new Color(0, 0, 0);

        lblMarcas = new JLabel("Marcas:");
        lblMarcas.setBounds(40, 30, 140, 30);
        lblMarcas.setHorizontalAlignment(SwingConstants.RIGHT);
        lblMarcas.setFont(fuente);
        this.add(lblMarcas);

        cmbMarcas = new JComboBox<String>();
        cmbMarcas.setBounds(185, 30, 100, 30);
        cmbMarcas.setFont(fuente);
        this.add(cmbMarcas);

        lblNombreCliente = new JLabel("Nombre del cliente:");
        lblNombreCliente.setBounds(35, 80, 145, 30);
        lblNombreCliente.setFont(fuente);
        lblNombreCliente.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(lblNombreCliente);

        txtNombreCliente = new JTextField();
        txtNombreCliente.setBounds(185, 80, 100, 30);
        txtNombreCliente.setFont(fuente);
        txtNombreCliente.setForeground(colorFuenteN);
        txtNombreCliente.setBackground(null);
        txtNombreCliente.setHorizontalAlignment(SwingConstants.CENTER);
        txtNombreCliente.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        this.add(txtNombreCliente);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(310, 55, 100, 25);
        btnBuscar.setFont(fuente16);
        btnBuscar.setFocusable(false);
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setBackground(new Color(46, 46, 46));
        btnBuscar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(panelBusquedasComponent);
        this.add(btnBuscar);

        btnIngresarNuevaCompra = new JButton("Ingresar Nueva Venta");
        btnIngresarNuevaCompra.setBounds(550, 57, 210, 25);
        btnIngresarNuevaCompra.setFont(fuente16);
        btnIngresarNuevaCompra.setFocusable(false);
        btnIngresarNuevaCompra.setForeground(Color.WHITE);
        btnIngresarNuevaCompra.setBackground(new Color(46, 46, 46));
        btnBuscar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnIngresarNuevaCompra.addActionListener(panelBusquedasComponent);
        this.add(btnIngresarNuevaCompra);

        this.setSize(800, 150);
        this.setLayout(null);
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(46, 46, 46)),
                "Realiaza tu Busqueda", SwingConstants.LEFT, 0, fuenteG, colorFuenteN));
        this.setBackground(new Color(208, 217, 232));
    }

}
