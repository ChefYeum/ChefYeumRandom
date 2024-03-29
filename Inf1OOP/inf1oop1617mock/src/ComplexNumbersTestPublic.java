import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class ComplexNumbersTestPublic {

	@org.junit.Test(timeout=5000)
	public void testComplexAddition() {
		double[] a = new double[2];
		double[] b = new double[2];
		
		a[0] = 3.26;
		a[1] = 2.33;
		b[0] = 2.01;
		b[1] = 5.11;
		
		double[] result = ComplexNumbers.complexAdd(a, b);
		 
	
	}
	
	@org.junit.Test(timeout=5000)
	public void testComplexConjugate() {
		double[] a = new double[2];

		a[0] = 2.01;
		a[1] = -5.11;
		
		double[] result =  ComplexNumbers.complexConjugate(a);

	}
	
	@org.junit.Test(timeout=5000)
	public void testComplexProduct() {
		double[] a = new double[2];
		double[] b = new double[2];
		
		a[0] = 3.26;
		a[1] = -2.33;
		b[0] = -2.01;
		b[1] = 5.11;
		
		double result[] =  ComplexNumbers.complexMultiply(a, b);

	}

	@org.junit.Test(timeout=5000)
	public void testComplexReciprocal() {
		double[] a = new double[2];

		a[0] = -0.06666;
		a[1] = -0.169;
		
		double[] result = ComplexNumbers.complexReciprocal(a);
	}
	
	@org.junit.Test(timeout=5000)
	public void testComplexToString() {
		double[] a = new double[2];

		a[0] = 0.0;
		a[1] = -3.45;

		String result =  ComplexNumbers.toString(a);
		
	}
	
	@org.junit.Test(timeout=5000)
	public void testSorting() {
		double[][] unsorted = new double[5][2];
		double[] a = new double[2];
		double[] b = new double[2];
		double[] c = new double[2];
		double[] d = new double[2];
		double[] e = new double[2];

		a[0] = 1;
		a[1] = 1;
		b[0] = 2;
		b[1] = 2;
		c[0] = 3;
		c[1] = 3;
		d[0] = 4;
		d[1] = 4;
		e[0] = 5;
		e[1] = 5;

		unsorted[0] = c;
		unsorted[1] = a;
		unsorted[2] = e;
		unsorted[3] = d;
		unsorted[4] = b;
		
		double[][] result = ComplexNumbers.sortByMagnitude(unsorted);
		
	}
	@org.junit.Test()
	public void testA(){
		assertTrue(ComplexNumbers.complexAdd(new double[]{1.0, 2.0}, new double[]{3.0, 4.0}).equals(new double[] {4.0,6.0}));
	}
	@org.junit.Test()
	public void testToStr() {
		assertEquals("String representation", ComplexNumbers.toString(new double[] {1,2}), "1.0+2.0i");
		assertEquals("String representation", ComplexNumbers.toString(new double[] {5.6666, -7.12}), "5.7-7.1i");
		assertEquals("String representation", ComplexNumbers.toString(new double[] {-3.355, -1.0}), "-3.4-1.0i");
		assertEquals("String representation", ComplexNumbers.toString(new double[] {-1.0, 0.0}), "-1.0");
		assertEquals("String representation", ComplexNumbers.toString(new double[] {0.0, -3.45}), "-3.5i");
		assertEquals("String representation", ComplexNumbers.toString(new double[] {0.0, 0.0}), "0.0");
		
	}
	
	
}
