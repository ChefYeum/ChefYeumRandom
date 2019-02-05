package week2;

public class MultiplesLoopRange {
	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int c = Integer.parseInt(args[2]);
//		boolean backwards = false;
//		
//		if (a>b) {
//			int temp = b;
//			b = a;
//			a = temp;
//			backwards = true;
//		}
//		
//		if (a%c != 0) {
//			a = (a/c) + 1;
//		} else {
//			a = a/c;
//		}
//		if (b%c != 0) {
//			b = (b/c) + 1;
//		} else {
//			b = b/c;
//		}
//		
//		if (backwards) {
//			for (int i = b; i >= a; i--) {
//				System.out.println(i*c);
//			}
//		} else {
//			for (int i = a; i <= b; i++) {
//				System.out.println(i*c);
//			}
//		}
		if (a < b) {
			for (int n = a; n <= b; n++) {
				if (n % c == 0){
					System.out.print(n + " ");
				}
			}
		} else {
			for (int n = a; n >= b; n--) {
				if (n % c == 0) {
					System.out.print(n + " ");
				}
			}
			
		}
	}
}
