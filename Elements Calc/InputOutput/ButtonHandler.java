package InputOutput;
import java.awt.event.*;

import javax.swing.JOptionPane;

import Chemistry.Calculator;

public class ButtonHandler implements ActionListener{
    private Calculator calc = new Calculator();

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String command = e.getActionCommand();

        switch(command){
            case("mass"):
                String formula = JOptionPane.showInputDialog("Enter chemical formula");
                break;
            case("Second"):
                break;
            default:
                break;
        }
        e.getActionCommand();
    }
    
}
