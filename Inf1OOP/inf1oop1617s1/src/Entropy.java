import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.stream.*;
//Entropy provides a measure of the uncertainty in a probability distribution.
//Use Arrays.toString Arrays.sort
//input strings contain only lowercase letters a-z throughout


public class Entropy {
	public static int[] charCount(String s) {
		HashMap<Character,Integer> countMap = new HashMap<>();
		if (s == null || s.length() == 0) return null;
		else {
			for (char c:s.toCharArray()) countMap.put(c, countMap.getOrDefault(c,0)+1);


//			//Original: Convert Integer[] to int[] to return
//			int[] returnedArray1 = new int[countMap.size()];
//			for (int i = 0; i < countMap.size(); i++) {
//				returnedArray1[i] = countMap.values().toArray(new Integer[0])[i].intValue();
//			}

			
			//Revised: Convert Integer[] to int[] to return
			int[] returnedArray2 = countMap.values().stream().mapToInt(i->i).toArray();

			
			
			return returnedArray2; 
		}
		
	}
	
	public static double[] normalise(int[] c) {
		//if null? or empty?
		int getSum = IntStream.of(c).sum();

		double[] returnedArray = new double[c.length]; 
		for (int i = 0; i < c.length; i++) returnedArray[i] = (double) c[i]/getSum; // normalise each element
		
		return returnedArray;
		
	}
	
	public static double entropyOf(double[] p) { //0 < p_i <1
		double sum2 = DoubleStream.of(p).map(x->x*Math.log(x)).sum();
		return -sum2;
	}
	
//	public static int[][] charCountArray(String[] a){
//		ArrayList<Character> usedChars = new ArrayList<>();
//		ArrayList<Character> reusedChars = new ArrayList<>();
//		for (String s : a) {
//			for (char c : s.toCharArray()) {
//				if (usedChars.contains(c)) reusedChars.add(c);
//				else usedChars.add(c);
//			}
//		}
//		
//		int[][] outputArr = new int[a.length][];
//		
//		for (int i = 0; i < a.length; i++) {
//			HashMap<Character,Integer> countMap = new HashMap<>();
//			for (char c: a[i].toCharArray()) {
//				if (reusedChars.contains(c)) countMap.remove(c);
//				else countMap.put(c, countMap.getOrDefault(c, 0)+1);
//			}
//			
//			outputArr[i] = countMap.values().stream().mapToInt(x->x).toArray();
//		}
//		
//		return outputArr;
//	}
	
	public static int[][] charCountArray(String[] a){
		//Get how many Strings the character occurs
		Hashtable<Character,Integer> countOcc= new Hashtable<>();
		for (String word:a) {
			HashSet<Character> usedChars = new HashSet<>();
			for (char c: word.toCharArray()) usedChars.add(c);
			for (char c: usedChars) countOcc.put(c, countOcc.getOrDefault(c, 0)+1);
		}
		
		int[][] outputArr = new int[a.length][];
		
		for (int i = 0; i < a.length; i++) {
			Hashtable<Character,Integer> wordCountFreq = new Hashtable<>();
			char[] currentStr = a[i].toCharArray();
			Arrays.sort(currentStr);
			for (char c: currentStr){
				//if the character occurs only once, count it
				if (countOcc.get(c) == 1) wordCountFreq.put(c, wordCountFreq.getOrDefault(c, 0)+1);
			}
			
			outputArr[i] = wordCountFreq.values().stream().mapToInt(x->x).toArray();
		}
		
		return outputArr;
	}
	
	public static void main(String[] args) {
		for (int[] arr : charCountArray(new String[] {"abbcccxx","bbccyzdd"})) {
			System.out.println(Arrays.toString(arr));
		}

	}
}