package cell;

import java.awt.Graphics;
/**
 * La generica grafica di una cella
 * @author Carlo
 *
 */
public interface ICellGraphics {

	/**
	 * Disegna la cella su un graphics
	 * @param x	La posizione x della cella
	 * @param y	La posizione y della cella
	 * @param cellValue	Il valore della cella
	 * @param graphics	Il graphics su cui disegnare la cella
	 * @param opened	Lo stato (aperto, chiuso o segnalato) della cella
	 */
	public void draw(int x, int y, int cellValue, Graphics graphics, int status);
}
