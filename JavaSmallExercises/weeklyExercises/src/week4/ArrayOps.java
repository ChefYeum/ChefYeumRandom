package week4;

public class ArrayOps
{
	public static double findMax(double[] data)
	{
		double max = data[0];
		for (int i = 1; i < data.length; i++)
		{
			if (data[i] > max) max = data[i];
		}
		return max;
	}
	public static double[] normalise(double[] inputData)
	{	
		double[] data = inputData.clone();
		double sum = 0;
		for (double n : data) sum = n+sum;
		for (int i=0; i < data.length; i++)
		{
			data[i] = data[i]/sum;
		}
		return data;
	}
	public static void normaliseInPlace(double[] data)
	{	
		double sum = 0;
		for (double n : data) sum = n+sum;
		for (int i=0; i < data.length; i++)
		{
			data[i] = data[i]/sum;
		}
	}
	public static double[] reverse(double[] inputData)
	{
		double[] data = inputData.clone();
		for (int i = 0; i < data.length/2; i++)
		{
			double temp = data[i];
			data[i] = data[data.length-1-i];
			data[data.length-1-i] = temp;
		}
		return data;
	}
	public static void reverseInPlace(double[] data)
	{
		for (int i = 0; i < data.length/2; i++)
		{
			double temp = data[i];
			data[i] = data[data.length-1-i];
			data[data.length-1-i] = temp;
		}
	}
	public static void swap(double[] data1, double[] data2)
	{
		for (int i = 0; i < data1.length; i++)
		{
			double temp = data1[i];
			data1[i] = data2[i];
			data2[i] = temp;
		}
	}
}
