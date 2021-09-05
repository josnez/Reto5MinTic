package view.componentes.barraSuperior;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class BarraSuperiorTemplate extends JPanel {
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private JLabel lTitulo;
    private JButton bCerrar;
    private ImageIcon iCerrar;

    public BarraSuperiorTemplate(BarraSuperiorComponent barraSuperiorComponent) {

        lTitulo = new JLabel("Te reto a programarlo S.A.S.");
        lTitulo.setBounds( 255, 10, 350, 30);
        lTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lTitulo.setFont(new Font("Milton Keynes", Font.BOLD, 22));
        lTitulo.setForeground(Color.WHITE);
        this.add(lTitulo);

        bCerrar = new JButton();
        bCerrar.setBounds(770, 0, 30, 30);      
        bCerrar.addActionListener(barraSuperiorComponent);
        bCerrar.setFocusable(false);
        bCerrar.setContentAreaFilled(false);
        iCerrar = new ImageIcon("resources/img/cerrar.png");
        iCerrar = new ImageIcon(iCerrar.getImage().getScaledInstance(15, 15, Image.SCALE_AREA_AVERAGING));
        bCerrar.setIcon(iCerrar);
        bCerrar.setBorder(null);
        bCerrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bCerrar.addMouseListener(barraSuperiorComponent);
        this.add(bCerrar);

        this.setSize(800, 50);
        this.setLayout(null);
        this.setBackground(new Color(46, 46, 46));
        this.addMouseListener(barraSuperiorComponent);
        this.addMouseMotionListener(barraSuperiorComponent);
    }

    public JButton gBCerrar() {
        return bCerrar;
    }
}
