package cell;

import java.awt.Graphics;

public interface ICellGraphics {

	public void setMineMatrix(int[][] mineMatrix);
	public void draw(int x, int y, Graphics graphics, boolean status);
}
