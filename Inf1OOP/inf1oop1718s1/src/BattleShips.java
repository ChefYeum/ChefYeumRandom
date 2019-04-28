import java.util.Map;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class BattleShips {

    public static char fireShot(char[][] grid, Position shot) {
    	try {
    		int x = shot.getX();
    		int y = shot.getY();
    		char temp = grid[y][x];
    		if (temp == '#') {
    			System.out.println(shot + ": Miss");
    		}
    		else {
    			grid[y][x] = '#';
    			System.out.println(shot + ": Hit " + temp);
    		}
    		return temp;
    	} catch (IndexOutOfBoundsException e) {
    		System.out.println(shot + ": " + "Out of Bounds");
    		return '#';
    	}
    }

    public static Hashtable<Character, Integer> findShips(char[][] grid) {
    	Hashtable<Character, Integer> outputMap = new Hashtable<>();
    	for (char[] row : grid) {
    		for (char c : row) {
    			if (c!='#') outputMap.put(c,outputMap.getOrDefault(c, 0)+1);
    		}
    	}
    	return outputMap;
    }


    public static List<Character> fireShots(char[][] grid, List<Position> shots) {
    	ArrayList<Character> outputList = new ArrayList<>();
    	Map<Character, Integer> originalShips = findShips(grid);
    	
    	for (Position p: shots) {
    		char firedLetter = fireShot(grid, p);
    		if (firedLetter != '#') {
    			if (originalShips.get(firedLetter) == 1) outputList.add(firedLetter);
    			else originalShips.put(firedLetter, originalShips.get(firedLetter)-1);
    		}
    	}
    	return outputList;
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please execute this program by"
                    + " providing the path to a game file,"
                    + " e.g. java BattleShips ./game01.txt");
            System.exit(1);
        }

        char[][] grid = BattleShipsUtils.parseGrid(args[0]);

        System.out.println("Playing with grid: ");
        BattleShipsUtils.printGrid(grid);

        Position centreShot = new Position(grid.length / 2,
                                           grid.length / 2);
        System.out.println("\nFiring Shot at centre " +
                            centreShot.toString() + " ...");
        fireShot(grid, centreShot);

        System.out.println("\nGenerating shots ...");
        List<Position> shots = BattleShipsUtils.generateShots(grid.length,
                                    grid.length * 2);
        System.out.println("Shots: " + shots);

        System.out.println("\nFinding Ships ...");
        Map<Character, Integer> ships = findShips(grid);
    	if(ships != null) {
           for (Character ship : ships.keySet())
             System.out.println(ship + " has size " + ships.get(ship));
    	}

        System.out.println("\nFiring shots ...");
    	if(shots != null) {
            List<Character> destroyedShips = fireShots(grid, shots);
    	    if (destroyedShips != null && !destroyedShips.isEmpty()) {
    	        System.out.println("Destroyed ships: ");
    	        for(char ship : destroyedShips)
    	            System.out.println(ship);
    	    }
    	    System.out.println(destroyedShips);
    	}
    }
}
