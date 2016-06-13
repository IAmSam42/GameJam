package map;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Wall extends Tile {
	
	
	private Image img;
	
	
	public Wall(int xCoord, int yCoord, int wallType) {
		super(xCoord, yCoord);
		this.setSolid(true);
		transparency = 0.1;
		String pathText;
		switch(wallType) {
		
		case (255 << 24) | (255 << 16) | (112 << 8) | (3):
			pathText = "wall/wallWholeUp.png";
			break;
		case (255 << 24) | (255 << 16) | (3 << 8) | (104):
			pathText = "wall/wallWholeDown.png";
			break;
		case (255 << 24) | (1 << 16) | (117 << 8) | (1):
			pathText = "wall/wallWholeLeft.png";
			break;
		case (255 << 24) | (255 << 16) | (3 << 8) | (3):
			pathText = "wall/wallWholeRight.png";
			break;
		case (255 << 24) | (247 << 16) | (255 << 8) | (3):
			pathText = "wall/wallCornerIUR.png";
			break;
		case (255 << 24) | (61 << 16) | (255 << 8) | (2):
			pathText = "wall/wallCornerIUL.png";
			break;
		case (255 << 24) | (196 << 16) | (3 << 8) | (255):
			pathText = "wall/wallCornerIDR.png";
			break;
		case (255 << 24) | (3 << 16) | (247 << 8) | (255):
			pathText = "wall/wallCornerIDL.png";
			break;
		case (255 << 24) | (255 << 16) | (0 << 8) | (228):
			pathText = "wall/wallCornerOUR.png";
			break;
		case (255 << 24) | (32 << 16) | (40 << 8) | (119):
			pathText = "wall/wallCornerOUL.png";
			break;
		case (255 << 24) | (77 << 16) | (207 << 8) | (155):
			pathText = "wall/wallCornerODR.png";
			break;
		case (255 << 24) | (82 << 16) | (63 << 8) | (72):
			pathText = "wall/wallCornerODL.png";
			break;
		default:
			pathText = null;
		}
		System.out.println(pathText);
		img = new ImageIcon(this.path + pathText).getImage();
	}
	
	
	
	@Override
	public void tick() {
	}
	

	@Override
	public void render(Graphics g) {
		g.drawImage(img, this.getXCoord(), this.getYCoord(), Tile.TILESIZE, Tile.TILESIZE, null);
	}
}
