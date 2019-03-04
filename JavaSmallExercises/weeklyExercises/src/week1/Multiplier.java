package week1;
public class Multiplier{
	public static void main(String[] args){
		int product = 1;
		for (int i = 0; i < args.length;i++){
			product *= Integer.parseInt(args[i]);
		}
		System.out.println(product);
	}
}
