package engine.entities;

import java.awt.Color;
import java.awt.Graphics;

import engine.GameObject;
import map.Map;

public class OpacityLayer extends GameObject {

	double opacity;
	public OpacityLayer(int xCoord, int yCoord, int size){
		super(xCoord, yCoord, size);
		opacity = 0;
	}
	@Override
	public void tick() {

	}
	
	public void setOpacity(double op) {
		opacity = op;
	}
	
	public double getOpacity() {
		return opacity;
	}
	
	public void spreadOpacityCorner(int prevX, int prevY, double inputOpacity, OpacityLayer[][] opacs, Map map){
		
		int x = getXCoord()/getSize();
		int y = getYCoord()/getSize();
//		System.out.println("X: "+x+"  Y: "+y+" prevX: "+prevX+"prevY: "+prevY);
		opacity = inputOpacity;
		double outputOpacity = 0;
		try{
			outputOpacity = inputOpacity*map.getTile(x, y).getTransparancy();
		} catch(ArrayIndexOutOfBoundsException e){}
		if(outputOpacity>.2){
//			System.out.println("Prev: ("+prevX+","+prevY+")  Curr:"+x+","+y+")");
//			opacs[2*x-prevX][2*y-prevY].spreadOpacityCentre(x, y, outputOpacity*.7, opacs, map);
			if(x<prevX){
				if(y<prevY){
					opacs[x-1][y-1].spreadOpacityCorner(x, y, outputOpacity, opacs, map);
					opacs[x-1][y].spreadOpacityCentre(x, y, outputOpacity, opacs, map);
					opacs[x][y-1].spreadOpacityCentre(x, y, outputOpacity, opacs, map);
				}else {
					opacs[x-1][y+1].spreadOpacityCorner(x, y, outputOpacity, opacs, map);
					opacs[x-1][y].spreadOpacityCentre(x, y, outputOpacity, opacs, map);
					opacs[x][y+1].spreadOpacityCentre(x, y, outputOpacity, opacs, map);
				}
			}else{
				if(y<prevY){
					opacs[x+1][y-1].spreadOpacityCorner(x, y, outputOpacity, opacs, map);
					opacs[x+1][y].spreadOpacityCentre(x, y, outputOpacity, opacs, map);
					opacs[x][y-1].spreadOpacityCentre(x, y, outputOpacity, opacs, map);
				}else {
					opacs[x+1][y+1].spreadOpacityCorner(x, y, outputOpacity, opacs, map);
					opacs[x+1][y].spreadOpacityCentre(x, y, outputOpacity, opacs, map);
					opacs[x][y+1].spreadOpacityCentre(x, y, outputOpacity, opacs, map);
				}
			}
		}
	}
	
	public void spreadOpacityCentre(int prevX, int prevY, double inputOpacity, OpacityLayer[][] opacs, Map map){
		int x = getXCoord()/getSize();
		int y = getYCoord()/getSize();
		opacity = inputOpacity;
		double outputOpacity = inputOpacity*map.getTile(x, y).getTransparancy();
		if(outputOpacity>.2)
			opacs[2*x-prevX][2*y-prevY].spreadOpacityCentre(x, y, outputOpacity, opacs, map);
	}
	
	@Override
	public void render(Graphics g) {
		g.setColor(new Color(0, 0, 0, (int)((1-opacity)*255)));
//		g.setColor(Color.WHITE);
//		g.drawString(""+opacity, getXCoord(), getYCoord());
		g.fillRect(getXCoord(), getYCoord(), getSize(), getSize());

	}

}
