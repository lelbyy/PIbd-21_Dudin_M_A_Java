import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {

    private Fighter fighter;
    private Plane plane;

    public void paintComponent(Graphics g) {
        if (fighter != null){
            fighter.DrawPlane(g);
        }else {
            if (plane != null) {
                plane.DrawPlane(g);
            }
        }
    }

    public Fighter getFighter() {
        return fighter;
    }

    public void setFighter(Fighter fighter) {
        this.fighter = fighter;
        this.plane = null;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
        this.fighter = null;
    }
}