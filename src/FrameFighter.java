import javax.swing.*;
import java.awt.*;

public class FrameFighter {
    private final JFrame frame;
    private MyPanel myPanel;
    private JComboBox rockets;
    private JComboBox rocketsForm;

    public FrameFighter() {
        frame = new JFrame("Истребитель");
        frame.setSize(910, 510);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);

        Icon left = new ImageIcon("resources\\arrowLeft.png");
        Icon right = new ImageIcon("resources\\arrowRight.png");
        Icon up = new ImageIcon("resources\\arrowUp.png");
        Icon down = new ImageIcon("resources\\arrowDown.png");

        JButton btnCreatePlane = new JButton("Создать самолет");
        JButton btnCreateFighter = new JButton("Создать истребитель");

        JButton btnUp = new JButton(up);
        btnUp.setName("up");
        JButton btnDown = new JButton(down);
        btnDown.setName("down");
        JButton btnLeft = new JButton(left);
        btnLeft.setName("left");
        JButton btnRight = new JButton(right);
        btnRight.setName("right");

        frame.getContentPane().add(btnCreateFighter);
        frame.getContentPane().add(btnCreatePlane);
        frame.getContentPane().add(btnUp);
        frame.getContentPane().add(btnDown);
        frame.getContentPane().add(btnLeft);
        frame.getContentPane().add(btnRight);

        btnCreateFighter.setBounds(200, 10, 180, 30);
        btnCreatePlane.setBounds(10, 10, 180, 30);
        btnUp.setBounds(805, 375, 30, 30);
        btnDown.setBounds(805, 410, 30, 30);
        btnLeft.setBounds(770, 410, 30, 30);
        btnRight.setBounds(840, 410, 30, 30);

        btnCreateFighter.addActionListener(e -> setFighter());
        btnCreatePlane.addActionListener(e -> setPlane());
        btnUp.addActionListener(e -> setDirection(btnUp));
        btnDown.addActionListener(e -> setDirection(btnDown));
        btnLeft.addActionListener(e -> setDirection(btnLeft));
        btnRight.addActionListener(e -> setDirection(btnRight));

        rocketsForm = new JComboBox(new String[]{"Большие", "Маленькие", "Длинные"});
        frame.getContentPane().add(rocketsForm);
        rocketsForm.setBounds(200, 45, 180, 30);

        rockets = new JComboBox(new String[]{"2 ракеты", "4 ракеты", "6 ракет"});
        frame.getContentPane().add(rockets);
        rockets.setBounds(10, 45, 90, 30);

    }

    public void addMyPanel(MyPanel panel) {
        myPanel = panel;
        frame.getContentPane().add(myPanel);
        myPanel.setBounds(0, 0, 900, 500);
        frame.repaint();
    }

    private void setDirection(JButton button) {
        String name = button.getName();
        if (myPanel.getFighter() != null) {
            switch (name) {
                case "up":
                    myPanel.getFighter().MovePlane(Direction.Up);
                    break;
                case "down":
                    myPanel.getFighter().MovePlane(Direction.Down);
                    break;
                case "left":
                    myPanel.getFighter().MovePlane(Direction.Left);
                    break;
                case "right":
                    myPanel.getFighter().MovePlane(Direction.Right);
                    break;
            }
        } else {
            switch (name) {
                case "up":
                    myPanel.getPlane().MovePlane(Direction.Up);
                    break;
                case "down":
                    myPanel.getPlane().MovePlane(Direction.Down);
                    break;
                case "left":
                    myPanel.getPlane().MovePlane(Direction.Left);
                    break;
                case "right":
                    myPanel.getPlane().MovePlane(Direction.Right);
                    break;
            }
        }
        frame.repaint();

    }

    private void setPlane() {
        myPanel.setPlane(new Plane(100, 1400, Color.GRAY));
        myPanel.getPlane().setPosition(40, 70, 900, 500);
        frame.repaint();
    }

    private void setFighter() {
        myPanel.setFighter(new Fighter(100, 1400, Color.GRAY, Color.RED, true, true, rockets.getSelectedIndex(), rocketsForm.getSelectedItem().toString()));
        myPanel.getFighter().setPosition(40, 70, 900, 500);
        frame.repaint();
    }
}

