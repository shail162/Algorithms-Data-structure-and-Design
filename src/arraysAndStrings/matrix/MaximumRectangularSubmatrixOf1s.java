package arraysAndStrings.matrix;


import hard.MaxHistogramRectangle;

/**
 **
 * Given a 2D matrix of 0s and 1s. Find largest rectangle of all 1s
 * in this matrix.
 *
 Step 1: Find maximum area for row[0]
 Step 2:
 for each row in 1 to N - 1
 for each column in that row
 if A[row][column] == 1
 update A[row][column] with
 A[row][column] += A[row - 1][column]
 find area for that row
 and update maximum area so far
 *
 * Time complexity - O(rows*cols)
 * Space complexity - O(cols) - if number of cols is way higher than rows
 * then do this process for rows and not columns.
 *
 * References:
 * https://www.geeksforgeeks.org/maximum-size-rectangle-binary-sub-matrix-1s/
 */
public class MaximumRectangularSubmatrixOf1s {

    public int maximum(int input[][]){
        int maxArea = Integer.MIN_VALUE;
        MaxHistogramRectangle mh = new MaxHistogramRectangle();

        int area = 0;
        for(int i=1; i < input.length; i++){
            for(int j = 0; j < input[0].length ; j++){
                if(input[i][j] == 1)
                    input[i][j] += input[i-1][j];
            }
            area = mh.maxHistogram(input[i]);
            maxArea = Math.max(area,maxArea);
        }
        return maxArea;
    }

    public static void main(String args[]){
        int input[][] = {
                            {0,1,1,1},
                            {0,1,1,1},
                            {0,1,1,0},
                            {0,1,1,1},
                            {1,0,0,1},
                            {1,1,1,1}
                        };
        MaximumRectangularSubmatrixOf1s mrs = new MaximumRectangularSubmatrixOf1s();
        int maxRectangle = mrs.maximum(input);
        System.out.println("Max rectangle is of size " + maxRectangle);
        assert maxRectangle == 8 ;

    }
}

