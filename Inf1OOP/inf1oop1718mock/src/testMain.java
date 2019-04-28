import java.util.List;
public class testMain{
	public static void main(String[] args) {
		List<Matchup> testR = RockPaperScissors.parseMatchups(new String[] {"RP","PR", "RR", "RS","TT","hehe","what"});
		System.out.println(testR);
	}
}