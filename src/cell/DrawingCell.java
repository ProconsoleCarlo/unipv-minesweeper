package cell;

import game.MinesweeperSettings;

import java.awt.Graphics;

/**
 * Una cella del campo minato
 * Implementa una logica a tre valori per il suo stato:
 * 0 = chiusa
 * 1 = segnalata
 * 2 = aperta
 * @author Carlo
 *
 */
public class DrawingCell implements Drawable {

	private int status;
	private int x, y;
	private int cellValue;
	private ICellGraphics cellGraphics;
	private MinesweeperSettings minesweeperSettings = MinesweeperSettings.getMinesweeperSettings();
	public DrawingCell(int status, ICellGraphics cellGraphics) {
		super();
		this.status = status;
		this.cellGraphics = cellGraphics;
		
	}
	public ICellGraphics getCellGraphics() {
		return cellGraphics;
	}
	@Override
	public void setCellSettings(int x, int y, int cellValue) {
		this.x = x;
		this.y = y;
		this.cellValue = cellValue;
	}
	@Override
	public int getCellValue() {
		return cellValue;
	}
	@Override
	public void setCellStatus(int status) {
		this.status = status;
	}
	@Override
	public int getCellStatus() {
		return status;
	}
	@Override
	public boolean isIn(int mouseButton, int mouseX, int mouseY, int x, int y) {
		if (status != 2) {
			if(mouseX>x && mouseX<x+minesweeperSettings.getCellWidth() && mouseY>y && mouseY<y+minesweeperSettings.getCellHeight()){
				if (mouseButton == 1 && status != 1) {
					status = 2;
				}else if (mouseButton == 1 && status == 1) {
					status = 0;
				}else if (mouseButton == 3) {
					status = 1;
				}
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	@Override
	public void draw(Graphics graphics) {
		cellGraphics.draw(x, y, cellValue, graphics, status);
	}
}
