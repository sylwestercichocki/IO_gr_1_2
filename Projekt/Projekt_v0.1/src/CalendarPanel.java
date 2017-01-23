/**
 * Created by Sylwek on 2016-12-08.
 */
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class CalendarPanel extends JPanel
{

    JButton button;
    private JTable mondayJTable=new JTable();
    private JTable tuesdayJTable=new JTable();
    private JTable wednesdayJTable=new JTable();
    private JTable thursdayJTable=new JTable();
    private JTable fridayJTable=new JTable();
    private JTable[] tables = {mondayJTable, tuesdayJTable, wednesdayJTable, thursdayJTable, fridayJTable};
    public CalendarPanel()
    {
        String[] columns = {"Monday", "Tuesday", "Wednesday", "Thursday", "Firday"};

        String[][] data = {{"7-8", "7-8", "7-8", "7-8", "7-8" },
                {"8-9","8-9","8-9","8-9","8-9"},
                {"9-10","9-10","9-10","9-10","9-10"},
                {"10-11","10-11","10-11","10-11","10-11"},
                {"11-12","11-12","11-12","11-12","11-12"},
                {"12-13","12-13","12-13","12-13","12-13"},
                {"13-14","13-14","13-14","13-14","13-14"},
                {"14-15","14-15","14-15","14-15","14-15"},
                {"15-16","15-16","15-16","15-16","15-16"},
                {"16-17","16-17","16-17","16-17","16-17"},
                {"17-18","17-18","17-18","17-18","17-18"},
                {"18-19","18-19","18-19","18-19","18-19"},
                {"19-20","19-20","19-20","19-20","19-20"}};

        String[] colNames = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        int i = 0;
        for (JTable table : tables) {
            DefaultTableModel model = new DefaultTableModel(){
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


        //jTableMon.setPreferredScrollableViewportSize(new Dimension(450, 250));
        //jTableMon.setFillsViewportHeight(true);


        JScrollPane jps1 = new JScrollPane(tables[1]);
        JScrollPane jps2 = new JScrollPane(tables[2]);
        JScrollPane jps3 = new JScrollPane(tables[3]);
        JScrollPane jps4 = new JScrollPane(tables[4]);

        add(jps1);
//        add(button);

    }

    public static void main(String[] args)
    {
        JFrame jFrame = new JFrame("CalendarPanel");
        CalendarPanel t = new CalendarPanel();
        jFrame.setSize(500, 300);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(t);
    }
}