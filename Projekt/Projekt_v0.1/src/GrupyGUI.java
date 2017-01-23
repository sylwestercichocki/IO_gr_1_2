import Calendar.CalendarGUI;
import Controlers.StateController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

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

    private StateController stateController=StateController.getStateControler();

    public GrupyGUI() {

        init();

        grupaSelected = true;
        prowadzacySelected = false;
        // list1.setListData(StateController.groups);

        DefaultListModel<String> listModel = new DefaultListModel<>();

        for (String string : stateController.groups) listModel.addElement(string);


        grupyRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button2.setEnabled(false);
                prowadzacyRadioButton.setSelected(false);
                prowadzacySelected = false;
                grupaSelected = true;
                list1.setListData(stateController.groups);



                actionLabel.setText("Wybierz grupę");
            }
        });
        prowadzacyRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button2.setEnabled(true);
                grupyRadioButton.setSelected(false);
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
        dalejButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(stateController.preference);
                dispose();

            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(stateController.preference);
            }
        });

    }

    public void init() {

        setVisible(true);
        button2.setEnabled(false);
        SPane.setPreferredSize(new Dimension(200, 150));
        SPane.setMinimumSize(new Dimension(200, 150));
        actionLabel.setText("");
        setContentPane(JPanel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(500, 300);
    }

}
