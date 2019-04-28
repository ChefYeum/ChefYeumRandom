import java.util.Arrays;

public class testMain {
//	public static void main(String[] args) {
//		System.out.println(Arrays.toString(Divergence.charCount("xxxa")));
//		System.out.println(Arrays.toString(Divergence.charCount("abbc")));
//		
//		System.out.println(Arrays.toString(Divergence.normalise(new int[] {2,1,1})));
//
//		System.out.println(Arrays.toString(Divergence.normalise(Divergence.charCount("abbc"))));
//		
//		System.out.println(Divergence.kld(new double[] {0.75, 0.25}, new double[] {0.6, 0.4}));
//		
//		for (int[] arr:Divergence.charCountArray(new String[] {"cbbaaa","bbbccd"})) System.out.println(Arrays.toString(arr));
//	}
	public static void main(String[] args) {
		SnowSquirrelBrowser r1 = new SnowSquirrelBrowser("Hello", 10.0, "V1");
		Plugin a1 = new Plugin("Camera",1.0,"V1");
		boolean b = r1.installPlugin(a1);
		
		
		System.out.println(b);
	}
}