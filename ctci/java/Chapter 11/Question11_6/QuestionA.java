package Question11_6;
import CtCILibrary.*;

/**
 * 给定一个M*N矩阵，每一行，每一列都按升序排列，请编写代码找出某元素
 * 解法一：排除掉灰色区域
 */
public class QuestionA {

	public static boolean findElement(int[][] matrix, int elem) {
		int row = 0;
		// 从右上角开始排除
		int col = matrix[0].length - 1; 
		while (row < matrix.length && col >= 0) {
			if (matrix[row][col] == elem) {
				return true;
			} else if (matrix[row][col] > elem) {
				col--;
			} else {
				row++; 
			}
		} 
		return false; 
	}
	
	public static void main(String[] args) {
		int M = 10;
		int N = 5;
		int[][] matrix = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = 10 * i + j;
			}
		}
		
		AssortedMethods.printMatrix(matrix);
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				int v = 10 * i + j;
				System.out.println(v + ": " + findElement(matrix, v));
			}
		}
		
	}

}
