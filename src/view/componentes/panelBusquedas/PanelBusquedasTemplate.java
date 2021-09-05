package view.componentes.panelBusquedas;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controlador.DatosIniciales;
import models.ModeloProducto;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

public class PanelBusquedasTemplate extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private JLabel lblProductos, lblNombreCliente;
    private JButton btnBuscar, btnIngresarNuevaVenta, btnModificarUnaVenta, btnEliminarUnaVenta;
    private JTextField txtNombreCliente;
    private JComboBox<ModeloProducto> cmbProductos;
    private Color colorFuenteN;

    private Font fuente16, fuente, fuenteG;

    public PanelBusquedasTemplate(PanelBusquedasComponent panelBusquedasComponent, DatosIniciales datosIniciales) {

        String nombreFuente = "Comic Sans MS";
        fuenteG = new Font(nombreFuente, Font.PLAIN, 17);
        fuente16 = new Font(nombreFuente, Font.BOLD, 16);
        fuente = new Font(nombreFuente, Font.BOLD, 15);
        colorFuenteN = new Color(12, 36, 47);

        lblProductos = new JLabel("Productos:");
        lblProductos.setBounds(40, 30, 140, 30);
        lblProductos.setHorizontalAlignment(SwingConstants.RIGHT);
        lblProductos.setFont(fuente);
        this.add(lblProductos);

        cmbProductos = new JComboBox<>();
        cmbProductos.setBounds(185, 30, 150, 30);
        cmbProductos.setFont(fuente);
        cmbProductos.setModel(new DefaultComboBoxModel<>(
                datosIniciales.getProductos().toArray(new ModeloProducto[datosIniciales.getProductos().size()])));
        this.add(cmbProductos);

        lblNombreCliente = new JLabel("Nombre del cliente:");
        lblNombreCliente.setBounds(35, 80, 145, 30);
        lblNombreCliente.setFont(fuente);
        lblNombreCliente.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(lblNombreCliente);

        txtNombreCliente = new JTextField();
        txtNombreCliente.setBounds(185, 80, 150, 30);
        txtNombreCliente.setFont(fuente);
        txtNombreCliente.setForeground(colorFuenteN);
        txtNombreCliente.setBackground(null);
        txtNombreCliente.setHorizontalAlignment(SwingConstants.CENTER);
        txtNombreCliente.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        this.add(txtNombreCliente);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(360, 55, 100, 25);
        btnBuscar.setFont(fuente16);
        btnBuscar.setFocusable(false);
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setBackground(new Color(46, 46, 46));
        btnBuscar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(panelBusquedasComponent);
        this.add(btnBuscar);

        btnIngresarNuevaVenta = new JButton("Ingresar Nueva Venta");
        btnIngresarNuevaVenta.setBounds(550, 30, 210, 25);
        btnIngresarNuevaVenta.setFont(fuente16);
        btnIngresarNuevaVenta.setFocusable(false);
        btnIngresarNuevaVenta.setForeground(Color.WHITE);
        btnIngresarNuevaVenta.setBackground(new Color(46, 46, 46));
        btnIngresarNuevaVenta.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnIngresarNuevaVenta.addActionListener(panelBusquedasComponent);
        this.add(btnIngresarNuevaVenta);

        btnModificarUnaVenta = new JButton("Modificar Una Venta");
        btnModificarUnaVenta.setBounds(550, 65, 210, 25);
        btnModificarUnaVenta.setFont(fuente16);
        btnModificarUnaVenta.setFocusable(false);
        btnModificarUnaVenta.setForeground(Color.WHITE);
        btnModificarUnaVenta.setBackground(new Color(46, 46, 46));
        btnModificarUnaVenta.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnModificarUnaVenta.addActionListener(panelBusquedasComponent);
        this.add(btnModificarUnaVenta);

        btnEliminarUnaVenta = new JButton("Eliminar Una Venta");
        btnEliminarUnaVenta.setBounds(550, 100, 210, 25);
        btnEliminarUnaVenta.setFont(fuente16);
        btnEliminarUnaVenta.setFocusable(false);
        btnEliminarUnaVenta.setForeground(Color.WHITE);
        btnEliminarUnaVenta.setBackground(new Color(46, 46, 46));
        btnEliminarUnaVenta.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnEliminarUnaVenta.addActionListener(panelBusquedasComponent);
        this.add(btnEliminarUnaVenta);

        this.setSize(800, 150);
        this.setLayout(null);
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(46, 46, 46)),
                "Realiazar busqueda", SwingConstants.LEFT, 0, fuenteG, colorFuenteN));
        this.setBackground(new Color(208, 217, 232));
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public JButton getBtnIngresarNuevaVenta() {
        return btnIngresarNuevaVenta;
    }

    public JTextField getTxtNombreCliente() {
        return txtNombreCliente;
    }

    public JComboBox<ModeloProducto> getCmbProductos() {
        return cmbProductos;
    }

}
