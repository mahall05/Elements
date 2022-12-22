package InputOutput;
import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.*;

import Core.Main;

public class Window extends Canvas{
    private JFrame frame;
    private JButton[] buttons = {new JButton("Calculate Mass"), new JButton("No")};
    private Rectangle[] buttonBounds = {new Rectangle(50, WINDOW_HEIGHT-175, 200, 100), new Rectangle(300, WINDOW_HEIGHT-175, 200 ,100)};
    private String[] actions = {"mass", null};

    private Main main;

    private MyMouseListener mouseClick;
    private MyMouseWheelListener mouseWheel;
    private KeyInput keyListener;
    private ButtonHandler buttonHandler;

    public static final int WINDOW_WIDTH = 1500, WINDOW_HEIGHT = WIDTH/16*9;

    public Window(int width, int height, String title, Main main){
        frame = new JFrame(title);
        this.main = main;

        setupInput();

        setupButtons();

        setupWindow(width, height);

        main.start();
    }

    public Window(String title, Main main){
        this(WINDOW_WIDTH, WINDOW_HEIGHT, title, main);
    }

    public Point getMousePos(){
        return frame.getMousePosition();
    }

    // Always call this in the constructor
    private void setupWindow(int width, int height){
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.add(main);
    }

    // Call this method if buttons need to be added
    private void setupButtons(){
        for(int i = 0; i < buttons.length; i++){
            buttons[i].setBounds(buttonBounds[i]);
            buttons[i].addActionListener(buttonHandler);
            buttons[i].setActionCommand(actions[i]);
            frame.add(buttons[i]);
        }
    }

    // Always call this method in the constructor
    private void setupInput(){
        mouseClick = new MyMouseListener(main, this);
        mouseWheel = new MyMouseWheelListener(main, this);
        keyListener = new KeyInput(main);

        frame.addMouseListener(mouseClick);
        main.addMouseListener(mouseClick);
        frame.addMouseWheelListener(mouseWheel);
        main.addMouseWheelListener(mouseWheel);
        frame.addKeyListener(keyListener);
        main.addKeyListener(keyListener);
    }

    public void closeWindow(){
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
}