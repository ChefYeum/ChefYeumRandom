

import java.util.*;

public class ComplexNumbers {
	public static double[] complexAdd(double[] z1, double[] z2) {
		return new double[] {(z1[0]+z2[0]),(z1[1]+z2[1])};
	}
	

	
	public static double[] complexConjugate(double[] z) {
		return new double[] {z[0],-z[1]};
	}
	
	public static double[] complexMultiply(double[] z1, double[] z2) {
		double a = z1[0];
		double b = z1[1];
		double c = z2[0];
		double d = z2[1];
		return new double[] {(a*c-b*d),(b*c+a*d)};
	}
	
	public static double[] complexReciprocal(double[] z) {
		double a = z[0];
		double b = z[1];
		return new double[] {(a/(Math.pow(a, 2)+Math.pow(b, 2))),
							(-b/(Math.pow(a, 2)+Math.pow(b, 2)))};
	}
	
	public static String toString(double[] z) {
		double realPart = Math.round(z[0]*10)/10.0; 
		double imaginaryPart = Math.round(z[1]*10)/10.0;
		
		String posSign = (imaginaryPart > 0 ) ? "+" : "";
		if (imaginaryPart == 0.0) return Double.toString(realPart);
		else if (realPart == 0.0) return Double.toString(imaginaryPart) + "i";
		else {		
			return (realPart+ posSign + Double.toString(imaginaryPart) + "i");
		}
	}
	
	private static double magnitude(double[] z) {
		if (Objects.isNull(z)) return -1;
		else {
			double a = z[0];
			double b = z[1];
			return Math.sqrt(Math.pow(a, 2)+Math.pow(b, 2));
		}
	}
	
	
	public static double[][] sortByMagnitude(double[][] complexList){
		double[][] outputArr = new double[complexList.length][];
		
		for (int i = complexList.length-1; i >= 0; i--) {
			int maxPos = 0;
			for (int j = 1; j < complexList.length; j++) {
				if (magnitude(complexList[j]) >= magnitude(complexList[maxPos])) {
					maxPos = j;
				}
			}
			outputArr[i] = complexList[maxPos];
			complexList[maxPos]= null;
		}
		
		return outputArr;
	}
	
	public static void main(String[] args) {
		double[] z1 = new double[] {Double.parseDouble(args[0]), Double.parseDouble(args[1])};
		double[] z2 = new double[] {Double.parseDouble(args[2]), Double.parseDouble(args[3])};
		
		System.out.println("("+toString(complexAdd(z1,z2))+")");
		System.out.println("("+toString(complexConjugate(z1))+")");
		System.out.println("("+toString(complexMultiply(z1,z2))+")");
		System.out.println("("+toString(complexReciprocal(z1))+")");
		System.out.println("("+toString(complexConjugate(complexAdd(z1,z2)))+")");
	}
}

