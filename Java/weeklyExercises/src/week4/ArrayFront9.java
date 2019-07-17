package week4;


class ArrayFront9{
	public static boolean arrayFront9(int[] nums){
		for (int i = 0; (i < nums.length && i < 4); i++) {
			if (nums[i] == 9) return true;
		}
		return false;
	}
	public static void main(String[] args){
		int N = args.length;
		int[] nums = new int[N];
		for (int n = 0; n < N; n++){
			nums[n] = Integer.parseInt(args[n]);
		}
		System.out.println(arrayFront9(nums));
	}	
}
