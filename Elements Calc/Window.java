import javax.swing.*;
import javax.swing.event.MouseInputListener;

import java.awt.*;
import java.awt.event.*;

public class Window extends Canvas{
    public JFrame frame;

    private JButton[] buttons = {new JButton("Ok"), new JButton("No")};

    public Window(int width, int height, String title, Main game){
        frame = new JFrame(title);

        MyMouseWheelListener mouseWheel = new MyMouseWheelListener(game, this);
        MyMouseListener mouseClick = new MyMouseListener(game, this);
        ButtonHandler buttonHandler = new ButtonHandler(game);

        setupButtons(buttonHandler);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.add(game);

        //frame.addMouseListener((MouseInputListener) mouseClick);
        game.addMouseListener(mouseClick);
        //game.addKeyListener(input);
        game.addMouseWheelListener(mouseWheel);
        game.start();
    }

    private void setupButtons(ActionListener buttonHandler){
        buttons[0].setBounds(50, Constants.HEIGHT-175, 200, 100);
        buttons[0].setActionCommand();

        buttons[1].setBounds(300, Constants.HEIGHT-175, 200, 100);
        buttons[1].setActionCommand();

        for(int i = 0; i < buttons.length; i++){
            buttons[i].addActionListener(buttonHandler);
        }

        for(int i = 0; i < buttons.length; i++){
            frame.add(buttons[i]);
        }
    }

    public void closeWindow(){
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
}