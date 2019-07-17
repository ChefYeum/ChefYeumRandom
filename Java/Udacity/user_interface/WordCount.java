import java.util.Scanner;
import java.io.File;


public class WordCount{

	public static void main(String[] args) throws Exception{
		File file = new File("file.txt");
		Scanner scanner = new Scanner(file);	
		int words = 0;
		while (scanner.hasNextLine()){
			String line = scanner.nextLine();
			words += (line.split(" ").length);
		}
		System.out.println(words)
	}	

} 
