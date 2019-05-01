import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Hashtable;

class RockPaperScissors {

    /**
     * Returns if a given symbol is a valid symbol for the
     * game.
     * @param symbol the symbol to be checked
     * @return true if the given symbol is valid, false otherwise
     */
    public static boolean isValidSymbol(char symbol) {
        return symbol == 'R' || symbol == 'P' || symbol == 'S';
    }

    public static List<Matchup> parseMatchups(String[] args) {
    	List<Matchup> outputList = new ArrayList<>();
    	for (String s: args) {
    		if (s.length() == 2) {
    			char[] twoChars = s.toCharArray();
    			try {
    				char symbol1 = twoChars[0];
    				char symbol2 = twoChars[1];
    				if (isValidSymbol(symbol1) && isValidSymbol(symbol2)) {
    					outputList.add(new Matchup(symbol1, symbol2));
    				}
    			} catch (IllegalArgumentException e){}
    		}
    	}
        return outputList;
    }

    /**
     * Returns the outcome of a given matchup as String.
     *
     * @param match The matchup to be decided.
     * @return a String representation of the matchup result; R, P, S or DRAW
     * @throws IllegalArgumentException if the given matchup parameter is null
     */
    public static String decideOutcome(Matchup match) {
        if(match == null)
            throw new IllegalArgumentException("Given match must not be null!");

        String res = "" + match.getPlayerOne() + match.getPlayerTwo();

        if (res.equals("RP") || res.equals("PR")) return "P";
        if (res.equals("RS") || res.equals("SR")) return "R";
        if (res.equals("PS") || res.equals("SP")) return "S";

        return "DRAW";
    }

    public static Map<String, Integer> countOutcomes(List<Matchup> matches) {
  

		Map<String, Integer> countMap = new Hashtable<>();
    	if (!matches.isEmpty()) {
    		String maxOutcome = "DRAW";
			for (Matchup m : matches) {
				String outcome = RockPaperScissors.decideOutcome(m);
				countMap.put(outcome, countMap.getOrDefault(outcome, 0)+1);
				if (countMap.getOrDefault(outcome,0) > countMap.getOrDefault(maxOutcome,0)) maxOutcome = outcome;
			}
			System.out.printf("Most outcomes: %s", maxOutcome);
    	}
		return countMap;
    } 

    /**
     * Executes different functionality for the game RockPaperScissors.
     *
     * @param args A series of matchups encoded as pairs of single characters.
     * The series of matchups can be empty.
     */
    public static void main(String[] args) {
        List<Matchup> matches = parseMatchups(args);
        System.out.println(matches);
    
        if(matches != null) {
            System.out.println(matches.size() + " matches parsed.");

            System.out.println("\nCount outcomes per symbol...");
            Map<String, Integer> outcomesPerSymbol = countOutcomes(matches);
            System.out.println(outcomesPerSymbol);
        }
    }

}
