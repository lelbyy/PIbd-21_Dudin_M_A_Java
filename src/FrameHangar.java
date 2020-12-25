import javax.swing.*;
import java.util.Objects;
import java.util.Stack;

public class FrameHangar {
    private final JFrame frame;
    private final HangarPanel hangarPanel;
    private final Stack<Plane> planeStack;
    private final HangarCollection hangarCollection;
    private final DefaultListModel<String> hangarList;
    private final JList<String> listBoxHangars;
    private final JTextField fieldHangarName;
    private final JTextField textFieldTakePlane;

    public FrameHangar() {
        planeStack = new Stack<>();

        frame = new JFrame("Ангар");
        frame.setSize(903, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLayout(null);

        hangarCollection = new HangarCollection(900, 500);
        hangarPanel = new HangarPanel(hangarCollection);

        JButton buttonCreatePlane = new JButton("Cамолет");
        JButton buttonCreateBomberPlane = new JButton("Бомбардировщик");
        JLabel labelPlace = new JLabel("Место:");
        JLabel labelTakePlane = new JLabel("Забрать самолет:");
        textFieldTakePlane = new JTextField();
        JButton buttonMoveToList = new JButton("Поместить");
        JButton buttonGetFromList = new JButton("Получить");

        JLabel labelHangarName = new JLabel("Имя ангара");
        hangarList = new DefaultListModel<>();
        listBoxHangars = new JList<>(hangarList);
        fieldHangarName = new JTextField();
        JButton buttonAddHangar = new JButton("Добавить ангар");
        JButton buttonDelHangar = new JButton("Удалить ангар");

        frame.getContentPane().add(hangarPanel);
        frame.getContentPane().add(buttonCreatePlane);
        frame.getContentPane().add(buttonCreateBomberPlane);
        frame.getContentPane().add(labelPlace);
        frame.getContentPane().add(labelTakePlane);
        frame.getContentPane().add(textFieldTakePlane);

        frame.getContentPane().add(buttonMoveToList);
        frame.getContentPane().add(buttonGetFromList);
        frame.getContentPane().add(labelHangarName);
        frame.getContentPane().add(fieldHangarName);
        frame.getContentPane().add(buttonAddHangar);
        frame.getContentPane().add(buttonDelHangar);
        frame.getContentPane().add(listBoxHangars);

        labelHangarName.setBounds(710, 10, 170, 30);
        fieldHangarName.setBounds(710, 50, 170, 30);
        buttonAddHangar.setBounds(710, 90, 170, 30);
        listBoxHangars.setBounds(710, 130, 170, 60);
        buttonDelHangar.setBounds(710, 200, 170, 30);

        hangarPanel.setBounds(0, 0, 650, 510);
        buttonCreatePlane.setBounds(710, 240, 170, 30);
        buttonCreateBomberPlane.setBounds(710, 280, 170, 30);
        labelPlace.setBounds(710, 330, 170, 20);
        labelTakePlane.setBounds(710, 360, 170, 20);
        textFieldTakePlane.setBounds(710, 390, 170, 20);
        buttonGetFromList.setBounds(710, 420, 80, 30);
        buttonMoveToList.setBounds(800, 420, 80, 30);

        buttonCreatePlane.addActionListener(e -> createPlane());
        buttonCreateBomberPlane.addActionListener(e -> createBomberPlane());

        buttonMoveToList.addActionListener(e -> takePlane());
        buttonGetFromList.addActionListener(e -> moveToFrame());
        buttonAddHangar.addActionListener(e -> addHangar());
        buttonDelHangar.addActionListener(e -> delHangar());
        listBoxHangars.addListSelectionListener(e -> listListener());

        frame.repaint();
    }

    private void createPlane() {
        if (listBoxHangars.getSelectedIndex() >= 0) {
            JColorChooser colorDialog = new JColorChooser();
            JOptionPane.showMessageDialog(frame, colorDialog);
            if (colorDialog.getColor() != null) {
                Plane plane = new Plane((int) (Math.random() * 100 + 50), (int) (Math.random() * 1000 + 1500), colorDialog.getColor());
                if (hangarCollection.get(listBoxHangars.getSelectedValue()).plus(plane)) {
                    frame.repaint();
                } else {
                    JOptionPane.showMessageDialog(frame, "Ангар переполнен");
                }
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Ангар не выбран");
        }
    }

    private void createBomberPlane() {
        if (listBoxHangars.getSelectedIndex() >= 0) {
            JColorChooser colorDialog = new JColorChooser();
            JOptionPane.showMessageDialog(frame, colorDialog);
            if (colorDialog.getColor() != null) {
                JColorChooser otherColorDialog = new JColorChooser();
                JOptionPane.showMessageDialog(frame, otherColorDialog);
                if (otherColorDialog.getColor() != null) {
                    Plane plane = new Fighter((int) (Math.random() * 100 + 50), (int) (Math.random() * 1000 + 1500), colorDialog.getColor(), otherColorDialog.getColor(), true, true, 0, "Большие");
                    if (hangarCollection.get(listBoxHangars.getSelectedValue()).plus(plane)) {
                        frame.repaint();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Ангар переполнен");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Ангар не выбран");
        }
    }

    private void takePlane() {
        if (listBoxHangars.getSelectedIndex() >= 0) {
            if (!textFieldTakePlane.getText().equals("")) {
                try {
                    Plane plane = hangarCollection.get(listBoxHangars.getSelectedValue()).minus(Integer.parseInt(textFieldTakePlane.getText()));
                    if (plane != null) {
                        planeStack.push(plane);
                        frame.repaint();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Самолёта с таким индексом нет!");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(frame, "Самолёта с таким индексом нет!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Ангар не выбран");
        }
    }

    private void moveToFrame() {
        if (!planeStack.isEmpty()) {
            FrameFighter frameTruck = new FrameFighter();
            frameTruck.setPlane(Objects.requireNonNull(planeStack.pop()));
            frame.repaint();
        }
    }

    private void addHangar() {
        if (!fieldHangarName.getText().equals("")) {
            hangarCollection.addHangar(fieldHangarName.getText());
            reloadLevels();
            frame.repaint();
        } else {
            JOptionPane.showMessageDialog(frame, "Введите название ангара");
        }
    }

    private void delHangar() {
        if (listBoxHangars.getSelectedIndex() >= 0) {
            int result = JOptionPane.showConfirmDialog(frame, "Удалить ангар " + listBoxHangars.getSelectedValue() + "?");
            if (result == JOptionPane.YES_OPTION) {
                hangarCollection.delHangar(listBoxHangars.getSelectedValue());
                reloadLevels();
                frame.repaint();
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Ангар не выбран");
        }
    }

    private void reloadLevels() {
        int index = listBoxHangars.getSelectedIndex();

        hangarList.removeAllElements();
        int i = 0;
        for (String name : hangarCollection.keySet()) {
            hangarList.add(i, name);
            i++;
        }

        int itemsCount = hangarList.size();
        if (itemsCount > 0 && (index < 0 || index >= itemsCount)) {
            listBoxHangars.setSelectedIndex(0);
        } else if (index >= 0 && index < itemsCount) {
            listBoxHangars.setSelectedIndex(index);
        }
    }

    private void listListener() {
        hangarPanel.setSelectedItem(listBoxHangars.getSelectedValue());
        frame.repaint();
    }

}
