package IO;
import java.awt.event.*;

import Core.Main;

public class MyMouseWheelListener implements MouseWheelListener{
    private Main game;
    private Window window;

    public MyMouseWheelListener(Main game, Window window){
        this.game = game;
        this.window = window;
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        game.table.scroll(-e.getPreciseWheelRotation()/Math.abs(e.getPreciseWheelRotation()));
    }
}
