package arrays;

/**
 * Find the element that appears once in sorted array
 *
 * Given a sorted array A, size N, of integers; every element appears twice except for one.
 * Find that element in linear time complexity and without using extra memory.
 *
 * input 1 1 2 2 3 3 4 50 50 65 65
 * Output:
 * 4
 */
public class FindElementAppearOnce {

    public static void main(String args[]) {
        int arr[] = {1,1,2,2,3,3,4,50,50,65,65};

        search(arr, 0 , arr.length-1);
    }

    // A Binary Search based method to find the element
    // that appears only once

    /**
     * An Efficient Solution can find the required element in O(Log n) time.
     * The idea is to use Binary Search. Below is an observation in input array.
     * All elements before the required have first occurrence at even index (0, 2, ..)
     * and next occurrence at odd index (1, 3, …). And all elements after the required element have first occurrence at
     * odd index and next occurrence at even index.
     *
     * 1) Find the middle index, say ‘mid’.
     *
     * 2) If ‘mid’ is even, then compare arr[mid] and arr[mid + 1]. If both are same, then the required element after ‘mid’ else before mid.
     *
     * 3) If ‘mid’ is odd, then compare arr[mid] and arr[mid – 1]. If both are same, then the required element after ‘mid’ else before mid.
     *
     * Below is the implementation based on above idea.
     */
    public static void search(int[] arr, int low, int high)
    {
        if(low > high)
            return;
        if(low == high)
        {
            System.out.println("The required element is "+arr[low]);
            return;
        }

        // Find the middle point
        int mid = (low + high)/2;

        // If mid is even and element next to mid is
        // same as mid, then output element lies on
        // right side, else on left side
        if(mid % 2 == 0)
        {
            if(arr[mid] == arr[mid+1])
                search(arr, mid+2, high);
            else
                search(arr, low, mid);
        }
        // If mid is odd
        else if(mid % 2 == 1)
        {
            if(arr[mid] == arr[mid-1])
                search(arr, mid+1, high);
            else
                search(arr, low, mid-1);
        }
    }

    /**
     * linear approach O(n)
     * @param arr
     * @return
     */
    private static int findElement(int[] arr) {

        for (int i = 1; i < arr.length; i++){
            //first number
            if(i-1 == 0 && arr[i-1] != arr[i]){
                return arr[i-1];
            }

            if (arr[i]!= arr[i-1] && arr[i]!=arr[i+1]){
                return arr[i];
            }

            //last number
            if (i == arr.length-2 && arr[i]!= arr[i+1]){
                return arr[i+1];
            }
        }
        return -1;
    }


}
