import java.util.Arrays;

public class testMain {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(Divergence.charCount("xxxa")));
		System.out.println(Arrays.toString(Divergence.charCount("abbc")));
		
		System.out.println(Arrays.toString(Divergence.normalise(new int[] {2,1,1})));

		System.out.println(Arrays.toString(Divergence.normalise(Divergence.charCount("abbc"))));
		
		System.out.println(Divergence.kld(new double[] {0.75, 0.25}, new double[] {0.6, 0.4}));
		
		for (int[] arr:Divergence.charCountArray(new String[] {"cbbaaa","bbbccd"})) System.out.println(Arrays.toString(arr));
	}
}