package arraysAndStrings;

import java.util.Arrays;

/**
 * Find a triplet that sum to a given value
 * Given an array and a value, find if there is a triplet in array whose sum is equal to the given value.
 * If there is such a triplet present in array, then print the triplet and return true. Else return false.
 * For example, if the given array is {12, 3, 4, 1, 6, 9} and given sum is 24,
 * then there is a triplet (12, 3 and 9) present in array whose sum is 24.
 */
public class TripletSum {

    public static void main(String args[]) {
        int arr[] = {12, 3, 4, 1, 6, 9};
        int sum = 24;

        boolean result = find3Numbers(arr, arr.length, sum);

        System.out.println(result);

    }


    static boolean find3Numbers(int A[], int arr_size, int sum)
    {
        int l, r;

        /* Sort the elements */
        Arrays.sort(A, 0, arr_size - 1);

        /* Now fix the first element one by one and find the
           other two elements */
        for (int i = 0; i < arr_size - 2; i++) {

            // To find the other two elements, start two index variables
            // from two corners of the array and move them toward each
            // other
            l = i + 1; // index of the first element in the remaining elements
            r = arr_size - 1; // index of the last element
            while (l < r) {
                if (A[i] + A[l] + A[r] == sum) {
                    System.out.print("Triplet is " + A[i] + ", " + A[l] + ", " + A[r]);
                    return true;
                }
                else if (A[i] + A[l] + A[r] < sum)
                    l++;

                else // A[i] + A[l] + A[r] > sum
                    r--;
            }
        }

        // If we reach here, then no triplet was found
        return false;
    }
}
