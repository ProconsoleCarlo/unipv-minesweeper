package tests;

import ui.MenuBar;
import game.Minesweeper;
import cell.CellColoredGraphics;
import cell.CellPrototype;



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
