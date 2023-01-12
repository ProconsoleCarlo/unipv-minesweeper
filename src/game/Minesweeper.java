package game;

import java.util.Observable;

import ui.DrawingsPanel;
import ui.MatrixMouseController;
import cell.ICellGraphics;
import cell.ICellPrototype;

public class Minesweeper extends Observable{

	private DrawingsPanel panel;
	private MineMapBuilder mineMapBuilder;
	private ICellPrototype cellPrototype;
	private ICellGraphics cellGraphics;
	public Minesweeper(DrawingsPanel panel, MineMapBuilder mapBuilder, ICellPrototype cellPrototype, ICellGraphics cellGraphics) {
		super();
		this.panel = panel;
		this.mineMapBuilder = mapBuilder;
		this.cellPrototype = cellPrototype;
		this.cellGraphics = cellGraphics;
	}

	public void createUIMineCamp() throws CloneNotSupportedException{
		mineMapBuilder.createMineMap();
		cellGraphics.setMineMatrix(mineMapBuilder.getMineMatrix());
		ICellPrototype[][] campoMinato = new ICellPrototype[mineMapBuilder.getCampWidth()][mineMapBuilder.getCampWidth()];
		for (int i = 0; i < mineMapBuilder.getCampWidth(); i++) {
			for (int j = 0; j < mineMapBuilder.getCampWidth(); j++) {
				ICellPrototype cell = cellPrototype.clone();
				cell.setPosition(i, j);
				campoMinato[i][j] = cell;
			}
		}
		panel.setMatrix(campoMinato);
		MatrixMouseController.getMouseController().setCellMatrix(campoMinato);
		MatrixMouseController.getMouseController().setMineMapMatrix(mineMapBuilder.getMineMatrix());
	}
	public void update() {
		setChanged();
		notifyObservers();
	}
}
