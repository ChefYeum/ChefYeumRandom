package week2;

public class QuadraticSolver {
	public static void main(String[] args) {
		double a = Double.parseDouble(args[0]);
		double b = Double.parseDouble(args[1]);
		double c = Double.parseDouble(args[2]);
		double disc = Math.pow(b, 2)-4*a*c;

		if (disc < 0) {
			System.out.println("No real solution");
		}else {
			System.out.println((-b+Math.sqrt(disc))/(2*a));
			System.out.println((-b-Math.sqrt(disc))/(2*a));
	
		}

	}
}