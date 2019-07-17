package week2;

public class SaferDivider {
	public static void main(String[] args) {
		double den = Double.parseDouble(args[1]);
		
		if (den == 0) {
			System.out.println("I can't divide by zero!");
		}else {
			System.out.println(Double.parseDouble(args[0])/den);
		}
	}
}
