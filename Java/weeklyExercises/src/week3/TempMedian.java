package week3;

import java.util.Arrays;

public class TempMedian {
	public static void main(String[] args) {
		
		//Get input in nums
		int[] nums = new int[args.length];
		nums[0] = Integer.parseInt(args[0]);
		for (int i = 1; i < args.length; i++) {
			switch (args[i]) {
				case ".":
					nums[i] = nums[i-1];
					break;
				case "+":
					nums[i] = nums[i-1]+1;
					break;
				case "-":
					nums[i] = nums[i-1]-1;
					break;
			}
			 
		}
		printArray(nums);

		
		Arrays.sort(nums);
		
		printArray(nums);
		
		
		//Get median
		int len = nums.length;
		if (len % 2 == 0) {//if even
			System.out.println(((double) nums[len/2]+nums[(len/2)-1])/2);
		}else {
			System.out.println(nums[len/2]);
		}
		
		
		
	}
	
	public static void printArray(int[] array) {
		for (int n : array) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
}
