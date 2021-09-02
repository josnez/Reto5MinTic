package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VistaPrincipalTemplate extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JPanel pBarraSuperior, pCentral, pRecorridos;
    
    public VistaPrincipalTemplate() {

        crearPaneles();

        this.setSize(910, 410);
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

        pCentral = new JPanel();
        pCentral.setBounds(0, 50, 910, 360);
        pCentral.setLayout(null);
        this.add(pCentral);

        pRecorridos = new JPanel();
        pRecorridos.setBounds(0, 410, 910, 275);
        pRecorridos.setLayout(null);
        pRecorridos.setVisible(false);
        this.add(pRecorridos);
    }

    public void aumentarFrame() {
        this.setLocation(this.getX(), this.getY() - 125);
        this.setSize(this.getWidth(), this.getHeight() + 275);
        pRecorridos.setVisible(true);
    }

    public void disminuirFrame() {
        this.setLocation(this.getX(), this.getY() + 125);
        this.setSize(this.getWidth(), this.getHeight() - 275);
        pRecorridos.setVisible(false);
    }

    public JPanel gPBarraSuperior() {
        return pBarraSuperior;
    }

    public JPanel gPCentral() {
        return pCentral;
    }

    public JPanel gPRecorridos() {
        return pRecorridos;
    }

	public void moverFrame(int i, int j) {

        this.setLocation(i, j);
	}
}
