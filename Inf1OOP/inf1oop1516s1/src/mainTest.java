import java.util.*;
public class mainTest {
	public static void main(String[] args) {
//		ArrayList<Integer> inputTest = new ArrayList<>();
//		int[] inputArr = new int[] {6,1,3};
//		for (int n : inputArr) {
//			inputTest.add(n);
//		}
//		Set<Integer> sumTest = Beads.allSums(inputTest);
//
//		System.out.println(sumTest);
	
		Set<Integer> setInput = new HashSet<Integer>();
		int[] inputArr = new int[] {6};
		for (int n : inputArr) {
			setInput.add(n);
		}
		
		int n = Beads.findMax(setInput);

		System.out.println(n);
	}
}
