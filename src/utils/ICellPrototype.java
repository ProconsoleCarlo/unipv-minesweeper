package utils;

import java.awt.Graphics;

/**
 * Una generica cella
 * 
 * @author Alessandro
 */
public interface ICellPrototype {

	public ICellPrototype clone() throws CloneNotSupportedException;
	public void setCellPosition(int xPosition, int yPosition);
	public void setContents(int contents);
	public boolean isIn(int mouseX, int mouseY, boolean isIn, int x, int y);
	public void draw(Graphics graphics);
}
