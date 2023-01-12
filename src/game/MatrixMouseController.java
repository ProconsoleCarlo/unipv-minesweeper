package game;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import cell.Drawable;

/**
 * La classe che controlla le azioni del mouse
 * @author Carlo
 *
 */
public class MatrixMouseController implements MouseListener{
		
	//SINGLETON
	private static MatrixMouseController mouseController = new MatrixMouseController();
	private MatrixMouseController(){
		super();
	}
	public static MatrixMouseController getMouseController() {
		return mouseController;
	}
	
	//Classe
	private Drawable[][] cellMatrix;
	private Minesweeper minesweeperUi;
	private MinesweeperSettings settings = MinesweeperSettings.getMinesweeperSettings();
	private int nOpenedCells = 0;
	
	public void setMinesweeperUi(Minesweeper minesweeperUi) {
		this.minesweeperUi = minesweeperUi;
		cellMatrix = minesweeperUi.getCampoMinato();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int mouseX = e.getX();
		int mouseY = e.getY();
		for (int i = 0; i < cellMatrix.length; i++) {
			for (int j = 0; j < cellMatrix[i].length; j++) {
				int oldStatus = cellMatrix[i][j].getCellStatus();
				int x = settings.getCellWidth()*i+10;
				int y = settings.getCellHeight()*j+50;
				boolean isIn = cellMatrix[i][j].isIn(e.getButton(), mouseX, mouseY, x, y);
				if (isIn) {
					if (oldStatus == 0 && e.getButton() == 1) {
						nOpenedCells++;
					}
					minesweeperUi.update();
					if (cellMatrix[i][j].getCellValue() == settings.getMineValue() && cellMatrix[i][j].getCellStatus()==2) {
						JOptionPane.showMessageDialog(null, "Hai perso!");					
						createNewGame();
					}else if (cellMatrix[i][j].getCellValue() == 0) {
						openSafeSpot(i, j);
					}else if (nOpenedCells==((settings.getCampWidth()*settings.getCampHeight())-settings.getMineNumber())) {
						JOptionPane.showMessageDialog(null, "Hai vinto!");
						createNewGame();
					}
				}
			}
		}
	}
	private void openSafeSpot(int x, int y) {
		int searchSafeSpotMatrixWidth = 3;
		int searchSafeSpotMatrixHeight = 3;
		for (int i = x-1; i < x-1+searchSafeSpotMatrixWidth; i++) {
			for (int j = y-1; j < y-1+searchSafeSpotMatrixHeight; j++) {
				try {
					if (cellMatrix[i][j].getCellValue() != settings.getMineValue() && cellMatrix[i][j].getCellStatus() != 2) {
						cellMatrix[i][j].setCellStatus(2);
						nOpenedCells++;
					}
				} catch (IndexOutOfBoundsException e) {
					if (i<0) {
						searchSafeSpotMatrixWidth=2;
					}else if (j<0) {
						searchSafeSpotMatrixHeight=2;
					}
				}
				searchSafeSpotMatrixWidth = 3;
				searchSafeSpotMatrixHeight = 3;
			}
		}
	}
	private void createNewGame() {
		try {
			nOpenedCells = 0;
			minesweeperUi.initializeGame();
			minesweeperUi.update();
		} catch (CloneNotSupportedException e1) {
			e1.printStackTrace();
		}
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
}
