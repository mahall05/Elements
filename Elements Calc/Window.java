import javax.swing.*;
import javax.swing.event.MouseInputListener;

import java.awt.*;
import java.awt.event.*;

public class Window extends Canvas{
    public static final int WIDTH = 1500, HEIGHT = WIDTH / 16 * 9;
    private JButton[] buttons = {new JButton("Ok"), new JButton("No")};

    private Main main;

    public JFrame frame;
    public MyMouseWheelListener mouseWheel;
    public MyMouseListener mouseClick;

    public Window(int width, int height, String title, Main main){
        this.main = main;

        frame = new JFrame(title);
        mouseWheel = new MyMouseWheelListener(main, this);
        mouseClick = new MyMouseListener(main, this);

        for(int i = 0; i < buttons.length; i++){
            frame.add(buttons[i]);
        }

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.add(main);

        buttons[0].setBounds(50, HEIGHT-175, 200, 100);
        buttons[1].setBounds(300, HEIGHT-175, 200, 100);

        //frame.addMouseListener((MouseInputListener) mouseClick);
        main.addMouseListener(mouseClick);
        //game.addKeyListener(input);
        main.addMouseWheelListener(mouseWheel);
        main.start();
    }

    public Window(String title, Main main){
        this(WIDTH, HEIGHT, title, main);
    }

    public void closeWindow(){
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
}