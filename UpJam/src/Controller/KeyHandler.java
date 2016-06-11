package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import engine.entities.Entities;
import engine.entities.Player;

public class KeyHandler implements KeyListener {
	Player player;
	public KeyHandler(Player player){
		this.player = player;
	}
	public void keyTyped(KeyEvent e) {
		int key = e.getKeyChar();
		switch(key){
		case KeyEvent.VK_ESCAPE:
		
		case KeyEvent.VK_SPACE:
			
		}		
    }

    
    public void keyPressed(KeyEvent e) {
    	int key = e.getKeyChar();
		switch(key){
	    case KeyEvent.VK_A:
			player.setVelX(-(int)player.getVelocityBuff()*Entities.defaultVelocity);
		case KeyEvent.VK_D:
			player.setVelX((int)player.getVelocityBuff()*Entities.defaultVelocity);
		case KeyEvent.VK_W:
			player.setVelY((int)player.getVelocityBuff()*Entities.defaultVelocity);
		case KeyEvent.VK_S:
			player.setVelY(-(int)player.getVelocityBuff()*Entities.defaultVelocity);
		}
    }
    
    public void keyReleased(KeyEvent e) {
        
    }
}
