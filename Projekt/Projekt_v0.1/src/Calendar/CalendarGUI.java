package Calendar; /**
 * Created by Sylwek on 2016-12-08.
 */

import Controlers.StateController;
import Types.Days;
import Types.HoursPreference;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class CalendarGUI extends JFrame {
    private JPanel panel1;
    private JButton button1;
    private JTable mondayJTable;
    private JTable tuesdayJTable;
    private JTable wednesdayJTable;
    private JTable thursdayJTable;
    private JTable fridayJTable;
    private JTable[] tables = {mondayJTable, tuesdayJTable, wednesdayJTable, thursdayJTable, fridayJTable};
    //private HashMap<Types.Days, boolean[]> preferences = new HashMap<>();

    private HoursPreference preferences = new HoursPreference();
    private StateController stateController=StateController.getStateControler();

    public CalendarGUI(JFrame contextFrame) {
        start();
        String[] colNames = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        int i = 0;
        for (JTable table : tables) {
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            String[] rows = {"7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21"};
            model.addColumn(colNames[i++], rows);
            DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
            defaultTableCellRenderer.setHorizontalAlignment(JLabel.CENTER);
            table.setDefaultRenderer(String.class, defaultTableCellRenderer);
            table.setModel(model);
        }

        loadFromPreference();


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadSelection();
                contextFrame.setVisible(true);
                dispose();
            }
        });
    }

    public void loadSelection() {
        Days[] days = {Days.MONDAY, Days.TUESDAY, Days.WEDNESDAY, Days.THURSDAY, Days.FRIDAY};

        int i = 0;
        for (JTable table : tables) {
            int[] selected = table.getSelectedRows();
            if (selected.length > 0) {
                Boolean[] selectedBinaryField = new Boolean[15];
                Arrays.fill(selectedBinaryField,false);
                for (int j = 0; j < selected.length; ++j)
                    selectedBinaryField[selected[j]] = true;

                preferences.addDay(days[i], selectedBinaryField);
            }

            //System.out.println(table.getColumnName(0) + Arrays.toString(selected));
            ++i;
        }

        stateController.addHours(preferences);
        //System.out.println(StateController.preference);
        setVisible(false);


    }

    public void start() {

        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1000,350));
        pack();

        setVisible(true);

    }

    private void loadFromPreference() {
        Days[] days = {Days.MONDAY, Days.TUESDAY, Days.WEDNESDAY, Days.THURSDAY, Days.FRIDAY};
        HoursPreference preference = stateController.get();


        for (int i=0;i<tables.length;i++) {

            if (preference != null && preference.isDay(days[i])) {
                Boolean[] selections = preference.getDay(days[i]);
                for (int l = 0; l < selections.length; l++) {

                    if (selections[l] != false)tables[i].addRowSelectionInterval(l, l);

                }
            }


            //System.out.println(table.getColumnName(0) + Arrays.toString(selected));

        }
    }

}

