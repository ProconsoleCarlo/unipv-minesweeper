package utils;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Un generico elemento disegnabile
 * 
 * @author Alessandro
 */
public interface ICellaPrototype {

	public ICellaPrototype clone() throws CloneNotSupportedException;
	public void setX(int x);
	public int getX();
	public void setY(int y);
	public int getY();
	public void setColor(Color color);
	public void setContents(int contents);
	public int getContents();
	public void showContents();
	public boolean isIn(int mouseX, int mouseY, boolean isIn, int x, int y);
	/**
	 * Disegna questo disegnabile su un Graphics
	 * 
	 * @param graphics Il Graphics su cui disegnare
	 */
	public void draw(Graphics graphics);
}
