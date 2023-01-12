package tests;

import javax.swing.JFrame;

import ui.MatrixMouseController;
import utils.CellaPrototype;
import utils.IconMatrixBuilder;



public class Test01 {

	/**
	 * Apre il file di log e ne stampa il contenuto su un pannello del frame (NON funziona più perchè il loader carica e basta nelle versioni
	 * successive)
	 * @param args
	 * @throws CloneNotSupportedException 
	 */
	public static void main(String[] args) throws CloneNotSupportedException {

		JFrame frame=new JFrame();
		IconMatrixBuilder iconMatrixBuilder = new IconMatrixBuilder(10, 10, 20);
		iconMatrixBuilder.createMineCamp(new CellaPrototype());
		MatrixMouseController mouseController = MatrixMouseController.getMouseController();
		mouseController.setIconMatrixBuilder(iconMatrixBuilder);
//		UIMenuBar uiMenuBar = new UIMenuBar(iconMatrixBuilder);	
//		frame.setJMenuBar(uiMenuBar.createMenuBar());
		iconMatrixBuilder.addObserver(iconMatrixBuilder.getPanel());
		frame.addMouseListener(mouseController);
		frame.setTitle("FopenGUI");
		frame.setSize(640,480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(iconMatrixBuilder.getPanel());
		frame.setVisible(true);

	}

}
