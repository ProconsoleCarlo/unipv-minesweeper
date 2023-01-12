package ui;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import cell.Drawable;


public class DrawingsPanel extends JPanel implements Observer{

	/**
	 * Il pannello su cui disegnare il campo minato
	 * @author Carlo
	 */
	private static final long serialVersionUID = 1L;
	private Drawable[][] matrix;
	public void setMatrix(Drawable[][] matrix) {
		this.matrix = matrix;
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j].draw(g);
			}
		}
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		repaint();
	}
}
