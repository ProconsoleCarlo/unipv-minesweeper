package utils;

import java.awt.Color;
import java.util.Observable;
import java.util.Random;

import ui.MatrixMouseController;

public class IconMatrixBuilder extends Observable{

	private DrawingsPanel panel = new DrawingsPanel();
	private int campWidth;
	private int campHeight;
	private int nMine;
	private MatrixMouseController mouseController = MatrixMouseController.getMouseController();
	
	public IconMatrixBuilder(int campWidth, int campHeight, int nMine) {
		super();
		this.campWidth = campWidth;
		this.campHeight = campHeight;
		this.nMine = nMine;
	}
	public DrawingsPanel getPanel() {
		return panel;
	}
	public void setCampWidth(int campWidth) {
		this.campWidth = campWidth;
	}
	public void setCampHeight(int campHeight) {
		this.campHeight = campHeight;
	}
	public void createMineCamp(ICellaPrototype cellaPrototype) throws CloneNotSupportedException {
		ICellaPrototype[][] campoMinato = new ICellaPrototype[campWidth][campHeight];
		for (int i = 0; i < campWidth; i++) {
			for (int j = 0; j < campHeight; j++) {
				ICellaPrototype cella = cellaPrototype.clone();
				cella.setX(i);
				cella.setY(j);
				cella.setColor(Color.red);
				campoMinato[i][j] = cella;
			}
		}
		Integer[][] mineMatrix = new Integer[campWidth][campHeight];
		for (int i = 0; i < mineMatrix.length; i++) {
			for (int j = 0; j < mineMatrix[i].length; j++) {
				mineMatrix[i][j] = 0;
			}
		}
		setMines(mineMatrix);
		setHints(mineMatrix);
		
		for (int i = 0; i < mineMatrix.length; i++) {
			String line = "";
			for (int j = 0; j < mineMatrix[i].length; j++) {
				line = line+String.valueOf(mineMatrix[i][j])+" ";
			}
			System.out.println(line);
		}
//		setMines(campoMinato);
//		setHints(campoMinato);
		panel.setMatrix(campoMinato);
		mouseController.setCellMatrix(campoMinato);
		mouseController.setMineMatrix(mineMatrix);
		update();
	}
	private void setMines(Integer[][] mineMatrix){
		Random random = new Random();
		int minePosate = 0;
		while (minePosate<nMine) {
			if (mineMatrix[random.nextInt(campWidth)][random.nextInt(campHeight)] != 9) {
				mineMatrix[random.nextInt(campWidth)][random.nextInt(campHeight)] = 9;
				minePosate++;
			}
		}
	}
	private void setHints(Integer[][] mineMatrix){
		for (int i = 0; i < mineMatrix.length; i++) {
			for (int j = 0; j < mineMatrix[i].length; j++) {
				if (mineMatrix[i][j] == 9) {
					int controlMatrixWidth = 3;
					int controlMatrixHeight = 3;
					for (int i2 = i-1; i2 < i-1+controlMatrixWidth; i2++) {
						for (int j2 = j-1; j2 < j-1+controlMatrixHeight; j2++) {
							try {
								if (mineMatrix[i2][j2] != 9) {
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
	public void update() {
		setChanged();
		notifyObservers();
	}
	
}
