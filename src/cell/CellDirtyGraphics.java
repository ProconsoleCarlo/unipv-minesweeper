package cell;

import game.MinesweeperSettings;

import java.awt.Color;
import java.awt.Graphics;


public class CellDirtyGraphics implements ICellGraphics {

	private MinesweeperSettings minesweeperSettings = MinesweeperSettings.getMinesweeperSettings();
	private int[][] mineMatrix;
	public CellDirtyGraphics() {
		super();
	}
	public void setMineMatrix(int[][] mineMatrix) {
		this.mineMatrix = mineMatrix;
	}

	@Override
	public void draw(int x, int y, Graphics graphics, boolean status) {
		graphics.setColor(Color.black);
		graphics.drawRect(minesweeperSettings.getCellWidth()*x, minesweeperSettings.getCellHeight()*y,
				minesweeperSettings.getCellWidth(), minesweeperSettings.getCellHeight());
		if (status) {
			graphics.drawString(String.valueOf(mineMatrix[x][y]), x*minesweeperSettings.getCellWidth(),
					y*minesweeperSettings.getCellHeight()+minesweeperSettings.getCellHeight());
		}
	}

}
