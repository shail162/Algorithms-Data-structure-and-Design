package arraysAndStrings;

/**
 * Find the element before which all the elements are smaller than it, and after which all are greater
 * Given an array, find an element before which all elements are smaller than it,
 * and after which all are greater than it. Return index of the element if there is such an element, otherwise return -1.
 * Examples:
 *
 * Input:   arr[] = {5, 1, 4, 3, 6, 8, 10, 7, 9};
 * Output:  Index of element is 4
 * All elements on left of arr[4] are smaller than it
 * and all elements on right are greater.
 *
 * Input:   arr[] = {5, 1, 4, 4};
 * Output:  Index of element is -1
 * Expected time complexity is O(n).
 */
public class FindLeftSmallerAndRightGreater {

    static int findElement(int arr[], int n)
    {
        // leftMax[i] stores maximum of arr[0..i-1]
        int leftMax[] = new int[n];
        leftMax[0] = Integer.MIN_VALUE;

        // Fill leftMax[]1..n-1]
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], arr[i-1]);
        }


        // Initialize minimum from right
        int rightMin = Integer.MAX_VALUE;
        // Traverse array from right
        for (int i=n-1; i>=0; i--)
        {
            // Check if we found a required element
            if (leftMax[i] < arr[i] && rightMin > arr[i])
                return i;

            // Update right minimum
            rightMin = Math.min(rightMin, arr[i]);
        }

        // If there was no element matching criteria
        return -1;
    }

    public static void main(String args[]){
        int arr[] = {5, 1, 4, 3, 6, 8, 10, 7, 9};
        int result = findElement(arr, arr.length);
        System.out.println(result);

    }
}
