package InputOutput;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import Core.Main;

public class KeyInput extends KeyAdapter{

    private boolean[] keyDown = new boolean[1];

	private Main main;

    public KeyInput(Main main){
		this.main = main;
        for(int i = 0; i < keyDown.length; i++){
            keyDown[i] = false;
        }
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode(); // Gets the key code of the key that was pressed

        if(key == KeyEvent.VK_ESCAPE) {
        }
        
		//if(key == KeyEvent.VK_P) {game.pop.printPath();}
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_ESCAPE) {keyDown[0] = false;}
	}
}
