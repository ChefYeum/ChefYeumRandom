
class ArrayFront9{
	public static boolean arrayFront9(int[] nums){
		for (int n : nums){
			if (n == 9) return true;
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
