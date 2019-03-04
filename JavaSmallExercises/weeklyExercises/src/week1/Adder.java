package week1;
public class Adder{
	public static void main(String[] a){
		int sum = 0;		
		for(int i = 0; i < a.length; i++){
			sum += Integer.parseInt(a[i]);
		}
		System.out.println(sum);
	}
}
