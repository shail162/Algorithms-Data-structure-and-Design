package bitManipulation;

/**
 * Highest power of 2 less than or equal to given number
 * Given a number n, find the highest power of 2 that is smaller than or equal to n.
 *
 * Examples :
 *
 * Input : n = 10
 * Output : 8
 *
 * Input : n = 19
 * Output : 16
 *
 * Input : n = 32
 * Output : 32
 */
public class HighestPowerOf2 {
    static int highestPowerof2(int n)
    {
        int res = 0;
        for (int i = n; i >= 1; i--)
        {
            // If i is a power of 2
            if ((i & (i - 1)) == 0)
            {
                res = i;
                break;
            }
        }
        return res;
    }

    // Driver code
    public static void main(String[] args)
    {
        int n = 10;
        System.out.println(highestPowerof2(n));
    }
}

