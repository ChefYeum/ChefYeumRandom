package week3;

import java.util.stream.IntStream;
import java.lang.Integer;


public class Sieve {
	public static void main(String[] args) {
		
//		int n = Integer.parseInt(args[0]);
		int n = 20;
				
		int[] sievedNumbers = IntStream.range(2,n+1).toArray();
		int p = 0;
		boolean pChanged = true;

		
		
		while (pChanged == true){
			pChanged = false;
			for (int x : sievedNumbers) {
				if (x!=0) {
					System.out.print(x + " ");
					p = x;
					pChanged = true;
					break;
				}
			}
			for (int i = 0; i < sievedNumbers.length; i++) {
				if (!(sievedNumbers[i] == 0) && (sievedNumbers[i] % p == 0)){
						sievedNumbers[i] = 0;
				}
			}
			
		}
		System.out.println();
	}
}
