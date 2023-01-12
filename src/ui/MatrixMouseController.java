package ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import utils.ICellaPrototype;
import utils.IconMatrixBuilder;

public class MatrixMouseController implements MouseListener{
		
	//SINGLETON
	private static MatrixMouseController mouseController = new MatrixMouseController();
	private MatrixMouseController(){
		super();
	}
	public static MatrixMouseController getMouseController() {
		return mouseController;
	}
	
	private ICellaPrototype[][] cellMatrix;
	private Integer[][] mineMatrix;
	private IconMatrixBuilder iconMatrixBuilder;
	public void setIconMatrixBuilder(IconMatrixBuilder iconMatrixBuilder) {
		this.iconMatrixBuilder = iconMatrixBuilder;
	}
//	private ICellaPrototype<DrawableIcon> drawables = new ArrayList<DrawableIcon>();
//	private DrawableIcon selectedIcon = null;	
	public void setCellMatrix(ICellaPrototype[][] cellMatrix) {
		this.cellMatrix = cellMatrix;
	}
	public void setMineMatrix(Integer[][] mineMatrix) {
		this.mineMatrix = mineMatrix;
	}
	
/*	public void addDrawable(DrawableIcon drawable){
		drawables.add(drawable);
	}*/
//	private FileSystemBuilder builder;
/*	public void setBuilder(FileSystemBuilder builder) {
		this.builder = builder;
	}*/	
	@Override
	public void mouseClicked(MouseEvent e) {
		int mouseX = e.getX();
		int mouseY = e.getY();
		for (int i = 0; i < cellMatrix.length; i++) {
			for (int j = 0; j < cellMatrix[i].length; j++) {
				boolean isIn = false;
				int x = cellMatrix[i][j].getX()*20;
				int y = cellMatrix[i][j].getY()*20;
				isIn = cellMatrix[i][j].isIn(mouseX, mouseY, isIn, x, y);
//				System.out.println(x+","+y+" mouse "+mouseX+","+mouseY+"isIn"+isIn);
				if (isIn) {
					
					cellMatrix[i][j].setContents(mineMatrix[i][j]);
					cellMatrix[i][j].showContents();
					iconMatrixBuilder.update();
				}
			}}
/*			DrawableIcon icon = drawables.get(i);
			boolean isIn = false;
			int x = 0, y = 0;
			x = icon.getX();
			y = icon.getY();
			isIn = icon.isIn(mouseX, mouseY, isIn, x, y);
			if (isIn) {
				selectedIcon = icon;
				selectedIcon.executeAction(builder);
			}
		}*/
//		builder.update();
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
