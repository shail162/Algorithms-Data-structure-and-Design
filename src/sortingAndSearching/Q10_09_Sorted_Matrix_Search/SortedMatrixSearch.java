package sortingAndSearching.Q10_09_Sorted_Matrix_Search;
import library.*;

/**
 * Given MXN matrix in which each row and each column is sorted in ascending order, write a method to find an element.
 * Complexity O(n)
 */
public class SortedMatrixSearch {

	public static boolean findElement(int[][] matrix, int elem) {
		int row = 0;
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
		int M = 4;
		int N = 4;
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
