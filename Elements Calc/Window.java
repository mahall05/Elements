import javax.swing.*;
import javax.swing.event.MouseInputListener;

import java.awt.*;
import java.awt.event.*;

public class Window extends Canvas{
    public JFrame frame;
    public JPanel panel;

    private JButton[] buttons = {new JButton("Ok")};

    public Window(int width, int height, String title, Main game){
        panel = new JPanel();
        frame = new JFrame();
        frame = new JFrame(title);

        for(int i = 0; i < buttons.length; i++){
            panel.add(buttons[i]);
        }

        //MyMouseListener mouseClick = new MyMouseListener(game, this);
        //KeyInput input = new KeyInput(game);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        panel.setLayout(null);

        panel.add(game);
        frame.add(panel);

        buttons[0].setBounds(50, Constants.HEIGHT-200, 200, 100);

        //frame.addMouseListener((MouseInputListener) mouseClick);
        //game.addMouseListener(mouseClick);
        //game.addKeyListener(input);
        game.start();
    }

    public void closeWindow(){
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
}