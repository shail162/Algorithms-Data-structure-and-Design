package recursionAndDP;

import library.AssortedMethods;

/**
 * Find max path sum in a given matrix, start and end position in a matrix can be anywhere.
 *
 * Expected time complexity O(mxn)
 */
public class FindMaxPathSumInMatrix {

    public static void main(String arsg[]) {
        int[][] matrix = AssortedMethods.randomMatrix(3, 3, -3, 7);
        AssortedMethods.printMatrix(matrix);
        System.out.println();
        System.out.println("maxSum :: " + maxPathSum(matrix));
    }


    public static int maxPathSum(int mat[][]){
        int res[][]= new int[mat.length][mat[0].length];
        int row  = mat.length;
        int col = mat[0].length;
        int maxSum = Integer.MIN_VALUE;

        /**
         * Populate 1st row and 1st col in res matrix
         */
        int rSum = 0 ;
        for (int i = 0; i < row; i++){
            if(rSum >= 0){
                rSum += mat[0][i] ;
                res[0][i] = rSum;
            } else {
                res[0][i] = mat[0][i];
                rSum = res[0][i];
            }
            maxSum = Math.max(res[0][i], maxSum);
        }

        int cSum= 0;

        for (int j = 0; j < col ; j++){
            if(cSum >= 0) {
                cSum+= mat[j][0];
                res[j][0] = cSum;
            } else {
                res[j][0] = mat[j][0];
                cSum = res[j][0];
            }
            maxSum = Math.max(res[j][0], maxSum);
        }


        for (int i = 1; i < row ; i++){
            for (int j = 1; j < col; j++){
                if((res[i][j-1] >= 0 || res[i-1][j] >= 0 )){
                    res[i][j] = mat[i][j] + Math.max(res[i][j-1], res[i-1][j]);
                } else {
                    res[i][j] = mat[i][j];
                }

                maxSum = Math.max(res[i][j], maxSum);

            }
        }

        AssortedMethods.printMatrix(res);

        return maxSum;
    }


}
