public class GameGrid{
	private final int[][]  grid = new int[9][9];
	public static final int GRID_DIM = 9;
	public static final int SUBGRID_DIM = GRID_DIM/3;
	public static final int MAX_VAL = 9;
	public static final int MIN_VAL = 1;
	public static final int EMPTY_VAL = 0;
	
	public GameGrid(int[][] grid){
		grid = grid;		
	}
	public static int[][] returnGrid(){
		return grid;
	}
		
}
