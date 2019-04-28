import java.util.Arrays;
import java.util.HashMap;

public class Divergence {
	public static int[] charCount(String s) {
		HashMap<Character, Integer> countTable = new HashMap<>();
		for (char c: s.toCharArray()) countTable.put(c, countTable.getOrDefault(c, 0)+1);
		Object[] values = countTable.values().toArray();
		int[] countArr = new int[values.length];
		for (int i= 0; i < values.length; i++) countArr[i] = (int) values[i];
		return countArr;
	}
	
	public static double[] normalise(int[] c) {
		double getSum = 0;
		for (int n: c) getSum+=n;
		
		double[] output = new double[c.length];
		
		for (int i=0; i < c.length; i++) {
			output[i] = c[i]/getSum;
		}
		
		return output;
	}
	
	public static double kld(double[] p, double[] q) {
		double kld = 0;
		for (int i=0; i < p.length; i++) kld += p[i]*Math.log(p[i]/q[i]);
		return kld;
	}
	
	public static int[][] charCountArray(String[] a){

		HashMap<Character, Integer> coapp = new HashMap<>();
		for (String s: a) {
			//Get all the characters that appeared in current string
			HashMap<Character, Boolean> appeared = new HashMap<>();
			for (char c: s.toCharArray()) appeared.put(c, true); 
			
			for (Object c: appeared.keySet().toArray()) {
				char key = (char) c;
				coapp.put(key, coapp.getOrDefault(key, 0)+1);
			}
		}
		
		int[][] outputArr = new int[a.length][];
		
		for (int i=0; i < a.length; i++) {
			String currentStr = a[i];
			StringBuilder filteredStr = new StringBuilder();
			for (char c: currentStr.toCharArray()) {
				if (coapp.get(c) == a.length) filteredStr.append(c);
			}
			outputArr[i] = charCount(filteredStr.toString());
		}
		
		return outputArr;

	}
	
	public static void main(String[] args) {
		System.out.println("Counting " + args[0] + " : " + Arrays.toString(charCount(args[0])));
		System.out.println("Symbol probabilities in " + args[0] + " : " + Arrays.toString(normalise(charCount(args[0]))));
		System.out.println("Symbol probabilities in " + args[1] + " : " + Arrays.toString(normalise(charCount(args[1]))));
		int[][] ssc = charCountArray(new String[] {args[0], args[1]});
		System.out.printf("Shared Symbol Count : [%s, %s]\n", Arrays.toString(ssc[0]), Arrays.toString(ssc[1]));
		System.out.println("Divergence PQ : " + kld(normalise(ssc[0]),normalise(ssc[1])));
	}
		
}
