package ui;

import java.util.Observable;

import utils.ICellPrototype;
import utils.MineMapBuilder;

public class MinesweeperUi extends Observable{

	private DrawingsPanel panel;
	private MineMapBuilder mapBuilder;
	public MinesweeperUi(DrawingsPanel panel, MineMapBuilder mapBuilder) {
		super();
		this.panel = panel;
		this.mapBuilder = mapBuilder;
	}
	public void setMapBuilder(MineMapBuilder mapBuilder) {
		this.mapBuilder = mapBuilder;
	}
	public void createUIMineCamp(ICellPrototype cellPrototype) throws CloneNotSupportedException{
		ICellPrototype[][] campoMinato = new ICellPrototype[mapBuilder.getCampWidth()][mapBuilder.getCampWidth()];
		for (int i = 0; i < mapBuilder.getCampWidth(); i++) {
			for (int j = 0; j < mapBuilder.getCampWidth(); j++) {
				ICellPrototype cell = cellPrototype.clone();
				cell.setCellPosition(i, j);
				cell.setContents(mapBuilder.getMineMatrix()[i][j]);
				campoMinato[i][j] = cell;
			}
		}
		panel.setMatrix(campoMinato);
		MatrixMouseController.getMouseController().setCellMatrix(campoMinato);
	}
	public void update() {
		setChanged();
		notifyObservers();
//		SwingUtilities.updateComponentTreeUI(panel);
	}
	
}
