package week2;

public class Distance1 {
	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		System.out.println(distanceMinMax(a,b));
	}
	public static int distanceMinMax(int a, int b) {
		return (Math.max(a, b) - Math.min(a,b));
	}

}
