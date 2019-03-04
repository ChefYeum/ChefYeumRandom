package week3;

public class Mode {
	public static void main(String[] args) {
		
		int[] count = new int[10];
		for (String n : args) {
			int num = Integer.parseInt(n);
			count[num]++;
		}
		
		int maxPos = 0;
		System.out.format("[%ds: %d]", 0, count[0]);
		printNDots(count[0]);
				
				
		for (int i = 1; i < 10; i++) {
			System.out.format("[%ds: %d]", i, count[i]);
			
			printNDots(count[i]);
			if (count[i] > count[maxPos]) {
				maxPos = i;
			}
		}
		
		System.out.println("Mode: " + maxPos);
		
	}
	public static void printNDots(int n) {
//		System.out.print(" ");
		for (int i = 0; i < n; i++) {
			System.out.print(".");
		}
		System.out.println();
	}
}
