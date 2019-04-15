import java.util.Map;

class MineSweeper {

    public static Map<String, Position> findMines(char[][] grid) {
        // Implement me!
        return null;
    }

    public static boolean isIsolated(char[][] grid, Position minePos) {
        // Implement me!
        return false;
    }

    public static int disarmMines(char[][] grid, Map<String, Position> armedMines) {
        // Implement me!
        return 0;
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please execute this program by"
                    + " providing the path to a game file,"
                    + " e.g. java MineSweeper ./game01.txt");
            System.exit(1);
        }

        char[][] grid = MineSweeperUtils.parseGrid(args[0]);
        System.out.println("Playing with grid: ");
        MineSweeperUtils.printGrid(grid);

        System.out.println("Searching mines ...");
        Map<String, Position> mines = findMines(grid);
        if(mines != null) {
            if(mines.isEmpty()) System.out.println("No mines found.");
            else System.out.println("Mines found at: " + mines.keySet());
        }

        System.out.println("\nDisarming mines ...");
        int disarmed = disarmMines(grid, mines);
        System.out.println(disarmed + " mines disarmed!");
        MineSweeperUtils.printGrid(grid, mines);
    }
}
