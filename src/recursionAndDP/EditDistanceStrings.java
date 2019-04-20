package recursionAndDP;

/**
 * <a href="https://www.youtube.com/c/IDeserve">https://www.youtube.com/c/IDeserve</a>
 * Minimum edit distance between two strings using bottom-up dynamic programming algorithm in O(mn).
 *
 */
public class EditDistanceStrings {

        final static int ERROR_INPUT = -1;

        private int min(int a, int b)
        {
            return (a<b)?a:b;
        }

        private int min(int a, int b, int c)
        {
            return min(min(a,b),c);
        }

    /**
     * Complexity is O(2n)
     * @param str1
     * @param str2
     * @param m
     * @param n
     * @return
     */
        public int findDistance(String str1, String str2, int m, int n)
        {
            // if either of the strings is null, distance cannot be computed
            if (str1 == null || str2 == null)
            {
                return ERROR_INPUT;
            }

            // if str1 is an empty string, then insert all 'n' characters of str2 into str1
            if (m == 0)
            {
                return n;
            }

            // if str2 is an empty string, then remove all 'm' characters of str1
            if (n == 0)
            {
                return m;
            }

            /*
             * if last characters of str1 and str2 are equal
             * then we need to calculate distance for strings ending at second last index
             * for both str1 and str2
             */
            if (str1.charAt(m-1) == str2.charAt(n-1))
            {
                return findDistance(str1, str2, m-1, n-1);
            }

            /*
             * return minimum of following three cases:
             * delete last character of str1 and check distance: 1 + distance(str1, str2, m-1, n)
             * insert last character of str2 into str1 and check distance: 1 + distance(str1, str2, m, n-1)
             * replace last char of str1 with last char of str2 and check distance: 1 + distance(str1, str2, m-1, n-1)
             */
            return min (
                    1 + findDistance(str1, str2, m-1, n),
                    1 + findDistance(str1, str2, m, n-1),
                    1 + findDistance(str1, str2, m-1, n-1)
            );
        }


    /**
     * Complexity O(n*n)
     * @param str1
     * @param str2
     * @return
     */
        public int findDistance(String str1, String str2)
        {
            // if either of the strings is null, distance cannot be computed
            if (str1 == null || str2 == null)
            {
                return ERROR_INPUT;
            }

            // all values are by default initialized to 0 by JVM
            int[][] distanceTable = new int[str1.length()+1][str2.length()+1];

            int numRows = str1.length() + 1;
            int numCols = str2.length() + 1;

            for (int m = 0; m < numRows; m++)
            {
                for (int  n = 0; n < numCols; n++)
                {
                    // if length of str1 is 0, we have no option but to insert all of str2
                    if (m == 0)
                    {
                        distanceTable[m][n] = n;
                    }

                    // if length of str2 is 0, delete all of str1 to make it match with str2
                    else if (n == 0)
                    {
                        distanceTable[m][n] = m;
                    }

                    /*
                     *  if last characters of str1 and str2 are equal, compute distance ending at
                     *  second last characters for both str1 and str2
                     */
                    else if (str1.charAt(m-1) == str2.charAt(n-1))
                    {
                        distanceTable[m][n] = distanceTable[m-1][n-1];
                    }

                    /*
                     * else use minimum of following three cases:
                     * delete last character of str1 and check distance: distance(str1, str2, m-1, n)
                     * insert last character of str2 into str1 and check distance: distance(str1, str2, m, n-1)
                     * replace last char of str1 with last char of str2 and check distance: distance(str1, str2, m-1, n-1)
                     */
                    else
                    {
                        distanceTable[m][n] = min (
                                1 + distanceTable[m-1][n], //delete
                                1 + distanceTable[m][n-1], //insert
                                1 + distanceTable[m-1][n-1]  //replace
                        );
                    }
                }
            }

            return distanceTable[numRows-1][numCols-1];
        }


        public static void main(String[] args)
        {
            EditDistanceStrings solution = new EditDistanceStrings();

            System.out.print("minimum edit distance between \"intention\" and \"execution\" is: \n");
            System.out.println(solution.findDistance("intention", "execution"));
        }
}
