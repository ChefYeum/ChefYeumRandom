
public class Solver {
	public static GameGrid solve(GameGrid inputGrid){
		
		return next(0,0,inputGrid);
	}
	
	private static boolean next(int column, int row, GameGrid grid) {
		int value = grid.getField(column, row).getValue();
		boolean init = grid.getField(column, row).isInitial();
		//if 9,9...
		
		if (init) {
			int[] nextPos = getNextPos(column, row);
			return next(nextPos[0],nextPos[1], grid);
		} else {
			if (value == 8) {
				return false;
			} else {
				grid.setField(column, row, value+1);
				return next(column, row, grid);
			}
		}
	}
	
	private static int[] getNextPos(int column, int row) {
		int[] output = new int[2]; 
		
		if (column == 8) {
			output[0] = 0;
			output[1] = row+1;
			return output;
		}
		else {
			output[0] = column + 1;
			output[1] = row;
			return output;
		}
	}
	//return true if a solution was found and false otherwise.
	//Based on the result, print the solution to the console or a corresponding message if none was found
}
