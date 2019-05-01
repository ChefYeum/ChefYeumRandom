import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.Before;


public class BeadsTest {

	@Test
	public void testAllSums() {
		ArrayList<Integer> arg = new ArrayList<Integer>();
		arg.add(3);
		Set<Integer> s = Beads.allSums(arg);
	}

	@Test
	public void testSums() {
		ArrayList<Integer> arg = new ArrayList<Integer>();
		arg.add(3);
		Set<Integer> s = Beads.sums(arg, 1);
	}

	@Test
	public void testFindMax() {
		Set<Integer> arg = new HashSet<Integer>();
		arg.add(3);
		int i = Beads.findMax(arg);
	}

	@Test
	public void testMain() {
		String[] inputs = {"6","1","3"};
		Beads.main(inputs);
	}
	
	@Test
	public void testA1() {
		int[] inputArr = new int[] {1,2,3,4};
		ArrayList<Integer> inputTest = new ArrayList<>();
		for (int n : inputArr) {
			inputTest.add(n);
		}

		Set<Integer> sumTest = Beads.sums(inputTest,2);

		assertTrue(sumTest.equals(new HashSet<Integer>((new Integer[] {3,5,7}).t)));
		
	}
	
//	@Before
//	public void testBefore() {
//		ArrayList<Integer> inputTest = new ArrayList<>();
//	}
//	
//	@Test
//	public void testA() {
//		
//		Set<Integer> sumTest = Beads.sums(inputTest,2);
//		assertTrue(sumTest.equals(new HashSet<Integer>());		
//	}
//	

}
