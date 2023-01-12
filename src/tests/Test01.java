package tests;

import game.MineMapBuilder;



public class Test01 {

	/**
	 * La matrice di gioco del campo minato
	 * @param args
	 * @throws CloneNotSupportedException
	 */
	public static void main(String[] args) throws CloneNotSupportedException {
		MineMapBuilder mineMapBuilder = new MineMapBuilder(5, 5, 10);
		int[][] mineMap = mineMapBuilder.createMineMap();
		for (int i = 0; i < mineMap.length; i++) {
			
			for (int j = 0; j < mineMap[i].length; j++) {
				System.out.print("|"+mineMap[i][j]+"|");
			}
			System.out.println();
		}

	}

}
