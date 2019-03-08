public class noTriple{
	public static boolean noTriple(int[] nums)
	{
		if (nums.length == 0) return false;
		else
		{
			int count = 0;
			int current = nums[0];
			if (nums.contains(current)) 
			{
				for (int n: nums)
				{
					if (n == current) count++;
				}		
			}	
		}	
	}
}

