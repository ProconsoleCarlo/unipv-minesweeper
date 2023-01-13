package it.proconsole.unipv.minesweeper.cell;

/**
 * Un generico prototipo di cella
 * @author Carlo
 *
 */
public interface ICellPrototype extends Drawable{

	/**
	 * Clona il prototipo della cella
	 * @return	Il clone del prototipo
	 * @throws CloneNotSupportedException
	 */
	public abstract ICellPrototype clone() throws CloneNotSupportedException;

}