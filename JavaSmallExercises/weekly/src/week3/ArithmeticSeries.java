package week3;

public class ArithmeticSeries {
	public static void main(String[] args) {
		int counter = 1;
		int sum = 0;
		while (counter <= Integer.parseInt(args[0])) {
			sum += counter;
			counter++;
		}
		System.out.println(sum);
	}
}
