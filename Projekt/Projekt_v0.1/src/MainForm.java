import Calendar.CalendarGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Sylwek on 2016-12-08.
 */
public class MainForm extends JFrame{
    private JButton calendarButton;
    private JPanel panel1;
    private JButton saleButton;

    public MainForm() {
        calendarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CalendarGUI calendarGUI = new CalendarGUI(MainForm.this);

            }
        });
        saleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sale sale = new Sale();

            }
        });
    }

    public void start(){
        JFrame frame = new JFrame("GrupyGUI");

        frame.setContentPane(new MainForm().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
