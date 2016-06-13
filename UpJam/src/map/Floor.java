package map;

import gui.Game;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Floor extends Tile {

	private Image dayImg = new ImageIcon(this.path + "floor/dayCarpet.png").getImage(); 
	private Image nightImg = new ImageIcon(this.path + "floor/nightCarpet.png").getImage(); 
	
	public Floor(int xCoord, int yCoord) {
		super(xCoord, yCoord);
		this.setSolid(false);
		transparency = .85;
	}
	

	@Override
	public void tick() {
	}
	
	@Override
	public void render(Graphics g) {
		if(Game.isDay){
			g.drawImage(dayImg, this.getXCoord(), this.getYCoord(), Tile.TILESIZE, Tile.TILESIZE, null);
		}else{
			g.drawImage(nightImg, this.getXCoord(), this.getYCoord(), Tile.TILESIZE, Tile.TILESIZE, null);
		}
	}

	
}
