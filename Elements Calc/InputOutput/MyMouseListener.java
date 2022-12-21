package InputOutput;
import java.awt.Color;
import java.awt.Point;
import javax.swing.JComponent;
import javax.swing.event.MouseInputListener;

import Core.Main;

public class MyMouseListener extends JComponent implements MouseInputListener{
    private Main main;
    private Window window;

    public MyMouseListener(Main main, Window window){
        this.main = main;
        this.window = window;
    }
    
    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        Point mousePos = window.getMousePos();

        for(int i = 0; i < main.table.table.length; i++){
            if(main.table.table[i].checkWithinButton(mousePos)){
                main.table.table[i].click();
            }
        }
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        Point mousePos = window.getMousePos();

    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        Point mousePos = window.getMousePos();

    }

    @Override
    public void mouseDragged(java.awt.event.MouseEvent arg0) {
        
    }

    @Override
    public void mouseMoved(java.awt.event.MouseEvent arg0) {
        
    }

}