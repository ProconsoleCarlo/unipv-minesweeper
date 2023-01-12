package cell;

import java.awt.Graphics;

/**
 * Una generica cella
 * 
 * @author Carlo
 */
public interface Drawable {

	/**
	 * Setta i parametri della cella
	 * @param x	La posizione x della cella
	 * @param y	La posizione y della cella
	 * @param cellValue	Il valore della cella
	 */
	public void setCellSettings(int x, int y, int cellValue);
	/**
	 * Ritorna il valore contenuto nella cella
	 * @return	Il valore della cella
	 */
	public int getCellValue();
	/**
	 * Imposta lo stato di una cella(Chiusa, segnalata o aperta)
	 * @param status	Lo stato della cella
	 */
	public void setCellStatus(int status);
	/**
	 * Ritorna lo stato di una cella(Chiusa, segnalata o aperta)	
	 * @return	Lo stato della cella
	 */
	public int getCellStatus();
	/**
	 * Verifica se il mouse si trova all'interno di una cella
	 * @param mouseButton Il bottone del mouse premuto
	 * @param mouseX	La posizione x del mouse
	 * @param mouseY	La posizione y del mouse	
	 * @param x			La posizione x della cella
	 * @param y			La posizione y della cella
	 * @return			Vero o falso che il mouse si trovi nella cella
	 */
	public boolean isIn(int mouseButton, int mouseX, int mouseY, int x, int y);
	/**
	 * Disegna la cella su un graphics
	 * @param graphics	Il graphics su cui disegnare la cella
	 */
	public void draw(Graphics graphics);
}
