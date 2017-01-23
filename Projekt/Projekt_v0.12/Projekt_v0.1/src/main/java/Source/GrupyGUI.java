package main.java.Source;

import Calendar.CalendarGUI;
import Calendar.ClassRoom;
import Controlers.StateController;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Sylwek on 2016-12-08.
 */
public class GrupyGUI extends JFrame {
    private JRadioButton grupyRadioButton;
    private JRadioButton prowadzacyRadioButton;
    private JPanel JPanel1;
    private JPanel JPanel2;
    private JScrollPane SPane;
    private JButton dalejButton;
    private JList list1;
    private JLabel actionLabel;
    private JButton button1;
    private JButton button2;

    private boolean prowadzacySelected;
    private boolean grupaSelected;
    private boolean dalej;

    public boolean isGrupaSelected() {
        return grupaSelected;
    }

    public boolean isProwadzacySelected() {
        return prowadzacySelected;
    }


    public boolean isDalej() {
        return dalej;
    }

    private StateController stateController = StateController.getStateControler();

    public GrupyGUI() {

        init();

        grupaSelected = false;
        prowadzacySelected = false;
        // list1.setListData(StateController.groups);

        DefaultListModel<String> listModel = new DefaultListModel<>();

        for (String string : stateController.groups) listModel.addElement(string);


        grupyRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button1.setEnabled(false);
                button2.setEnabled(false);
                prowadzacyRadioButton.setSelected(false);
                grupyRadioButton.setSelected(true);
                prowadzacySelected = false;
                grupaSelected = true;
                list1.setListData(stateController.groups);


                actionLabel.setText("Wybierz grupę");
            }
        });
        prowadzacyRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button1.setEnabled(false);
                button2.setEnabled(false);
                grupyRadioButton.setSelected(false);
                prowadzacyRadioButton.setSelected(true);
                prowadzacySelected = true;
                grupaSelected = false;
                list1.setListData(stateController.profs);

                actionLabel.setText("Wybierz prowadzącego");

                //wyswietlanie prowadzacych
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //przekazanie wybranej grupy/prowadzacego
                //nowe okno

                if (grupaSelected && !list1.isSelectionEmpty()) {
                    stateController.setGroup(list1.getSelectedIndex());
                    CalendarGUI calendarGUI = new CalendarGUI(GrupyGUI.this);
                    setVisible(false);


                } else if (prowadzacySelected && !list1.isSelectionEmpty()) {
                    stateController.setProf(list1.getSelectedIndex());
                    CalendarGUI calendarGUI = new CalendarGUI(GrupyGUI.this);
                    setVisible(false);

                }


            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stateController.setProf(list1.getSelectedIndex());
                ClassRoom classRoom = new ClassRoom(GrupyGUI.this);
                setVisible(false);
            }
        });


        dalejButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] options = {"Yes", "No"};
                int n = JOptionPane.showOptionDialog(JPanel1,
                        "Czy chcesz kontynuowac?",
                        "Warning",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        options,
                        options[1]);
                System.out.println(stateController.preference);

                if (n == 0)
                    dispose();

            }
        });

        ListSelectionModel listSelectionModel = list1.getSelectionModel();
        listSelectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                ListSelectionModel lsm = (ListSelectionModel) e.getSource();
                if (!lsm.isSelectionEmpty()) {
                    if (prowadzacySelected) {
                        button1.setEnabled(true);
                        button2.setEnabled(true);
                    }
                    if (grupaSelected) {
                        button1.setEnabled(true);
                        button2.setEnabled(false);
                    }
                } else {
                    button1.setEnabled(false);
                    button2.setEnabled(false);
                }
            }
        });
    }

    public void init() {

        setVisible(true);
        button1.setEnabled(false);
        button2.setEnabled(false);
        SPane.setPreferredSize(new Dimension(200, 150));
        SPane.setMinimumSize(new Dimension(200, 150));
        actionLabel.setText("");
        setContentPane(JPanel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(500, 300);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        JPanel1 = new JPanel();
        JPanel1.setLayout(new GridLayoutManager(3, 2, new Insets(0, 0, 0, 0), -1, -1));
        JPanel2 = new JPanel();
        JPanel2.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        JPanel1.add(JPanel2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        grupyRadioButton = new JRadioButton();
        grupyRadioButton.setText("Grupy");
        JPanel2.add(grupyRadioButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        prowadzacyRadioButton = new JRadioButton();
        prowadzacyRadioButton.setText("Prowadzacy");
        JPanel2.add(prowadzacyRadioButton, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        JPanel2.add(spacer1, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        JPanel1.add(panel1, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        SPane = new JScrollPane();
        SPane.setVerticalScrollBarPolicy(22);
        panel1.add(SPane, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        list1 = new JList();
        list1.setLayoutOrientation(0);
        list1.setMinimumSize(new Dimension(300, 300));
        SPane.setViewportView(list1);
        final Spacer spacer2 = new Spacer();
        panel1.add(spacer2, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer3 = new Spacer();
        panel1.add(spacer3, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(1, 4, new Insets(0, 0, 0, 0), -1, -1));
        JPanel1.add(panel2, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        dalejButton = new JButton();
        dalejButton.setText("Dalej");
        panel2.add(dalejButton, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer4 = new Spacer();
        panel2.add(spacer4, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        button1 = new JButton();
        button1.setLabel("Godziny");
        button1.setText("Godziny");
        panel2.add(button1, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        button2 = new JButton();
        button2.setLabel("Sale");
        button2.setText("Sale");
        panel2.add(button2, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        actionLabel = new JLabel();
        actionLabel.setText("Label");
        JPanel1.add(actionLabel, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return JPanel1;
    }
}
