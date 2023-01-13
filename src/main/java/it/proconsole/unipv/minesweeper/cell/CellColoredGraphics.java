package it.proconsole.unipv.minesweeper.cell;

import it.proconsole.unipv.minesweeper.game.MinesweeperSettings;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Una grafica di test per rappresentare le celle
 * @author Carlo
 *
 */
public class CellColoredGraphics implements ICellGraphics {

	private MinesweeperSettings settings = MinesweeperSettings.getMinesweeperSettings();
	
	@Override
	public void draw(int x, int y, int cellValue, Graphics graphics, int status) {
		if (status == 2) {
			if (cellValue==settings.getMineValue()) {
				drawMineCell(x, y, graphics);
			}else {
				drawSafeCell(x, y, graphics);
			}
			graphics.setColor(Color.black);
			graphics.drawString(String.valueOf(cellValue), x*settings.getCellWidth(),
					y*settings.getCellHeight()+settings.getCellHeight());
		}else if (status == 1) {
			drawCautionCell(x, y, graphics);
		}else if (true){
			graphics.setColor(Color.black);
			graphics.drawRect(settings.getCellWidth()*x, settings.getCellHeight()*y,
					settings.getCellWidth(), settings.getCellHeight());
		}
	}

	private void drawCautionCell(int x, int y, Graphics graphics) {
		graphics.setColor(Color.YELLOW);
		graphics.fillRect(settings.getCellWidth()*x, settings.getCellHeight()*y,
				settings.getCellWidth(), settings.getCellHeight());
	}

	private void drawSafeCell(int x, int y, Graphics graphics) {
		graphics.setColor(Color.GREEN);
		graphics.fillRect(settings.getCellWidth()*x, settings.getCellHeight()*y,
				settings.getCellWidth(), settings.getCellHeight());
	}
	private void drawMineCell(int x, int y, Graphics graphics) {
		graphics.setColor(Color.red);
		graphics.fillRect(settings.getCellWidth()*x, settings.getCellHeight()*y,
				settings.getCellWidth(), settings.getCellHeight());
	}
}
