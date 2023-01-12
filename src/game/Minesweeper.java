package game;

import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import ui.DrawingsPanel;
import cell.ICellPrototype;
/**
 * La classe che gestisce il gioco del campo minato
 * @author Carlo
 *
 */
public class Minesweeper extends Observable{

	private JFrame frame = new JFrame();
	private DrawingsPanel panel = new DrawingsPanel();
	private JMenuBar menuBar;
	private MinesweeperSettings settings = MinesweeperSettings.getMinesweeperSettings();
	private MineMapBuilder mineMapBuilder = new MineMapBuilder(settings.getCampWidth(), settings.getCampHeight(), settings.getMineNumber());
	private ICellPrototype cellPrototype;
	private ICellPrototype[][] campoMinato;
	/**
	 * Il costruttore del gioco del campo minato
	 * @param cellPrototype	La grafica da utilizzare per rappresentare le celle
	 */
	public Minesweeper(ICellPrototype cellPrototype) {
		super();
		this.cellPrototype = cellPrototype;
		this.addObserver(panel);
	}
	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}
	public ICellPrototype[][] getCampoMinato() {
		return campoMinato;
	}
	/**
	 * Inizializza il campo minato
	 * @throws CloneNotSupportedException
	 */
	public void initializeGame() throws CloneNotSupportedException{
		mineMapBuilder.setMatrixSettings(settings.getCampWidth(), settings.getCampHeight(), settings.getMineNumber());
		int[][] mineMatrix = mineMapBuilder.createMineMap();
		campoMinato = new ICellPrototype[settings.getCampWidth()][settings.getCampHeight()];
		for (int i = 0; i < settings.getCampWidth(); i++) {
			for (int j = 0; j < settings.getCampHeight(); j++) {
				ICellPrototype cell = cellPrototype.clone();
				cell.setCellSettings(i, j, mineMatrix[i][j]);
				campoMinato[i][j] = cell;
			}
		}
		panel.setMatrix(campoMinato);
		MatrixMouseController.getMouseController().setMinesweeperUi(this);
	}
	/**
	 * Rappresenta graficamente il campo minato
	 */
	public void createUI(){		
		frame.addMouseListener(MatrixMouseController.getMouseController());
		
		frame.setJMenuBar(menuBar);
		frame.setSize(settings.getCampWidth()*settings.getCellWidth()+15, 
				settings.getCampHeight()*settings.getCellHeight()+60);
		frame.getContentPane().add(panel);
		frame.setTitle("Campo minato");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public void update() {
		setChanged();
		notifyObservers();
	}
}
