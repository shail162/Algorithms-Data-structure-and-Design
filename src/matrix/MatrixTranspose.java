package matrix;

public class MatrixTranspose {



    /**
     * This method will transpose this matrix * * @return
     */
    public static int[][] transpose(int mat1[][]) {
        int rows = mat1[0].length;
        int columns = mat1.length ;

        int[][] temp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                temp[j][i] = mat1[i][j];
            }
        }

        return temp;
    }


    public static void main (String[] args)
    {
        int mat1[][] = { {1, 1, 1, 1},
                {2, 2, 2, 2},
                {3, 3, 3, 3},
                {4, 4, 4, 4}};

        int[][] result = transpose(mat1);

        System.out.println("Result matrix"
                + " is ");
        for (int i = 0; i < result.length; i++)
        {
            for (int j = 0; j < result[0].length; j++)
                System.out.print( result[i][j]
                        + " ");
            System.out.println();
        }
    }
}

