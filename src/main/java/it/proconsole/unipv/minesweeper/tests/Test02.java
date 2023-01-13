package it.proconsole.unipv.minesweeper.tests;

import it.proconsole.unipv.minesweeper.ui.MenuBar;
import it.proconsole.unipv.minesweeper.game.Minesweeper;
import it.proconsole.unipv.minesweeper.cell.CellColoredGraphics;
import it.proconsole.unipv.minesweeper.cell.CellPrototype;



public class Test02 {

	/**
	 * Il gioco del campo minato
	 * @param args
	 * @throws CloneNotSupportedException
	 */
	public static void main(String[] args) throws CloneNotSupportedException {

		CellColoredGraphics cellDirtyGraphics = new CellColoredGraphics();
		Minesweeper minesweeperUi = new Minesweeper(new CellPrototype(0, cellDirtyGraphics));
		MenuBar menuBar = new MenuBar(minesweeperUi);
		minesweeperUi.setMenuBar(menuBar.createMenus());
		minesweeperUi.initializeGame();
		minesweeperUi.createUI();
	}

}
