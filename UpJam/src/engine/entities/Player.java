package engine.entities;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;

import map.Map;
import map.Tile;
import misc.Direction;
import engine.Handler;

public class Player extends Entities {
	
	private boolean aPressed = false , wPressed = false, sPressed = false, dPressed = false;
	private int playerSpeed = 2;
	private Direction direction;
	private Map map;
	


	private Handler handler;
	
	public Player(int xCoord, int yCoord, int size, Handler handler, Map map) {
		super(xCoord, yCoord, size);
		this.map = map;
		this.handler = handler;
		handler.addPlayer(this);
		direction = Direction.DOWN;

	}

	@Override
	public void tick() {
		int velY = 0;
		int velX = 0;
		int size = getSize();
		if(aPressed && !dPressed
				&& !map.getTile((int)((getXCoord()-playerSpeed+7)/size),(int)((getYCoord()+(size/2))/size)).isSolid()
				&& !map.getTile((int)((getXCoord()-playerSpeed+7)/size),(int)((getYCoord()+size)/size)).isSolid()){
			velX=-(int)(playerSpeed*getVelocityBuff());
		}
		if(!aPressed && dPressed
				&& !map.getTile((int)((getXCoord()+playerSpeed+(size-7))/size),(int)((getYCoord()+(size/2))/size)).isSolid()
				&& !map.getTile((int)((getXCoord()+playerSpeed+(size-7))/size),(int)((getYCoord()+size)/size)).isSolid()){
			velX = (int)(playerSpeed*getVelocityBuff());
		}
		if(!wPressed && sPressed 
				&& !map.getTile((int)((getXCoord()+(size/2))/size),(int)((getYCoord()+playerSpeed+size)/size)).isSolid()){
			velY = ((int)(playerSpeed*getVelocityBuff()));
		}
		if(wPressed && !sPressed && 
				!map.getTile((int)((getXCoord()+(size/2))/size), (int)((getYCoord()-playerSpeed+size/2)/size)).isSolid()){ 
			velY = -(int)(playerSpeed*getVelocityBuff());
				
		}
		setXCoord(getXCoord() + velX);
		setYCoord(getYCoord() + velY);
		
		if(wPressed){
			if(dPressed){
				direction = Direction.UPRIGHT;
			}else if (aPressed){
				direction = Direction.UPLEFT;
			} else {
				direction = Direction.UP;
			}
		} else if(sPressed){
			if(dPressed){
				direction = Direction.DOWNRIGHT;
			}else if (aPressed){
				direction = Direction.DOWNLEFT;
			} else {
				direction = Direction.DOWN;
			}	
		}
		
		//map.getTile(getXCoord()/getSize(), getYCoord()/getSize()).calculateOpacityForward(map, direction, 1.0);
	}
	

	@Override
	public void render(Graphics g) {
		
		if(wPressed){
			g.drawImage(new ImageIcon("resources/sprites/samBackSprite.png").getImage() , this.getXCoord(), this.getYCoord(), Tile.TILESIZE, Tile.TILESIZE,null);
		}else if(dPressed){
			Graphics2D g2d = (Graphics2D)g;
			g2d.drawImage(new ImageIcon("resources/sprites/sam.png").getImage() , this.getXCoord()+Tile.TILESIZE, this.getYCoord(), -Tile.TILESIZE, Tile.TILESIZE,null);
		}else{
			g.drawImage(new ImageIcon("resources/sprites/sam.png").getImage() , this.getXCoord(), this.getYCoord(), Tile.TILESIZE, Tile.TILESIZE,null);
			
		}
		
		//g.setColor(Color.DARK_GRAY);
		//g.fillRect(this.getXCoord(), this.getYCoord(), Tile.TILESIZE, Tile.TILESIZE);

	}
	
	public void setAPressed(boolean n){
		this.aPressed = n;
	}
	
	public void setWPressed(boolean n){
		this.wPressed = n;
	}
	
	public void setDPressed(boolean n){
		this.dPressed = n;
	}
	
	public void setSPressed(boolean n){
		this.sPressed = n;
	}


	public void dropTrap() {
		handler.addExtras(new Trap((((int)((getXCoord()+(Tile.TILESIZE/2))/Tile.TILESIZE))*Tile.TILESIZE)+(Tile.TILESIZE/4),(((int)((getYCoord()+(Tile.TILESIZE/2))/Tile.TILESIZE))*Tile.TILESIZE)+(Tile.TILESIZE/4),Tile.TILESIZE));	
	}
}
