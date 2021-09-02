package vista.componentes.barraSuperior;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import vista.VistaPrincipalComponent;

public class BarraSuperiorComponent implements ActionListener, MouseListener, MouseMotionListener {

    private BarraSuperiorTemplate barraSuperiorTemplate;
    private VistaPrincipalComponent vistaPrincipalComponent;
    private int x, y;

    public BarraSuperiorComponent(VistaPrincipalComponent vistaPrincipalComponent) {
        barraSuperiorTemplate = new BarraSuperiorTemplate(this);
        this.vistaPrincipalComponent = vistaPrincipalComponent;
    }

    public BarraSuperiorTemplate gBarraSuperiorTemplate() {

        return barraSuperiorTemplate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        barraSuperiorTemplate.gBCerrar().setContentAreaFilled(true);
        barraSuperiorTemplate.gBCerrar().setBackground(new Color(14, 42, 71));
    }
    
    @Override
    public void mouseExited(MouseEvent e) {

        barraSuperiorTemplate.gBCerrar().setContentAreaFilled(false);
    }

    @Override
    public void mouseDragged(MouseEvent arg0) {
        vistaPrincipalComponent.moverFrame(arg0.getXOnScreen() - x, arg0.getYOnScreen() - y);
    }

    @Override
    public void mouseMoved(MouseEvent arg0) {

    }
}
