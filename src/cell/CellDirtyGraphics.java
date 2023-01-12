package cell;

import game.MinesweeperSettings;

import java.awt.Color;
import java.awt.Graphics;


public class CellDirtyGraphics implements ICellGraphics {

	private MinesweeperSettings settings = MinesweeperSettings.getMinesweeperSettings();

	@Override
	public void draw(int x, int y, int cellValue, Graphics graphics, int status) {
		if (status == 2) {
			graphics.setColor(Color.black);
			graphics.drawRect(settings.getCellWidth()*x, settings.getCellHeight()*y,
					settings.getCellWidth(), settings.getCellHeight());
			graphics.drawString(String.valueOf(cellValue), x*settings.getCellWidth(),
					y*settings.getCellHeight()+settings.getCellHeight());
		}
	}

}
