import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Beads {
	private static int getSum(int startPos, int endPos, ArrayList<Integer> beads) {
		int sum = 0;
		for (int i = startPos; i <= endPos; i++) {
			sum += beads.get(i%(beads.size()));
		}
		

		return sum;
	}

	public static Set<Integer> sums(ArrayList<Integer> beads, int sumLen){
		Set<Integer> outputSet = new HashSet<Integer>();
		if (beads.isEmpty() || sumLen == 0) return outputSet;
		for (int i = 0; i < beads.size(); i++) {
			outputSet.add(getSum(i,i+sumLen-1,beads));
		}
//		for (int startPos = 0; startPos < beads.size()-1+sumLen; startPos++) {
//			int endPos = (startPos+sumLen-1)%beads.size();
//			int sum = (getSum(startPos,endPos,beads));
//			outputSet.add(sum);
//		}
		
		return outputSet;
	}
	
	public static Set<Integer> allSums(ArrayList<Integer> beads){
		Set<Integer> outputSet = new HashSet<Integer>();
		for (int len = 1; len <= beads.size(); len++) {
			outputSet.addAll(sums(beads, len));
		}
		
		return outputSet;
	}
	
	public static int max(Integer[] nums) {
		int maxPos = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[maxPos] < nums[i]) maxPos = i;
		}
		return maxPos;
	}

	public static int findMax(Set<Integer> nums) {
		if (nums.isEmpty()) return 0;
		Integer[] numbers = nums.toArray(new Integer[1]);
		Arrays.sort(numbers);
		for (int i = numbers.length-1; i >= 0; i--) {
			int n = numbers[i];
			boolean allValid = true;
			for (int s = 1; s <= n; s++) {
				if (!nums.contains(s)) allValid = false;
			}
			if (allValid) return n;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<>();
		for (String n : args) {
			nums.add(Integer.parseInt(n));
		}
		System.out.println(findMax(allSums(nums)));
	}
	
}