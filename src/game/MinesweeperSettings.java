package game;

public class MinesweeperSettings {

	private static MinesweeperSettings minesweeperSettings = new MinesweeperSettings();
	private MinesweeperSettings() {
		super();
	}
	public static MinesweeperSettings getMinesweeperSettings() {
		return minesweeperSettings;
	}
	
	private int cellWidth = 20;
	private int cellHeight = 20;
	private int mineValue = 9;
	public int getCellWidth() {
		return cellWidth;
	}
	public int getCellHeight() {
		return cellHeight;
	}
	public int getMineValue() {
		return mineValue;
	}
	

	
}
