package week2;

public class LargestDouble{
	public static void main(String[] doubleStr) {
		double max = Double.parseDouble(doubleStr[0]);
		for (int i = 1; i < doubleStr.length; i++) {
			double currentNum = Double.parseDouble(doubleStr[i]);
			if (max < currentNum) {
				max = currentNum;
			}
		}
		System.out.println(max);
	}
}