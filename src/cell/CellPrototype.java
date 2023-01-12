package cell;
/**
 * Il prototipo di una cella del campo minato
 * @author Carlo
 *
 */
public class CellPrototype extends DrawingCell implements ICellPrototype{

	public CellPrototype(int status, ICellGraphics cellGraphics) {
		super(status, cellGraphics);
	}

	@Override
	public CellPrototype clone() throws CloneNotSupportedException {
		return new CellPrototype(0, this.getCellGraphics());
	}

}
