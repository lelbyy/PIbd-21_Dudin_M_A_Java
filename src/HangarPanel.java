import javax.swing.*;
import java.awt.*;

public class HangarPanel extends JPanel {
    private final Hangar<Plane, IRocketsForm> hangar;

    public void paint(Graphics g) {
        if (hangar != null) {
            hangar.Draw(g);
        }
    }

    public HangarPanel(Hangar<Plane, IRocketsForm> hangar) {
        this.hangar = hangar;
    }
}
