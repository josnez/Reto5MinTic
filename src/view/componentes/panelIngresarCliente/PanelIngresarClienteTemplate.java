package view.componentes.panelIngresarCliente;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controlador.DatosIniciales;
import models.ModeloCliente;
import models.ModeloProducto;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

public class PanelIngresarClienteTemplate extends JPanel {

    private JLabel lCliente, lMoto, lFecha, lID;
    private JComboBox<ModeloCliente> cbxClientes;
    private JComboBox<ModeloProducto> cbxMotos;
    private JTextField tFecha, tID;
    private JButton bIngresarVenta, bIrABusquedas;
    private Font fuente, fuenteBotones;
    private Color colorFuenteN;

    public PanelIngresarClienteTemplate(PanelIngresarClienteComponent panelIngresarClienteComponent,
            DatosIniciales datosIniciales) {

        String nombreFuente = "Comic Sans MS";
        fuente = new Font(nombreFuente, Font.BOLD, 15);
        fuenteBotones = new Font(nombreFuente, Font.BOLD, 16);
        colorFuenteN = new Color(12, 36, 47);

        lCliente = new JLabel("Cliente:");
        lCliente.setBounds(30, 40, 70, 30);
        lCliente.setFont(fuente);
        lCliente.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(lCliente);

        cbxClientes = new JComboBox<>();
        cbxClientes.setBounds(105, 40, 100, 30);
        cbxClientes.setFont(fuente);
        cbxClientes.setModel(new DefaultComboBoxModel<>(
                datosIniciales.getClientes().toArray(new ModeloCliente[datosIniciales.getClientes().size()])));
        cbxClientes.setSelectedIndex(0);
        this.add(cbxClientes);

        lMoto = new JLabel("Moto:");
        lMoto.setBounds(30, 80, 70, 30);
        lMoto.setHorizontalAlignment(SwingConstants.RIGHT);
        lMoto.setFont(fuente);
        this.add(lMoto);

        cbxMotos = new JComboBox<>();
        cbxMotos.setBounds(105, 80, 100, 30);
        cbxMotos.setFont(fuente);
        cbxMotos.setModel(new DefaultComboBoxModel<>(
                datosIniciales.getProductos().toArray(new ModeloProducto[datosIniciales.getProductos().size()])));
        
        this.add(cbxMotos);

        lFecha = new JLabel("Fecha:");
        lFecha.setBounds(235, 40, 105, 30);
        lFecha.setHorizontalAlignment(SwingConstants.RIGHT);
        lFecha.setFont(fuente);
        this.add(lFecha);

        tFecha = new JTextField();
        tFecha.setBounds(345, 40, 100, 30);
        tFecha.setFont(fuente);
        tFecha.setForeground(colorFuenteN);
        tFecha.setBackground(null);
        tFecha.setHorizontalAlignment(SwingConstants.CENTER);
        tFecha.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        this.add(tFecha);

        lID = new JLabel("Identificador:");
        lID.setBounds(235, 80, 105, 30);
        lID.setFont(fuente);
        lID.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(lID);

        tID = new JTextField();
        tID.setBounds(345, 80, 100, 30);
        tID.setFont(fuente);
        tID.setForeground(colorFuenteN);
        tID.setBackground(null);
        tID.setHorizontalAlignment(SwingConstants.CENTER);
        tID.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        this.add(tID);

        bIngresarVenta = new JButton("Agregar");
        bIngresarVenta.setBounds(470, 65, 100, 25);
        bIngresarVenta.setFont(fuenteBotones);
        bIngresarVenta.setFocusable(false);
        bIngresarVenta.setForeground(Color.WHITE);
        bIngresarVenta.setBackground(new Color(46, 46, 46));
        bIngresarVenta.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bIngresarVenta.addActionListener(panelIngresarClienteComponent);
        this.add(bIngresarVenta);

        bIrABusquedas = new JButton("Ir a Búsquedas");
        bIrABusquedas.setBounds(625, 65, 155, 25);
        bIrABusquedas.setFont(fuenteBotones);
        bIrABusquedas.setFocusable(false);
        bIrABusquedas.setForeground(Color.WHITE);
        bIrABusquedas.setBackground(new Color(46, 46, 46));
        bIrABusquedas.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bIrABusquedas.addActionListener(panelIngresarClienteComponent);
        this.add(bIrABusquedas);

        this.setSize(800, 150);
        this.setLayout(null);
        this.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(46, 46, 46)), "Ingresar venta",
                SwingConstants.LEFT, 0, new Font(nombreFuente, Font.PLAIN, 17), colorFuenteN));
        this.setBackground(new Color(208, 217, 232));
    }
}
