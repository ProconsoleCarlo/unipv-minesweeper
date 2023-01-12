package utils;

import java.awt.Color;
import java.awt.Graphics;

public class CellPrototype implements ICellPrototype {

	private int cellWidth = 20;
	private int cellHeight = 20;
	private int xPosition, yPosition;
	private Color color;
	private int  contents;
	private boolean isIn;
	
	public CellPrototype() {
		super();
	}
	@Override
	public CellPrototype clone() throws CloneNotSupportedException {
		return new CellPrototype();
	}
	@Override
	public void setCellPosition(int xPosition, int yPosition) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;		
	}
	@Override
	public void setContents(int contents) {
		this.contents = contents;
	}
	@Override
	public boolean isIn(int mouseX, int mouseY, boolean isIn, int xPosition, int yPosition) {
		if(mouseX>xPosition && mouseX<xPosition+cellWidth && mouseY>yPosition && mouseY<yPosition+cellHeight){
			this.isIn = true;
			return true;
		}
		return false;
	}
	@Override
	public void draw(Graphics graphics) {
		graphics.setColor(color);
		graphics.drawRect(cellWidth*xPosition, cellHeight*yPosition, cellWidth, cellHeight);
		if (isIn) {
			graphics.drawString(String.valueOf(contents), cellWidth*xPosition+5, cellHeight*yPosition+cellHeight-5);
		}
	}

}
