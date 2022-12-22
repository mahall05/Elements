import java.awt.event.*;;

public class ButtonHandler implements ActionListener{
    private Calculator calc = new Calculator();

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String command = e.getActionCommand();

        switch(command){
            case("First"):
                break;
            case("Second"):
                break;
            default:
                break;
        }
        e.getActionCommand();
    }
    
}
