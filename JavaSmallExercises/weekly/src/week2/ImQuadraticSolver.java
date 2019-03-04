package week2;

public class ImQuadraticSolver {
	public static void main(String[] args) {
		double a = Double.parseDouble(args[0]);
		double b = Double.parseDouble(args[1]);
		double c = Double.parseDouble(args[2]);
		double disc = Math.pow(b, 2)-4*a*c;
		
		if (a == 0) {
			System.out.println(-c/b);
		}else {
			if (disc < 0) {
				double real = -b/(2*a);
				double imaginary = Math.sqrt(-disc)/(2*a);
				System.out.println( real + " + " + imaginary + "i");
				System.out.println( real + " - " + imaginary + "i");
	
			}else {
				System.out.println((-b+Math.sqrt(disc))/(2*a));
				System.out.println((-b-Math.sqrt(disc))/(2*a));
			}
		}
		
	}
}
