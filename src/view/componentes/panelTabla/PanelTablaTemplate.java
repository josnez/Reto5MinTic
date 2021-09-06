package view.componentes.panelTabla;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.List;
import models.ModeloVenta;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import controller.DatosIniciales;

import javax.swing.plaf.basic.BasicScrollBarUI;

public class PanelTablaTemplate extends JPanel {

    private JTable tabla;
    private JScrollPane scrollTabla;
    private Color colorFuenteN, colorNegroClaro;
    private String[] encabezados = { "ID Venta", "Fecha", "Nombre", "Apellido", "Telefono", "Referencia", "Costo" };
    private DefaultTableModel modeloDeTabla;

    public PanelTablaTemplate(DatosIniciales datosIniciales) {

        String nombreFuente = "Comic Sans MS";
        colorFuenteN = new Color(12, 36, 47);
        colorNegroClaro = new Color(46, 46, 46);

        tabla = new JTable();
        tabla.setRowHeight(25);
        tabla.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            private static final long serialVersionUID = -8946942932242371111L;

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                JLabel celda = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
                        column);
                celda.setOpaque(true);
                celda.setFont(new Font(nombreFuente, Font.BOLD, 13));
                celda.setForeground(new Color(80, 80, 80));
                celda.setHorizontalAlignment(SwingConstants.CENTER);
                if (row % 2 != 0)
                    celda.setBackground(Color.WHITE);
                else
                    celda.setBackground(new Color(249, 246, 249));
                if (isSelected) {
                    celda.setBackground(new Color(30, 48, 90));
                    celda.setForeground(Color.WHITE);
                }
                return celda;
            }
        });

        JTableHeader header;
        header = tabla.getTableHeader();
        header.setPreferredSize(new Dimension(780, 30));
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            private static final long serialVersionUID = -8946942932242371111L;

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                JLabel celda = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
                        column);
                celda.setOpaque(true);
                celda.setFont(new Font(nombreFuente, Font.BOLD, 15));
                celda.setForeground(Color.WHITE);
                celda.setHorizontalAlignment(SwingConstants.CENTER);
                if (row % 2 != 0)
                    celda.setBackground(colorNegroClaro);
                else
                    celda.setBackground(null);
                if (isSelected) {
                    celda.setBackground(null);
                    celda.setForeground(Color.WHITE);
                }
                return celda;
            }
        });

        scrollTabla = new JScrollPane(tabla);
        scrollTabla.setLocation(10, 30);
        scrollTabla.setSize(780, 260);

        JPanel pCorner = new JPanel();
        pCorner.setBackground(colorNegroClaro);
        scrollTabla.setCorner(JScrollPane.UPPER_RIGHT_CORNER, pCorner);

        scrollTabla.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            private Dimension d = new Dimension();

            @Override
            protected JButton createDecreaseButton(int orientation) {
                JButton boton = new JButton();
                boton.setPreferredSize(d);
                return boton;
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                JButton boton = new JButton();
                boton.setPreferredSize(d);
                return boton;
            }

            @Override
            protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
                g.setColor(Color.WHITE);
                g.fillRect(r.x, r.y, r.width, r.height);
            }

            @Override
            protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                JScrollBar sb = (JScrollBar) c;
                if (!sb.isEnabled())
                    return;
                else if (isDragging)
                    g2.setPaint(new Color(30, 30, 30));
                else if (isThumbRollover())
                    g2.setPaint(Color.GRAY);
                else
                    g2.setPaint(Color.GRAY);

                if (r.width < r.height)
                    g2.fillRoundRect((r.width - 7) / 2, r.y, 7, r.height, 10, 10);
                else
                    g2.fillRoundRect(r.x, (r.height - 7) / 2, r.width, 7, 10, 10);
            }
        });

        this.add(scrollTabla);
        agregarDatosATabla(datosIniciales.getVentas());

        this.setSize(800, 300);
        this.setLayout(null);
        this.setBackground(new Color(208, 217, 232));
        this.setBorder(
                BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(46, 46, 46)),
                        "Registro de ventas", SwingConstants.LEFT, 0, new Font(nombreFuente, Font.PLAIN, 17), colorFuenteN));
    }

    public void agregarDatosATabla(List<ModeloVenta> ventas) {
        tabla.removeAll();
        modeloDeTabla = new DefaultTableModel();
        modeloDeTabla.setColumnIdentifiers(encabezados);
        this.tabla.setModel(modeloDeTabla);
        for (int i = 0; i < ventas.size(); i++) {
            modeloDeTabla.addRow(ventas.get(i).toArray());
        }
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

}
