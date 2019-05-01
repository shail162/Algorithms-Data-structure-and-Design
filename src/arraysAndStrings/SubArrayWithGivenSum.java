package arraysAndStrings;

import java.util.HashMap;

/**
 * Subarray with given sum
 * Given an unsorted array A of size N of non-negative integers, find a continuous sub-array which adds to a given number S.
 *
 * sum= 12
 * array = 1 2 3 7 5
 *
 * output: index [1,3]
 *
 * sum= 15
 * 1 2 3 4 5 6 7 8 9 10
 * output= index [0,4]
 */
public class SubArrayWithGivenSum {

    public static void main(String args[]) {

        int arr[] = {10, 2, -2, -20, 10};

        subArraySum(arr, arr.length, -10);
    }

    /**
     * only for +ve numbers
     *
     * @param arr
     * @param target
     */
    public static void findSubArray(int arr[], int target) {

        int sum = 0;
        int j = 0;

        for (int i = 0; i < arr.length; ) {

            sum = sum + arr[i];

            if (sum == target) {
                System.out.println(j + "," + i);
                return;
            }

            if (sum > target) {
                sum = sum - arr[j] - arr[i];
                j++;
            } else {
                i++;
            }

        }
    }


    /**
     * -ve number case
     * Input: arr[] = {10, 2, -2, -20, 10}, sum = -10
     */
    public static void subArraySum(int[] arr, int n, int sum) {
        //cur_sum to keep track of cummulative sum till that point
        int cur_sum = 0;
        int start = 0;
        int end = -1;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            cur_sum = cur_sum + arr[i];
            //check whether cur_sum - sum = 0, if 0 it means
            //the sub array is starting from index 0- so stop
            if (cur_sum - sum == 0) {
                start = 0;
                end = i;
                break;
            }
            //if hashMap already has the value, means we already
            // have subarray with the sum - so stop
            if (hashMap.containsKey(cur_sum - sum)) {
                start = hashMap.get(cur_sum - sum) + 1;
                end = i;
                break;
            }
            //if value is not present then add to hashmap
            hashMap.put(cur_sum, i);

        }
        // if end is -1 : means we have reached end without the sum
        if (end == -1) {
            System.out.println("No subarray with given sum exists");
        } else {
            System.out.println("Sum found between indexes "
                    + start + " to " + end);
        }


    }
}
