import java.awt.event.*;

public class MyMouseWheelListener implements MouseWheelListener{
    private Main game;
    private Window window;

    public MyMouseWheelListener(Main game, Window window){
        this.game = game;
        this.window = window;
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        // TODO Auto-generated method stub
        //System.out.println(e.getPreciseWheelRotation());
        game.moveTable(e.getPreciseWheelRotation());
    }
    
}
