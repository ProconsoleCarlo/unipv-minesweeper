package game;
/**
 * La classe che contiene tutti i settaggi del gioco del campo minato
 * @author Carlo
 *
 */
public class MinesweeperSettings {

	private static MinesweeperSettings minesweeperSettings = new MinesweeperSettings();
	private MinesweeperSettings() {
		super();
	}
	public static MinesweeperSettings getMinesweeperSettings() {
		return minesweeperSettings;
	}
	
	//Proprietà celle
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
	
	//Proprietà gioco
	private int campWidth = 7;
	private int campHeight = 7;
	private int mineNumber = 5;
	public int getCampWidth() {
		return campWidth;
	}
	public void setCampWidth(int campWidth) {
		this.campWidth = campWidth;
	}
	public int getCampHeight() {
		return campHeight;
	}
	public void setCampHeight(int campHeight) {
		this.campHeight = campHeight;
	}
	public int getMineNumber() {
		return mineNumber;
	}
	public void setMineNumber(int mineNumber) {
		this.mineNumber = mineNumber;
	}
}
