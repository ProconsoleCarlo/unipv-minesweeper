package it.proconsole.unipv.minesweeper.ui;

import it.proconsole.unipv.minesweeper.game.Minesweeper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * La barra dei menu del frame
 * @author Carlo
 */

public class MenuBar {
	
	private JMenuBar menuBar = new JMenuBar();
	private ParameterFrame parameterFrame;
	public MenuBar(Minesweeper minesweeperUI) {
		super();
		parameterFrame = new ParameterFrame(minesweeperUI);
	}
	/**
	 * Crea la barra dei menù
	 * @return La barra dei menù
	 */
	public JMenuBar createMenus() {
		JMenu menuFile = new JMenu("File");
			JMenuItem settings = new JMenuItem("Impostazioni");
			settings.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					parameterFrame.createParameterFrame();
				}
			});
			menuFile.add(settings);
		menuBar.add(menuFile);
		return menuBar;
	}
}
