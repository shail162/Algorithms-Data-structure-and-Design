package arraysAndStrings;

import java.util.Arrays;

/**
 * Noble integers in an array (count of greater elements is equal to value)
 * Given an array arr[], find a Noble integer in it.
 * An integer x is said to be Noble in arr[] if the number of integers greater than x are equal to x.
 * If there are many Noble integers, return any of them. If there is no, then return -1.
 *
 * Examples :
 *
 * Input  : [7, 3, 16, 10]
 * Output : 3
 * Number of integers greater than 3
 * is three.
 *
 * Input  : [-1, -9, -2, -78, 0]
 * Output : 0
 * Number of integers greater than 0
 * is zero.
 */
public class NobleInteger {

    // Returns a Noble integer if present,
    // else returns -1.
    public static int nobleInteger(int arr[])
    {
        Arrays.sort(arr);

        // Return a Noble element if present
        // before last.
        int n = arr.length;
        for (int i=0; i<n-1; i++)
        {
            if (arr[i] == arr[i+1])
                continue;

            // In case of duplicates, we
            // reach last occurrence here.
            if (arr[i] == n-i-1)
                return arr[i];
        }

        if (arr[n-1] == 0)
            return arr[n-1];

        return -1;
    }

    // Driver code
    public static void main(String args[])
    {
        int [] arr = {10, 3, 20, 40, 2};
        int res = nobleInteger(arr);
        if (res != -1)
            System.out.println("The noble integer is "+ res);
        else
            System.out.println("No Noble Integer Found");
    }
}
