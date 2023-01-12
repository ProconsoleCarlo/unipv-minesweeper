package game;

import java.util.Random;

public class MineMapBuilder{

	private int campWidth;
	private int campHeight;
	private int nMine;
	private int[][] mineMatrix;
	private MinesweeperSettings minesweeperSettings = MinesweeperSettings.getMinesweeperSettings();
	/**
	 * Il costruttore della mappa delle mine e degli indicatori di mine vicine
	 * @param campWidth	La larghezza del campo minato
	 * @param campHeight L'altezza del campo minato
	 * @param nMine	Il numero di mine del campo
	 */
	public MineMapBuilder(int campWidth, int campHeight, int nMine) {
		super();
		this.campWidth = campWidth;
		this.campHeight = campHeight;
		this.nMine = nMine;
	}
	public int getCampWidth() {
		return campWidth;
	}
	public int getCampHeight() {
		return campHeight;
	}
	public int[][] getMineMatrix() {
		return mineMatrix;
	}
	/**
	 * Crea la mappa delle mine e degli indicatori del numero di mine vicine
	 */
	public void createMineMap(){
		mineMatrix = new int[campWidth][campHeight];
		for (int i = 0; i < mineMatrix.length; i++) {
			for (int j = 0; j < mineMatrix[i].length; j++) {
				mineMatrix[i][j] = 0;
			}
		}
		setMines(mineMatrix);
		setHints(mineMatrix);
	}
	private void setMines(int[][] mineMatrix){
		Random random = new Random();
		int minePosate = 0;
		while (minePosate<nMine) {
			if (mineMatrix[random.nextInt(campWidth)][random.nextInt(campHeight)] != minesweeperSettings.getMineValue()) {
				mineMatrix[random.nextInt(campWidth)][random.nextInt(campHeight)] = minesweeperSettings.getMineValue();
				minePosate++;
			}
		}
	}
	private void setHints(int[][] mineMatrix){
		for (int i = 0; i < mineMatrix.length; i++) {
			for (int j = 0; j < mineMatrix[i].length; j++) {
				if (mineMatrix[i][j] == minesweeperSettings.getMineValue()) {
					int controlMatrixWidth = 3;
					int controlMatrixHeight = 3;
					for (int i2 = i-1; i2 < i-1+controlMatrixWidth; i2++) {
						for (int j2 = j-1; j2 < j-1+controlMatrixHeight; j2++) {
							try {
								if (mineMatrix[i2][j2] != minesweeperSettings.getMineValue()) {
									mineMatrix[i2][j2] = mineMatrix[i2][j2]+1;
								}
							} catch (IndexOutOfBoundsException e) {
								if (i2<0) {
									controlMatrixWidth=2;
								}else if (j2<0) {
									controlMatrixHeight=2;
								}				
							}
							controlMatrixWidth = 3;
							controlMatrixHeight = 3;
						}
					}
				}
			}
		}
	}
}
