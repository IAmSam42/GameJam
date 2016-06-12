package Controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import engine.entities.Player;

public class KeyHandler extends KeyAdapter {
	Player player;
	
	public KeyHandler(Player player){
		this.player = player;
	}
    
    public void keyPressed(KeyEvent e) {
    	int key = e.getKeyCode();
	    if(key == KeyEvent.VK_A){player.setAPressed(true);}
	    if(key == KeyEvent.VK_D){player.setDPressed(true);}
	    if(key == KeyEvent.VK_W){player.setWPressed(true);}
	    if(key == KeyEvent.VK_S){player.setSPressed(true);}
    }

    
    public void keyReleased(KeyEvent e) {
    	int key = e.getKeyCode();
    	if(key == KeyEvent.VK_A){player.setAPressed(false);}
  	    if(key == KeyEvent.VK_D){player.setDPressed(false);}
  	    if(key == KeyEvent.VK_W){player.setWPressed(false);}
  	    if(key == KeyEvent.VK_S){player.setSPressed(false);}
    }
}
