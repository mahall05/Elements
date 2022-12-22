package IO;
import javax.swing.*;
import javax.swing.event.MouseInputListener;

import Core.Main;

import java.awt.*;
import java.awt.event.*;

public class Window extends Canvas{
    public static final int WIDTH = 1500, HEIGHT = WIDTH / 16 * 9;

    private JButton[] buttons = {new JButton("Ok"), new JButton("No")};
    private Rectangle[] buttonBounds = {new Rectangle(50, HEIGHT-175, 200, 100), new Rectangle(300, HEIGHT-175, 200, 100)};
    private String[] buttonCommands = {"mass", "no"};

    private Main main;

    public JFrame frame;
    public MyMouseWheelListener mouseWheel;
    public MyMouseListener mouseClick;
    public KeyInput keyListener;

    public Window(int width, int height, String title, Main main){
        this.main = main;
        frame = new JFrame(title);
        mouseWheel = new MyMouseWheelListener(main, this);
        mouseClick = new MyMouseListener(main, this);
        keyListener = new KeyInput(main, this);

        setupButtons();
        setupFrame(width, height);
        setupInput();

        main.start();
    }

    public Window(String title, Main main){
        this(WIDTH, HEIGHT, title, main);
    }

    private void setupButtons(){
        for(int i = 0; i < buttons.length; i++){
            frame.add(buttons[i]);
            buttons[i].setBounds(buttonBounds[i]);
            buttons[i].setActionCommand(buttonCommands[i]);
        }
    }

    private void setupInput(){
        frame.addMouseListener(mouseClick);
        main.addMouseListener(mouseClick);
        frame.addMouseWheelListener(mouseWheel);
        main.addMouseWheelListener(mouseWheel);
        frame.addKeyListener(keyListener);
        main.addKeyListener(keyListener);
    }

    private void setupFrame(int width, int height){
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(main);
        frame.setVisible(true);
    }

    public void closeWindow(){
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
}