import java.util.Objects;

public class Solver {
	public static boolean solveR(GameGrid inputGrid) {
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
		if (row > 8) {
			System.out.println(grid);
			return true;
		}
		else {
			for (int n = 1; n < 10; n++) 
				if (grid.setField(column, row, n)) {
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
    public static boolean solve(GameGrid game) {
        Objects.requireNonNull(game);

        // start at top left
        int column = 0;
        int row = 0;

        // if true, we move backwards through the grid, forward otherwise
        boolean goBack = false;

        // while not iterated through all possible combinations yet
        while(!(column == GameGrid.GRID_DIM - 1 && row == -1)) {
            
            // try values on current field
            if(!game.isInitial(column,row)) {
                goBack = false; // go forward
                if(!tryIncrease(game,column,row)) {
                    game.clearField(column,row);
                    goBack = true; // track back
                }

            } 
            
            // move through grid
            if(goBack) { // backwards
                column--;
                if(column < 0) { // move up one row
                    column = GameGrid.GRID_DIM - 1;
                    row--;
                }
            } else { // forward
               column++;
               if(column >= GameGrid.GRID_DIM) { // move down one row
                   column = 0;
                   row++;
               }
            }

            // we reached the end, hence found a valid solution
            if (column == 0 && row == GameGrid.GRID_DIM) {
            	System.out.println(game);
                return true;
        	}
        }
       // we tried all possible combinations without reaching the end, hence no solution
        return false;
     }
    
    private static boolean tryIncrease(GameGrid game, int column, int row) {
        int val = game.getField(column,row).getValue();

        for(int i = val + 1; i <= GameGrid.MAX_VAL; i++) {
            if(game.setField(column,row,i)) {
		return true;
            }
        }

        return false;
    }
}