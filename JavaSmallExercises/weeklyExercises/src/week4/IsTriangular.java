class IsTriangular{
	public static boolean isTri(double a, double b, double c)
	{
		double longestSide = Math.max(Math.max(a,b),c);
		double perimeter = a+b+c;
		return  (longestSide < (perimeter)-longestSide);
	}	
	public static void main(String[] args){	
		double a = StdIn.readDouble();
		double b = StdIn.readDouble();
		double c = StdIn.readDouble();
		
		if (isTri(a,b,c))
		{
			System.out.format("%s, %s and %s could be the lengths of a triangle\n", a, b, c);
		}
		else
		{
			System.out.println("Not a triangle.");
		}
	}
}
