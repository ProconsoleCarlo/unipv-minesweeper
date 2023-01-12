package tests;

import game.MineMapBuilder;
import game.Minesweeper;
import game.MinesweeperSettings;

import javax.swing.JFrame;

import cell.CellDirtyGraphics;
import cell.CellPrototype;

import ui.DrawingsPanel;
import ui.MatrixMouseController;



public class Test01 {

	/**
	 * Apre il file di log e ne stampa il contenuto su un pannello del frame (NON funziona più perchè il loader carica e basta nelle versioni
	 * successive)
	 * @param args
	 * @throws CloneNotSupportedException 
	 */
	public static void main(String[] args) throws CloneNotSupportedException {

		JFrame frame=new JFrame();
		DrawingsPanel panel = new DrawingsPanel();
		
		MineMapBuilder mineMapBuilder = new MineMapBuilder(10, 10, 30);
		CellDirtyGraphics cellDirtyGraphics = new CellDirtyGraphics();
		Minesweeper minesweeperUi = new Minesweeper(panel, mineMapBuilder, new CellPrototype(false, cellDirtyGraphics), cellDirtyGraphics);
		minesweeperUi.createUIMineCamp();
		MatrixMouseController matrixMouseController = MatrixMouseController.getMouseController();
		matrixMouseController.setMinesweeperUi(minesweeperUi);
		minesweeperUi.addObserver(panel);
		frame.addMouseListener(matrixMouseController);
		frame.setTitle("FopenGUI");
		frame.setSize(mineMapBuilder.getCampWidth()*MinesweeperSettings.getMinesweeperSettings().getCellWidth()+15, 
				mineMapBuilder.getCampHeight()*MinesweeperSettings.getMinesweeperSettings().getCellHeight()+38);
		frame.getContentPane().add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
