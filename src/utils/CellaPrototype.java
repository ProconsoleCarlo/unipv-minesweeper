package utils;

import java.awt.Color;
import java.awt.Graphics;

public class CellaPrototype implements ICellaPrototype {

	private int x;
	private int y;
	private int pixelWidth = 20;
	private int pixelHeight = 20;
	private Color color;
	private int contents;
	private Graphics graphics;
	
	@Override
	public void setX(int x) {
		this.x = x;		
	}
	@Override
	public int getX() {
		return x;
	}
	@Override
	public void setY(int y) {
		this.y = y;
	}
	@Override
	public int getY() {
		return y;
	}
	@Override
	public void setColor(Color color) {
		this.color = color;
	}
	@Override
	public void setContents(int contents) {
		this.contents = contents;
	}
	@Override
	public int getContents() {
		return contents;
	}
	@Override
	public void showContents() {
		System.out.println(contents);
		this.graphics.drawString(String.valueOf(contents), pixelWidth*x, pixelHeight*y+pixelHeight);
		
	}
	@Override
	public boolean isIn(int mouseX, int mouseY, boolean isIn, int x, int y) {
		if(mouseX>x && mouseX<x+pixelWidth && mouseY>y && mouseY<y+pixelHeight+10){
			return isIn = true;
		}else {
			return isIn = false;
		}
	}

	@Override
	public ICellaPrototype clone() throws CloneNotSupportedException {
		CellaPrototype cellaPrototype = new CellaPrototype();
		return cellaPrototype;
	}
	@Override
	public void draw(Graphics graphics) {
		this.graphics = graphics;
		this.graphics.setColor(color);
		this.graphics.drawRect(pixelWidth*x, pixelHeight*y, pixelWidth, pixelHeight);
		this.graphics.drawString(String.valueOf(contents), pixelWidth*x, pixelHeight*y+pixelHeight);
		
		
	}

}
