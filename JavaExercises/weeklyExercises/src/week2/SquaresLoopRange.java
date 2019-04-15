package week2;

public class SquaresLoopRange {
	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		
		if (a <= b) {
			for (int n = a; n <= b; n++) {
				System.out.print((int) Math.pow(n, 2) + " ");
			}
			System.out.println();
		}else {
			System.out.println("Start-limit greater than stop-limit!");
		}
		
	}
}
