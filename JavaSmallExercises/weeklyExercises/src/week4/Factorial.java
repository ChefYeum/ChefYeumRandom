package week4;



public class Factorial
{
	public static int factorial(int N)
	{
		if (N <= 0) return 1;
		else return N*factorial(N-1);
	}
	public static void main(String[] args) {
		System.out.println(factorial(1));
		
	}
}	
