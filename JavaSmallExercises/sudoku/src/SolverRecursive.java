import java.util.ArrayList;

public class SolverRecursive {
	public static boolean solve(GameGrid inputGrid) {
		int[] nextPos = getNextPos(-1,0,inputGrid);
		return solveR(nextPos[0], nextPos[1], inputGrid);
	}
	
	private static void printGridLine(GameGrid inputGrid) {
		for (int j = 0; j < GameGrid.GRID_DIM; j++) {
			for (int i = 0; i < GameGrid.GRID_DIM; i++) {
				Field field = inputGrid.getField(i, j);
				
				if (!field.isInitial()) System.out.printf(field.getValue() + "");
				
			}
		}
		System.out.println();
	}


	private static boolean solveR(int column, int row, GameGrid grid) {
		printGridLine(grid);
		ArrayList<Integer> validValues = new ArrayList<>();
		if (row > 8) {
			System.out.println(grid);
			return true;
		}
		else {
			for (int n = 1; n < 10; n++) if (grid.setField(column, row, n)) validValues.add(n);
			for (int value : validValues) {
				grid.setField(column, row, value);
				GameGrid newGrid = new GameGrid(grid);
				int[] nextPos = getNextPos(column,row,grid);
				if (solveR(nextPos[0], nextPos[1], newGrid)) {
					return true;
				}
			}
			return false;
		}
		
	}
	
	private static int[] getNextPos(int column, int row, GameGrid grid) {
		int[] output = new int[2];

		if (column == 8) {
			output[0] = 0;
			output[1] = row + 1;
		} else {
			output[0] = column + 1;
			output[1] = row;
		}
		
		
		try {
			if (grid.isInitial(output[0], output[1])) {
				return getNextPos(output[0], output[1], grid);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return output;
		}


		return output;
	}
	// return true if a solution was found and false otherwise.
	// Based on the result, print the solution to the console or a corresponding
	// message if none was found

}