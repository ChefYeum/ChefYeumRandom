
public class Solver {
	public static boolean solve(GameGrid inputGrid) {

		return next(0, 0, inputGrid);
	}

	private static boolean next(int column, int row, GameGrid grid) {
		int value = grid.getField(column, row).getValue();
		boolean init = grid.getField(column, row).isInitial();
		// if 9,9...
		
		if (row > GameGrid.GRID_DIM) return true;
		if (row < 0) return false;
		
		
		if (init) {
			int[] nextPos = getNextPos(column, row, grid);
			return next(nextPos[0],nextPos[1], grid);
		} else {
			
			//finds the next valid value
			//but if there is no valid value till 8, backtrack.
			
			int n = value;
			while (n <= GameGrid.MAX_VAL && !grid.setField(column, row, n)) {
				n++;
			}
			
			if (n < GameGrid.MAX_VAL) { //valid value found
				int[] nextPos = getNextPos(column, row, grid);
				return next(nextPos[0],nextPos[1], grid);
			} else {
				grid.clearField(column, row);
				int[] lastPos = getLastPos(column, row, grid);
				return next(lastPos[0],lastPos[1], grid);
				
			}
		}

	}

	private static int[] getLastPos(int column, int row, GameGrid grid) {
		int[] output = new int[2];

		if (column == 0) {
			output[0] = 8;
			output[1] = row - 1;
		} else {
			output[0] = column - 1;
			output[1] = row;
		}

		if (grid.isInitial(column, row)) {
			return getLastPos(output[0], output[1], grid);
		}

		return output;
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

		if (grid.isInitial(column, row)) {
			return getNextPos(output[0], output[1], grid);
		}

		return output;
	}
	// return true if a solution was found and false otherwise.
	// Based on the result, print the solution to the console or a corresponding
	// message if none was found
}
