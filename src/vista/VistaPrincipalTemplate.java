package vista;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VistaPrincipalTemplate extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JPanel pBarraSuperior, pMedio, pDatos;
    
    public VistaPrincipalTemplate() {

        crearPaneles();

        this.setSize(800, 500);
        this.setLayout(null);
        this.setLocationRelativeTo(this);
        this.setUndecorated(true);
        this.setVisible(true);
    }

    private void crearPaneles() {

        pBarraSuperior = new JPanel();
        pBarraSuperior.setBounds(0, 0, 910, 50);  
        pBarraSuperior.setLayout(null);
        this.add(pBarraSuperior);

        pMedio = new JPanel();
        pMedio.setBounds(0, 50, 910, 150);
        pMedio.setLayout(null);
        this.add(pMedio);

        pDatos = new JPanel();
        pDatos.setBounds(0, 200, 910, 300);
        pDatos.setLayout(null);
        pDatos.setBackground(Color.BLUE);

        this.add(pDatos);
    }

    public JPanel gPBarraSuperior() {
        return pBarraSuperior;
    }

    public JPanel gPMedio() {
        return pMedio;
    }

    public JPanel gPDatos() {
        return pDatos;
    }

	public void moverFrame(int i, int j) {

        this.setLocation(i, j);
	}
}
