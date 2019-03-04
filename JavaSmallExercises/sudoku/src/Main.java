

import java.util.Scanner;

import java.util.InputMismatchException;
import java.util.Objects;

public class Main{

    private static Scanner in;

	/**
     * Print a game menu message to the console.
     */
    public static void printMenu() {
        System.out.print("1. Set field\n2. Clear field\n3. Print game\n4. Exit");
    }   

    /**
     * Read a single integer value from the console and return it.
     * This function blocks the program's execution until a user
     * entered a value into the command line and confirmed by pressing
     * the Enter key.
     * @return The user's input as integer or -1 if the user's input was invalid.
     */
    public static int parseInput() {
        in = new Scanner(System.in);
        try {
            return in.nextInt();
        } catch (InputMismatchException missE) {
            in.next(); // discard invalid input
            return -1;
        }
    }   

    /**
     * Display a dialog requesting a single integer which is returned
     * upon completion.
     *
     * The dialog is repeated in an endless loop if the given input 
     * is not an integer or not within min and max bounds.
     *
     * @param msg: a name for the requested data.
     * @param min: minium accepted integer.
     * @param max: maximum accepted integer.
     * @return The user's input as integer.
     */
    public static int requestInt(String msg, int min, int max) {
        Objects.requireNonNull(msg);

        while(true) {
            System.out.print(msg);
            int input = parseInput();
            if (input >= min && input <= max) return input;
            else {
                System.out.println("Invalid input. Must be between " + min + " and " + max);
            }
        }
    }
    
    public static void printGrid(int[][] pGrid) {
    	int countRow = 0;
    	for (int[] row : pGrid) {
    	
    		int countCol = 0;
    		for (int n : row) {
    			if (countCol < 2) {
        			System.out.print(n+" ");
        			countCol += 1;
    			}else {
    				System.out.print(n+"\t");
    				countCol = 0;
    			}
    		}
    		if (countRow == 2) {
        		System.out.println("\n");
        		countRow = 0;
    		} else {
    			System.out.println();
    			countRow += 1;
    		}
    	}
    }

    public static boolean checkRow(int x, int y, int value, int[][] grid) {
    	for (int i = 0; i < 9; i++) {
    		if (grid[y][i] == value) return false;
    	}
    	return true;
    }
    
    public static boolean checkCol(int x, int y, int value, int[][] grid) {
    	for (int i = 0; i < 9; i ++) {
    		if (grid[i][x] == value) return false;
    	}
    	return true;
    }
    
    public static boolean checkSubGrid(int x, int y, int value, int[][] grid) {
    	
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
    			if (grid[y+i][x+j] == value) return false;
    		}
    	}
    	
    	//otherwise return true
    	return true; 
  
    }
    
    public static boolean isValid(int x, int y, int value, int[][] grid) {
    	return (checkRow(x,y,value,grid) && checkCol(x,y,value,grid) && checkSubGrid(x,y,value,grid));
    }
    
    
    public static void main(String[] args) {
        int[][] grid = {
            {9,4,0,1,0,2,0,5,8},
            {6,0,0,0,5,0,0,0,4},
            {0,0,2,4,0,3,1,0,0},
            {0,2,0,0,0,0,0,6,0},
            {5,0,8,0,2,0,4,0,1},
            {0,6,0,0,0,0,0,8,0},
            {0,0,1,6,0,8,7,0,0},
            {7,0,0,0,4,0,0,0,3},
            {4,3,0,5,0,9,0,1,2}
        };
	
	GameGrid gameGrid = new GameGrid(grid);
	
        printGrid(grid);
        gameLoop:
	        while (true) {
	        	printMenu();
	        	int getInput = requestInt("\n\nSelect an option [1-4]:",1,4);
	        	
	        	switch(getInput) {
		        	case 1:		boolean valid = false;
		        				
		        				while (!valid) {
			        				int c = requestInt("Select the column [0-8]: ",0,8);
				        			int r = requestInt("Select the row [0-8]: ",0,8);
				        			int n = requestInt("\nInput the new value [1-9]: " , 1,9);
				        			valid = isValid(c,r,n,grid);
				        			if (valid) {
					        			grid[r][c] = n;
					        			printGrid(grid);
					        			break;
				        			} else {
				        				System.out.println("Invalid input. Please try again.");
				        			}

		        				}

		        	case 2:		int x = requestInt("Select the column [0-8]: ",0,8);
			        			int y = requestInt("Select the row [0-8]: ",0,8);
			        			grid[x][y] = 0;
			        			printGrid(grid);
				    			break;
		        	case 3: 	printGrid(grid);
		        				break;
		        	case 4:		break gameLoop;
		        	default:	System.out.println("Invalid Input");
		        				break;
	        	}
	        }
	        
    }
}
