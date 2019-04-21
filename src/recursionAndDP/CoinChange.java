package recursionAndDP;

import java.util.Arrays;

/**
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins,
 * how many ways can we make the change? The order of coins doesn’t matter.
 *
 * For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}.
 * So output should be 4. For N = 10 and S = {2, 5, 3, 6},
 * there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.
 */
public class CoinChange {
        static long countWays(int S[], int mCoins, int n)
        {
            //Time complexity of this function: O(mn)
            //Space Complexity of this function: O(n)

            // table[i] will be storing the number of solutions
            // for value i. We need n+1 rows as the table is
            // constructed in bottom up manner using the base
            // case (n = 0)
            long[] table = new long[n+1];

            // Initialize all table values as 0
            Arrays.fill(table, 0);   //O(n)

            // Base case (If given value is 0)
            table[0] = 1;

            // Pick all coins one by one and update the table[]
            // values after the index greater than or equal to
            // the value of the picked coin
            for (int i=0; i<mCoins; i++)
                for (int j=S[i]; j<=n; j++)
                    table[j] += table[j-S[i]];

            return table[n];
        }

        // Driver Function to test above function
        public static void main(String args[])
        {
            int arr[] = {1, 2, 3};
            int coins = arr.length;
            int n = 4;
            System.out.println(countWays(arr, coins, n));
        }


    public int change(int amount, int[] coins) {

  /*
    Each row represents using the denominations up to that point in
    the denominations array (see the video explanation)
  */
        int[][] dp = new int[coins.length + 1][amount + 1];

  /*
    Max ways to make change for 0 will be 1, doing nothing.
  */
        dp[0][0] = 1;

        for (int i = 1; i <= coins.length; i++) {

    /*
      Set the subproblem for the amount of 0 to 1 when
      solving this row
    */
            dp[i][0] = 1;

            for (int j = 1; j <= amount; j++) {

                int currentCoinValue = coins[i - 1];

      /*
        dp[i][j] will be the sum of the ways to make change not considering
        this coin (dp[i-1][j]) and the ways to make change considering this
        coin (dp[i][j] - currentCoinValue] ONLY if currentCoinValue <= j, otherwise
        this coin can not contribute to the total # of ways to make change at this
        sub problem target amount)
      */
                int withoutThisCoin = dp[i - 1][j];
                int withThisCoin = currentCoinValue <= j ? dp[i][j - currentCoinValue] : 0;

                dp[i][j] = withoutThisCoin + withThisCoin;
            }
        }

  /*
    The answer considering ALL coins for the FULL amount is what
    we want to return as the answer
  */
        return dp[coins.length][amount];
    }

}
