package tests;

import javax.swing.JFrame;

import ui.DrawingsPanel;
import ui.MatrixMouseController;
import ui.MinesweeperUi;
import utils.CellPrototype;
import utils.MineMapBuilder;



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
		MineMapBuilder mapBuilder = new MineMapBuilder(5, 5, 2);
		mapBuilder.createMineMap();
		MinesweeperUi minesweeperUi = new MinesweeperUi(panel, mapBuilder);
		minesweeperUi.createUIMineCamp(new CellPrototype());
		minesweeperUi.addObserver(panel);
		MatrixMouseController.getMouseController().setMapBuilder(mapBuilder);
		MatrixMouseController.getMouseController().setMinesweeperUi(minesweeperUi);
		frame.addMouseListener(MatrixMouseController.getMouseController());
		frame.setTitle("FopenGUI");
		frame.setSize(640,480);
		frame.getContentPane().add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
