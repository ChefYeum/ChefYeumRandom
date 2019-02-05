package week2;

public class Distance2 {
	public static void main(String[] args) {
		System.out.println(distanceAbs(Integer.parseInt(args[0]),Integer.parseInt(args[1])));
	}
	public static int distanceAbs(int a, int b) {
		return (Math.abs(a-b));
	}
}
