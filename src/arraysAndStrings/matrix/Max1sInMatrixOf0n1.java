package arraysAndStrings.matrix;

import library.AssortedMethods;

/**
 * Given a matrix where 0s will always come first than 1s.
 * Write an algorithm to find max number of 1s in a row.
 *
 * Complexity O(m+n)
 *
 * If applying binary search on each row then complexity is O(mlong)
 */
public class Max1sInMatrixOf0n1 {

    // The main function that returns index of row with maximum number of 1s.
    static int rowWithMax1s(int mat[][])
    {
        // Initialize first row as row with max 1s
        int max_row_index = 0;
        int R = mat.length;
        int C = mat[0].length;

        // The function first() returns index of first 1 in row 0.
        // Use this index to initialize the index of leftmost 1 seen so far
//        int j = first(mat[0], 0, C-1);
//        if (j == -1) // if 1 is not present in first row
//            j = C - 1;
        int j = C -1;

        for (int i = 0; i < R; i++)
        {
            // Move left until a 0 is found
            while (j >= 0 && mat[i][j] == 1)
            {
                j = j-1;  // Update the index of leftmost 1 seen so far
                max_row_index = i;  // Update max_row_index
            }
        }
        return max_row_index;
    }

    public static void main(String args[]) {
        int M = 4;
        int N = 4;
        int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {

                if(i>=2){
                    matrix[j][i] = 1;
                } else {
                    matrix[j][i] = 0;
                }
            }
        }

        matrix[3][1]= 0;
        matrix[2][2] = 1;
        matrix[2][1]= 1;

        AssortedMethods.printMatrix(matrix);

        System.out.println(rowWithMax1s(matrix));
    }
}
