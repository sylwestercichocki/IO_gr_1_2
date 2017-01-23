/**
 * Created by Sylwek on 2016-12-08.
 */

import Controlers.StateController;

import javax.swing.*;
public class Sale extends JFrame {
    private JPanel panel1;
    private JList list1;
    private StateController stateController=StateController.getStateControler();
    public Sale() {
        super("Hello World");
        init();
        list1.setListData(stateController.classes);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(250, 300);
        add(panel1);
    }
    public void init(){

        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
