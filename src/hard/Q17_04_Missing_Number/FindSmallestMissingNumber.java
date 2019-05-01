package hard.Q17_04_Missing_Number;

/**
 * Find the smallest missing number
 * Given a sorted array of n distinct integers where each integer is in the range from 0 to m-1 and m > n.
 * Find the smallest number that is missing from the array.
 *
 * Examples
 * Input: {0, 1, 2, 6, 9}, n = 5, m = 10
 * Output: 3
 *
 * Input: {4, 5, 10, 11}, n = 4, m = 12
 * Output: 0
 *
 * Input: {0, 1, 2, 3}, n = 4, m = 5
 * Output: 4
 *
 * Input: {0, 1, 2, 3, 4, 5, 6, 7, 10}, n = 9, m = 11
 * Output: 8
 *
 */
public class FindSmallestMissingNumber {


    /** Approach 1
     *If arr[0] is not 0, return 0. Otherwise traverse the input array starting from index 0,
     *  and for each pair of elements a[i] and a[i+1], find the difference between them.
     *  if the difference is greater than 1 then a[i]+1 is the missing number.
     *
     * Time Complexity: O(n)
     */


    /**
     * O(logn)
     * @param array
     * @param start
     * @param end
     * @return
     */
    int findFirstMissing(int array[], int start, int end)
    {
        if (start > end)
            return end + 1;

        if (start != array[start])
            return start;

        int mid = (start + end) / 2;

        // Left half has all elements from 0 to mid
        if (array[mid] == mid)
            return findFirstMissing(array, mid+1, end);

        return findFirstMissing(array, start, mid);
    }

    // Driver program to test the above function
    public static void main(String[] args)
    {
        FindSmallestMissingNumber small = new FindSmallestMissingNumber();
        int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 10};
        int n = arr.length;
        System.out.println("First Missing element is : "
                + small.findFirstMissing(arr, 0, n - 1));
    }
}
