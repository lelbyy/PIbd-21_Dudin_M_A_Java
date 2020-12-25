import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private ITransport plane;

    public void paint(Graphics g) {
        if (plane != null) {
            plane.DrawPlane(g);
        }
    }

    public ITransport getPlane() {
        return plane;
    }

    public void setPlane(ITransport plane) {
        this.plane = plane;
    }
}