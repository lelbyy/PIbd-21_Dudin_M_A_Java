import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {

    private Fighter fighter;

    public void paintComponent(Graphics g) {
        if (fighter != null){
            fighter.draw(g);
        }
    }

    public Fighter getFighter() {
        return fighter;
    }

    public void setPlane(Fighter fighter) {
        this.fighter = fighter;
    }
}