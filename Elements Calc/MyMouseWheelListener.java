import java.awt.event.*;

public class MyMouseWheelListener implements MouseWheelListener{
    private Main game;
    private Window window;

    private double wheelMovement = 0;

    public MyMouseWheelListener(Main game, Window window){
        this.game = game;
        this.window = window;
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        game.table.scroll(-e.getPreciseWheelRotation()/Math.abs(e.getPreciseWheelRotation()));

        //wheelMovement -= e.getPreciseWheelRotation();
    }
    
}
