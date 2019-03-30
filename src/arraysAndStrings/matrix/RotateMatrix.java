package arraysAndStrings.matrix;
import library.AssortedMethods;

/**
 * Rotate a matrix
 *
 * input
 *     3    9    5
 *     5    4    8
 *     1    9    2
 *
 *     First iteration:
 *     top = 3
 *     3 -> 1
 *     1 -> 2
 *     2 -> 5
 *     5 -> 3
 *     Second iteration:
 *     top = 9
 *     9 -> 5
 *     5 -> 9
 *     9 -> 8
 *     8 -> 9
 *
 *
 * output
 *     1    5    3
 *     9    4    9
 *     2    8    5
 *
 *
 */
public class RotateMatrix {

	public static boolean rotate(int[][] matrix) {
		if (matrix.length == 0 || matrix.length != matrix[0].length) return false; // Not a square
		int n = matrix.length;
		
		for (int layer = 0; layer < n / 2; layer++) {
			int first = layer;
			int last = n - layer - 1;
			for(int i = first; i < last; i++) {
				int offset = i - first;
				int top = matrix[first][i]; //save top

				//left -> top
				matrix[first][i] = matrix[last-offset][first]; 			

				//bottom -> left
				matrix[last-offset][first] = matrix[last][last - offset]; 

				//right -> bottom
				matrix[last][last - offset] = matrix[i][last]; 

				//top -> right
				matrix[i][last] = top; // right <- saved top
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[][] matrix = AssortedMethods.randomMatrix(3, 3, 0, 9);
		AssortedMethods.printMatrix(matrix);
		rotate(matrix);
		System.out.println();
		AssortedMethods.printMatrix(matrix);
	}

}
