import javax.swing.*;
import java.awt.*;

public class FramePlane {
    private final JFrame frame;
    private MyPanel myPanel;
    private JComboBox floats;
    public FramePlane() {
        frame = new JFrame("Истребитель");
        frame.setSize(900, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);

        Icon left = new ImageIcon("resources\\arrowLeft.png");
        Icon right = new ImageIcon("resources\\arrowRight.png");
        Icon up = new ImageIcon("resources\\arrowUp.png");
        Icon down = new ImageIcon("resources\\arrowDown.png");

        JButton btnCreate = new JButton("Создать");
        JButton btnUp = new JButton(up);
        btnUp.setName("up");
        JButton btnDown = new JButton(down);
        btnDown.setName("down");
        JButton btnLeft = new JButton(left);
        btnLeft.setName("left");
        JButton btnRight = new JButton(right);
        btnRight.setName("right");

        frame.getContentPane().add(btnCreate);
        frame.getContentPane().add(btnUp);
        frame.getContentPane().add(btnDown);
        frame.getContentPane().add(btnLeft);
        frame.getContentPane().add(btnRight);

        btnCreate.setBounds(10, 10, 90, 30);
        btnUp.setBounds(805, 375, 30, 30);
        btnDown.setBounds(805, 410, 30, 30);
        btnLeft.setBounds(770, 410, 30, 30);
        btnRight.setBounds(840, 410, 30, 30);

        btnCreate.addActionListener(e -> setPlane());
        btnUp.addActionListener(e -> setDirection(btnUp));
        btnDown.addActionListener(e -> setDirection(btnDown));
        btnLeft.addActionListener(e -> setDirection(btnLeft));
        btnRight.addActionListener(e -> setDirection(btnRight));

        floats = new JComboBox(new String[]{"2 ракеты", "4 ракеты", "6 ракет"});
        frame.getContentPane().add(floats);
        floats.setBounds(10, 45, 90, 30);

    }

    public void addMyPanel(MyPanel panel) {
        myPanel = panel;
        frame.getContentPane().add(myPanel);
        myPanel.setBounds(0, 0, 900, 500);
        frame.repaint();
    }

    private void setDirection(JButton button) {
        String name = button.getName();
        switch (name) {
            case "up":
                myPanel.getFighter().movePlane(Direction.Up);
                break;
            case "down":
                myPanel.getFighter().movePlane(Direction.Down);
                break;
            case "left":
                myPanel.getFighter().movePlane(Direction.Left);
                break;
            case "right":
                myPanel.getFighter().movePlane(Direction.Right);
                break;
        }
        frame.repaint();

    }

    private void setPlane() {
        myPanel.setPlane(new Fighter((int) (Math.random() * 100 + 50), (int)(Math.random() * 1000 + 500), Color.RED, Color.BLUE, true, true, floats.getSelectedIndex()));
        myPanel.getFighter().setPosition((int) (Math.random() * 100 + 10), (int) (Math.random() * 100 + 10), 850, 450);
        frame.repaint();
    }
}

