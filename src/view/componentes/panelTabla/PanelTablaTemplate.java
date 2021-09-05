package view.componentes.panelTabla;

import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import models.ModeloVenta;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import controlador.DatosIniciales;

public class PanelTablaTemplate extends JPanel {

    private JTable tabla;
    private JScrollPane scrollTabla;
    private Color colorFuenteN;
    private String[] encabezados = {"ID Venta", "Fecha", "Nombre", "Apellido", "Telefono", "Referencia", "Costo"};
    private DefaultTableModel modeloDeTabla;
    public PanelTablaTemplate(DatosIniciales datosIniciales) {

        String nombreFuente = "Comic Sans MS";
        colorFuenteN = new Color(12, 36, 47);

        tabla = new JTable();        
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabla.setRowHeight(25);
        tabla.setShowHorizontalLines(false);
        tabla.setShowVerticalLines(false);
        tabla.setShowGrid(false);
        tabla.setFont(new Font(nombreFuente, Font.BOLD, 13));
        tabla.setForeground(Color.BLACK);
        tabla.setSelectionForeground(Color.WHITE);
        tabla.setSelectionBackground(new Color(77, 166, 255));
        tabla.setBorder(null);
        tabla.setAlignmentY(SwingConstants.CENTER);
        tabla.setPreferredSize(new Dimension(800, 300));
        tabla.setBackground(new Color(208, 217, 232));

        JTableHeader header;
        header = tabla.getTableHeader();
        header.setPreferredSize(null);        
        header.setOpaque(false);
        header.setBackground(Color.WHITE);
        header.setForeground(new Color(46, 46, 46));
        header.setFont(new Font(nombreFuente, Font.BOLD, 15));

        scrollTabla = new JScrollPane(tabla);
        scrollTabla.setLocation(10, 30);
        scrollTabla.setSize(780, 260);
        this.add(scrollTabla);
        agregarDatosATabla(datosIniciales.getVentas());

        this.setSize(800, 300);
        this.setLayout(null);
        this.setBackground(new Color(208, 217, 232));
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(46, 46, 46)),
                "Registros", SwingConstants.LEFT, 0, new Font(nombreFuente, Font.PLAIN, 17), colorFuenteN));
    }

    public void agregarDatosATabla(List<ModeloVenta> ventas){
        tabla.removeAll();
        modeloDeTabla = new DefaultTableModel();
        modeloDeTabla.setColumnIdentifiers(encabezados); 
        this.tabla.setModel(modeloDeTabla);
        for(int i=0; i<ventas.size(); i++){
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
