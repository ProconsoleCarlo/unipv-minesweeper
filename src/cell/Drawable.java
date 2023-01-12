package cell;

import java.awt.Graphics;

/**
 * Una generica cella
 * 
 * @author Alessandro
 */
public interface Drawable {

	public void setPosition(int x, int y);
	public int[] getPosition();
	public boolean isIn(int mouseX, int mouseY, boolean isIn, int x, int y);
	public void draw(Graphics graphics);
}
