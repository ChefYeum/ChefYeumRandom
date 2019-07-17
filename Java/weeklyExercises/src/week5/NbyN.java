
import java.util.Arrays;

public class NbyN
{
	public static int[][] nbyn(int N){
		int[][] outputMatrix = new int[N][N];
		for (int r = 0; r < N; r++){
			outputMatrix[r][r] = r;
		}
		return outputMatrix;
	}
	public static void main(String[] args){
		int[][] matrix = nbyn(10);
		for (int[] row:matrix){
			for (int n:row){
				System.out.print(n+" ");
			}
			System.out.println();
		}
	}
}
