import java.util.Objects;

public class GameGrid{
	public static final int GRID_DIM = 9;
	public static final int SUBGRID_DIM = GRID_DIM/3;
	public static final int MAX_VAL = 9;
	public static final int MIN_VAL = 1;
	public static final int EMPTY_VAL = 0;
	private Field[][] grid;
	
	
	public GameGrid(String path){
		this.grid = initialiseGrid(IOUtils.loadFromFile(Objects.requireNonNull(path)));
	}
	
	public GameGrid(int[][] grid) {
		this.grid = initialiseGrid(grid);
		
	}
	
	public GameGrid(GameGrid grid) {
		this.grid = new Field[9][9];
		for (int j = 0; j < 9; j++) {
			for (int i = 0; i < 9; i++) {
				Field currentField = grid.getField(i, j);				
				this.grid[j][i] = new Field(currentField.getValue(), currentField.isInitial());
			}
		}
	}

	private Field[][] initialiseGrid(int[][] grid) {
		Field[][] outputGrid = new Field[9][9];
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				int value = grid[y][x];
				if (value == 0) {
					outputGrid[y][x] = new Field();
				} else {
					outputGrid[y][x] = new Field(value, true);
				}
			}
		}
		return outputGrid;
	}
	
	public boolean isInitial(int x, int y) {
		return this.grid[y][x].initial;
	}
	
    private boolean checkRow(int y, int value) {
    	for (int i = 0; i < 9; i++) {
    		if (grid[y][i].getValue() == value) return false;
    	}
    	return true;
    }
    
    private boolean checkCol(int x, int value) {
    	for (int i = 0; i < 9; i++) {
    		if (grid[i][x].getValue() == value) return false;
    	}
    	return true;
    }
    
    private boolean checkSubGrid(int x, int y, int value) {
    	
    	//set x to the left-top coordinate of the corresponding block
    	if (0 <= x && x <= 2) {
    		x = 0;
    	} else if (3 <= x && x <= 5) {
    		x = 3;
    	} else if (6 <= x && x<= 8) {
    		x = 6;
    	}
    	
    	
    	//set y to the left-top coordinate of the corresponding block
    	if (0 <= y && y <= 2) {
    		y = 0;
    	} else if (3 <= y && y <= 5) {
    		y = 3;
    	} else if (6 <= y && y<= 8) {
    		y = 6;
    	}
    	    	
    	//if the block has the new input already, return false
    	for (int i = 0; i < 3; i++) {
    		for (int j = 0; j < 3; j++) {
    			if (grid[y+i][x+j].getValue() == value) return false;
    		}
    	}
    	
    	//otherwise return true
    	return true; 
  
    }
    
    public boolean isValid(int x, int y, int value)
    {
    	try {
        	return (checkRow(y,value) && checkCol(x,value) && checkSubGrid(x,y,value));
    	} catch (IndexOutOfBoundsException e){
    		throw new IllegalArgumentException("Invalid position");
    	}
    }

    public String toString(){
    	String returnedString = "";
    	int countRow = 0;
    	for (Field[] row : this.grid) {
    		int countCol = 0;
    		for (Field n : row) {
    			if (countCol < 2) {
        			returnedString = (returnedString + n.getValue() + " ");
        			countCol += 1;
    			}else {
    				returnedString = (returnedString + n.getValue() + "\t");
    				countCol = 0;
    			}
    		}
    		if (countRow == 2) {
				returnedString = (returnedString + "\n\n");
        		countRow = 0;
    		} else {
				returnedString = (returnedString + "\n");
    			countRow += 1;
    		}
    	}
    	return returnedString;
    }
    
    public void clearField(int column, int row) {
    	this.grid[row][column].setValue(EMPTY_VAL);
    }

	public Field getField(int column, int row) {
		
    	try {
    		return grid[row][column];
    	} catch (IndexOutOfBoundsException e){
    		throw new IllegalArgumentException("Invalid position");
    	}
	}
	
//	public int getValue(int column, int row) {
//		try {
//			return grid[row][column].getValue();
//		} catch (IndexOutOfBoundsException e) {
//			throw new IllegalArgumentException("Invalid position");
//		}
//	}
	
	public boolean setField(int column, int row, int value)
	{
		if (isValid(column, row, value) && !grid[row][column].isInitial())
		{
			grid[row][column].setValue(value);
			return true;
		}
		else
		{
			return false;
		}
	}
		
}
