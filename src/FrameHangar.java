import javax.swing.*;

public class FrameHangar {
    private final JFrame frame;
    private final Hangar<Plane, IRocketsForm> hangar;
    private final JTextField textFieldTakePlane;

    public FrameHangar() {
        frame = new JFrame("Ангар");
        frame.setSize(903, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLayout(null);

        hangar = new Hangar<>(903, 500);

        HangarPanel hangarPanel = new HangarPanel(hangar);
        JButton buttonCreatePlane = new JButton("Создать самолет");
        JButton buttonCreateBomberPlane = new JButton("Создать истребитель");
        JButton buttonTakePlane = new JButton("Забрать");
        //JLabel labelPlace = new JLabel("Место:");
        JLabel labelTakePlane = new JLabel("Забрать самолет:");
        textFieldTakePlane = new JTextField();

        frame.getContentPane().add(hangarPanel);
        frame.getContentPane().add(buttonCreatePlane);
        frame.getContentPane().add(buttonCreateBomberPlane);
        frame.getContentPane().add(buttonTakePlane);
        //frame.getContentPane().add(labelPlace);
        frame.getContentPane().add(labelTakePlane);
        frame.getContentPane().add(textFieldTakePlane);

        hangarPanel.setBounds(0, 0, 650, 500);
        buttonCreatePlane.setBounds(710, 10, 170, 30);
        buttonCreateBomberPlane.setBounds(710, 50, 170, 30);
        //labelPlace.setBounds(710, 100, 170, 20);
        labelTakePlane.setBounds(710, 130, 170, 20);
        textFieldTakePlane.setBounds(710, 160, 170, 20);
        buttonTakePlane.setBounds(710, 190, 170, 30);

        buttonCreatePlane.addActionListener(e -> createPlane());
        buttonCreateBomberPlane.addActionListener(e -> createBomberPlane());
        buttonTakePlane.addActionListener(e -> takePlane());

        frame.repaint();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void createPlane() {
        JColorChooser colorDialog = new JColorChooser();
        JOptionPane.showMessageDialog(frame, colorDialog);
        if (colorDialog.getColor() != null) {
            Plane plane = new Plane((int) (Math.random() * 100 + 50), (int) (Math.random() * 1000 + 1500), colorDialog.getColor());
            if (hangar.plus(plane)) {
                frame.repaint();
            } else {
                JOptionPane.showMessageDialog(frame, "Аэродром переполнен");
            }
        }
    }

    private void createBomberPlane() {
        JColorChooser mainСolorDialog = new JColorChooser();
        JOptionPane.showMessageDialog(frame, mainСolorDialog);
        if (mainСolorDialog.getColor() != null) {
            JColorChooser dopColorDialog = new JColorChooser();
            JOptionPane.showMessageDialog(frame, dopColorDialog);
            if (dopColorDialog.getColor() != null) {
                Fighter plane = new Fighter((int) (Math.random() * 100 + 50), (int) (Math.random() * 1000 + 1500), mainСolorDialog.getColor(), dopColorDialog.getColor(), true, true, 0, "Большие");
                if (hangar.plus(plane)) {
                    frame.repaint();
                } else {
                    JOptionPane.showMessageDialog(frame, "Ангар переполнен");
                }
            }
        }
    }

    private void takePlane() {
        if (!textFieldTakePlane.getText().equals("")) {
            Plane plane = hangar.minus(Integer.parseInt(textFieldTakePlane.getText()));
            if (plane == null) {
                JOptionPane.showMessageDialog(frame, "Это место пусто");
            } else {
                FrameFighter frameFighter = new FrameFighter();
                frameFighter.setPlane(plane);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.repaint();

            }
        }
    }
}
