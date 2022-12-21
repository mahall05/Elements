package InputOutput;

import java.awt.event.*;

public class MyMouseWheelListener implements MouseWheelListener{
    private Main main;
    private Window window;

    public MyMouseWheelListener(Main main, Window window){
        this.main = main;
        this.window = window;
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        // TODO Auto-generated method stub
        //System.out.println(e.getPreciseWheelRotation());
        main.moveTable(e.getPreciseWheelRotation());
    }
    
}
