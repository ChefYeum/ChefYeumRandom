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


			//Original: Convert Integer[] to int[] to return
			int[] returnedArray1 = new int[countMap.size()];
			for (int i = 0; i < countMap.size(); i++) {
				returnedArray1[i] = countMap.values().toArray(new Integer[0])[i].intValue();
			}

			
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
//		System.out.println(Arrays.toString(charCount("hatcccbd"))); //Test case 1: should print [1, 1, 3, 1, 1, 1]
//		System.out.println(Arrays.toString(charCount("abcdefghijklmn"))); //Test case 2: should return lots of 1s
//		System.out.println(Arrays.toString(charCount("xxxa"))); //Test case 2: should return [1,3]
//		System.out.println(Arrays.toString(charCount("abbc"))); //Test case 3: should return [1,2,1]
		
		
//		System.out.println(Arrays.toString(normalise(new int[] {2,1,1}))); //should return {0.5,0.25, 0.25}
//		System.out.println(Arrays.toString(normalise(charCount("abbc")))); //should return {0.25, 0.5, 0.25}
		
//		System.out.println((entropyOf(new double [] {0.5, 0.25, 0.25}))); //should return 1.0397

		for (int[] arr : charCountArray(new String[] {"abbcccxx","bbccyzdd"})) {
			System.out.println(Arrays.toString(arr));
		}

	}
}