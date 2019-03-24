package arraysAndStrings;

/**
 * Given binary array, find count of maximum number of consecutive 1’s present in the array.
 * Input  : arr[] = {1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1}
 * Output : 4
 *
 * Input  : arr[] = {0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1}
 * Output : 1
 *
 * An efficient solution is traverse array from left to right.
 * If we see a 1, we increment count and compare it with maximum so far. If we see a 0, we reset count as 0.
 *
 * Time Complexity : O(n)
 * Auxiliary Space : O(1)
 */

public class MaxConsecutive1sInBinaryArray {

        // Returns count of maximum consecutive 1's
        // in binary array arr[0..n-1]
        static int getMaxLength(boolean arr[], int n)
        {

            int count = 0; //intitialize count
            int result = 0; //initialize max

            for (int i = 0; i < n; i++)
            {

                // Reset count when 0 is found
                if (arr[i] == false)
                    count = 0;

                    // If 1 is found, increment count
                    // and update result if count becomes
                    // more.
                else
                {
                    count++;//increase count
                    result = Math.max(result, count);
                }
            }

            return result;
        }

        // Driver method
        public static void main(String[] args)
        {
            boolean arr[] = {true, true, false, false,
                    true, false, true, false,
                    true, true, true, true};

            int n = arr.length;

            System.out.println(getMaxLength(arr, n));
        }
}
