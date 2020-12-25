import javax.swing.*;
import java.awt.*;

public class FrameFighter {
    private final JDialog frame;
    private GamePanel gamePanel;
    private JComboBox rockets;
    private JComboBox rocketsForm;
    public void setPlane(ITransport plane) {
        plane.SetPosition((int) (10 + Math.random() * 90), (int) (100 + Math.random() * 100), frame.getWidth(), frame.getHeight());
        gamePanel.setPlane(plane);
        frame.repaint();
    }

    public FrameFighter() {
        frame = new JDialog();
        frame.setSize(910, 500);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);

        Icon left = new ImageIcon("resources\\arrowLeft.png");
        Icon right = new ImageIcon("resources\\arrowRight.png");
        Icon up = new ImageIcon("resources\\arrowUp.png");
        Icon down = new ImageIcon("resources\\arrowDown.png");

        JButton btnCreatePlane = new JButton("Создать самолет");
        JButton btnCreateFighter = new JButton("Создать бомбардировщик");

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

        gamePanel = new GamePanel();
        frame.getContentPane().add(gamePanel);
        gamePanel.setBounds(0, 0, 900, 500);
        frame.repaint();
    }

    private void setDirection(JButton button) {
        String name = button.getName();
            switch (name) {
                case "up":
                    gamePanel.getPlane().MovePlane(Direction.Up);
                    break;
                case "down":
                    gamePanel.getPlane().MovePlane(Direction.Down);
                    break;
                case "left":
                    gamePanel.getPlane().MovePlane(Direction.Left);
                    break;
                case "right":
                    gamePanel.getPlane().MovePlane(Direction.Right);
                    break;
            }
        frame.repaint();
    }

    private void setPlane() {
        gamePanel.setPlane(new Plane(100, 1400, Color.GRAY));
        gamePanel.getPlane().SetPosition(40, 70, 900, 500);
        frame.repaint();
    }

    private void setFighter() {
        gamePanel.setPlane(new Fighter(100, 1400, Color.GRAY, Color.RED, true, true, rockets.getSelectedIndex(), rocketsForm.getSelectedItem().toString()));
        gamePanel.getPlane().SetPosition(40, 70, 900, 500);
        frame.repaint();
    }
}

