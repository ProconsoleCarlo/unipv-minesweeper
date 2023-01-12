package ui;

import game.Minesweeper;
import game.MinesweeperSettings;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import cell.Drawable;

public class MatrixMouseController implements MouseListener{
		
	//SINGLETON
	private static MatrixMouseController mouseController = new MatrixMouseController();
	private MatrixMouseController(){
		super();
	}
	public static MatrixMouseController getMouseController() {
		return mouseController;
	}
	
	private Drawable[][] cellMatrix;
	private int[][] mineMapMatrix;
	private Minesweeper minesweeperUi;
	private MinesweeperSettings minesweeperSettings = MinesweeperSettings.getMinesweeperSettings();

	public void setCellMatrix(Drawable[][] cellMatrix) {
		this.cellMatrix = cellMatrix;
	}
	public void setMineMapMatrix(int[][] mineMapMatrix) {
		this.mineMapMatrix = mineMapMatrix;
	}
	public void setMinesweeperUi(Minesweeper minesweeperUi) {
		this.minesweeperUi = minesweeperUi;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int mouseX = e.getX();
		int mouseY = e.getY();
		for (int i = 0; i < cellMatrix.length; i++) {
			for (int j = 0; j < cellMatrix[i].length; j++) {
				boolean isIn = false;
				int x = 20*i+10;
				int y = 20*j+30;
				isIn = cellMatrix[i][j].isIn(mouseX, mouseY, isIn, x, y);
				if (isIn) {
					minesweeperUi.update();
				}
				if (mineMapMatrix[i][j] == minesweeperSettings.getMineValue() && isIn) {
					JOptionPane.showMessageDialog(null, "Hai perso!");					
					try {
						minesweeperUi.createUIMineCamp();
						minesweeperUi.update();
					} catch (CloneNotSupportedException e1) {
						e1.printStackTrace();
					}
				}
/*				else if (openedCells == mapBuilder.getCampHeight()*mapBuilder.getCampWidth()-2) {
					JOptionPane.showMessageDialog(null, "Hai vinto!");					
					try {
						mapBuilder.createMineMap();
						minesweeperUi.setMapBuilder(mapBuilder);
						minesweeperUi.createUIMineCamp(new CellPrototype());
						openedCells = 0;
						minesweeperUi.update();
					} catch (CloneNotSupportedException e1) { 
						e1.printStackTrace();
					}
				}*/
			}
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
