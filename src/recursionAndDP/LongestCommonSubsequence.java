package recursionAndDP;

public class LongestCommonSubsequence {

    public static void main(String args[]){

        String s1 = "avcde";
        String s2 ="abcde";
        int result =  findLongestSubsequenceRecursive(s1.toCharArray(), s2.toCharArray(), 0,0);
        System.out.println(result);
    }


    public static int findLongestSubsequenceRecursive(char small[], char big[], int i, int j){

        if(i >= small.length || j >= big.length){
            return 0;
        }

        //if matches
        if(small[i] == big[j]){
            i++;
            j++;

            return 1 + findLongestSubsequenceRecursive(small, big, i, j);
        }

        return Math.max(findLongestSubsequenceRecursive(small, big, i+1, j),
                findLongestSubsequenceRecursive(small, big, i, j+1));
    }


    /* Returns length of LCS for X[0..m-1], Y[0..n-1] */
    int lcsDP( char[] X, char[] Y, int m, int n )
    {
        int L[][] = new int[m+1][n+1];

    /* Following steps build L[m+1][n+1] in bottom up fashion. Note
         that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
        for (int i=0; i<=m; i++)
        {
            for (int j=0; j<=n; j++)
            {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X[i-1] == Y[j-1])
                    L[i][j] = L[i-1][j-1] + 1;
                else
                    L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
            }
        }
        return L[m][n];
    }
}
