package cell;

public class CellPrototype extends DrawingCell implements ICellPrototype{

	public CellPrototype(boolean opened, ICellGraphics cellGraphics) {
		super(opened, cellGraphics);
		// TODO Auto-generated constructor stub
	}

	@Override
	public CellPrototype clone() throws CloneNotSupportedException {
		return new CellPrototype(false, this.getCellGraphics());
	}

}
