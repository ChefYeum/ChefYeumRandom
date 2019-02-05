package week3;

import java.util.stream.Collectors;


public class MeanVariance {
	public static void main(String args[]) {
		double[] inputNums = new double[args.length];
		for (int n = 0; n < args.length; n++) {
			inputNums[n] = Double.parseDouble(args[n]);
		}
		System.out.println(mean(inputNums));
		System.out.println(var(inputNums));
		
	}
	public static double mean(double[] nums) {
		double sum = 0;
		for (double n : nums) {
			sum += n;
		}
		return (sum/nums.length);
	}
	public static double var(double[] nums) {
		double sdm = 0;
		double mean = mean(nums);
		for (double n : nums) {
			sdm += Math.pow((n-mean),2);
		}
		return (sdm/nums.length);
	}
}
