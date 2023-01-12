package cell;

public interface ICellPrototype extends Drawable{

	public abstract ICellPrototype clone() throws CloneNotSupportedException;

}