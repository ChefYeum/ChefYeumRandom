package tutorial5;

import java.util.Scanner;

import java.util.InputMismatchException;
import java.util.Objects;

public class Sudoku02{

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
    
    public static void main(String[] args) {	
//    	try {
//    		GameGrid grid1 = new GameGrid(args[0]);
//    	} catch (ArrayIndexOutOfBoundsException e) {
//    		throw (new IllegalArgumentException("No path given as an argument"));
//    	}
    	
		GameGrid grid1 = new GameGrid(args[0]);
    	
        gameLoop:
	        while (true) {
	        	printMenu();
	        	int getInput = requestInt("\n\nSelect an option [1-4]:",1,4);
	        	
	        	switch(getInput) {
		        	case 1:			int c = requestInt("Select the column [0-8]: ",0,8);
				        			int r = requestInt("Select the row [0-8]: ",0,8);
				        			int n = requestInt("\nInput the new value [1-9]: " , 1,9);
					        		if (!grid1.setField(r, c, n)) System.out.println("Invalid input.");
					        		System.out.println(grid1);
					        		break;
		        	case 2:			int x = requestInt("Select the column [0-8]: ",0,8);
			        				int y = requestInt("Select the row [0-8]: ",0,8);
			        				grid1.clearField(x,y);
			        				System.out.println(grid1);
			        				break;
		        	case 3: 		System.out.println(grid1);
		        					break;
		        	case 4:			break gameLoop;
		        	default:		System.out.println("Invalid Input");
		        					break;
	        	}
	        }
	        
    }
}
