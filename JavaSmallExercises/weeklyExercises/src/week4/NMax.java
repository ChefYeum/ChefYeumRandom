import java.lang.Math

class NMax
{
	public static int max(int a, int b, int c)
	{
		return Math.max(a, Math.max(b, c));
	}
	
	public static double max(double a, double b, double c)
	{
		return Math.max(a, Math.max(b, c));
	}

	public static void main(String[] args)
	{
		double a = StdIn.readInt();
		double b = StdIn.readInt();
		double c = StdIn.readInt();

		System.out.println(max(a,b,c));		
	}
}
