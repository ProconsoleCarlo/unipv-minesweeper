package cell;

import game.MinesweeperSettings;

import java.awt.Graphics;


public class DrawingCell implements Drawable {

	private boolean opened;
	private int x, y;
	private ICellGraphics cellGraphics;
	private MinesweeperSettings minesweeperSettings = MinesweeperSettings.getMinesweeperSettings();
	public DrawingCell(boolean opened, ICellGraphics cellGraphics) {
		super();
		this.opened = opened;
		this.cellGraphics = cellGraphics;
		
	}
	public ICellGraphics getCellGraphics() {
		return cellGraphics;
	}
	@Override
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;		
	}
	@Override
	public int[] getPosition() {
		int[] position = new int[2];
		position[0] = x;
		position[1] = y;
		return position;
	}
	@Override
	public boolean isIn(int mouseX, int mouseY, boolean isIn, int x, int y) {
		if(mouseX>x && mouseX<x+minesweeperSettings.getCellWidth() && mouseY>y && mouseY<y+minesweeperSettings.getCellHeight()){
			opened = true;
			return true;
		}else {
			return false;
		}
	}
	@Override
	public void draw(Graphics graphics) {
		cellGraphics.draw(x, y, graphics, opened);
	}
}
