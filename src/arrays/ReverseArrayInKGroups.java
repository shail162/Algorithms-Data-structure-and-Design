package arrays;

import java.util.Arrays;

/**
 * Reverse an array in groups of given size
 * Given an array, reverse every sub-array formed by consecutive k elements.
 *
 *
 * Input:
 * arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
 * k = 3
 * Output:
 * [3, 2, 1, 6, 5, 4, 9, 8, 7]
 *
 * Input:
 * arr = [1, 2, 3, 4, 5, 6]
 * k = 1
 * Output:
 * [1, 2, 3, 4, 5, 6]
 *
 * Input:
 * arr = [1, 2, 3, 4, 5, 6, 7, 8]
 * k = 10
 * Output:
 * [8, 7, 6, 5, 4, 3, 2, 1]
 */
public class ReverseArrayInKGroups {

    public static void main(String args[]){

        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 3;

        reverseArrayKGroup(arr, k);
        Arrays.stream(arr).forEach(element-> System.out.print(element + " " ));
    }

    public static void reverseArrayKGroup(int arr[], int k){

        //Edge case: If k is greater than array length then reverse entire array
        if (k > arr.length){
            k = arr.length;
        }

        for (int i = 0; i+k <= arr.length; i+=k){
            reverse(i, i+k-1, arr);
        }
    }

    private static void reverse(int start, int end, int[] arr) {

        for (; start <= end ; start++, end--){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end]= temp;
        }
    }
}
