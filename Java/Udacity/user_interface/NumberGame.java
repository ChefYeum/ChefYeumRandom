import java.util.Scanner;

public class NumberGame{
	public static void main(String[] args){
		System.out.printf("A random number between 1 and 100 has been generated.\nTry to guess it within 10 attempts.");
		int answer = (int) (Math.random()*100) +1;
		Scanner scanner = new Scanner(System.in);
		for (int attempt = 10; attempt > 0; attempt--){
			System.out.printf("You have %d attempts: ", attempt);
			int userinput = scanner.nextInt();
			if (userinput == answer){
				System.out.println("Correct");
				break;	
			} else if (userinput < answer){
				System.out.print("Your guess is smaller.");
			} else{
				System.out.print("Your guess is bigger.");	
			}
			System.out.println("Please try again. ");
		}
	}

} 
