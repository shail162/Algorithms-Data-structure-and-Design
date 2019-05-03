package arrays;

import java.util.Arrays;

/**
 * Time Complexity is O(m+n)
 */

public class Merge2SortedArrays {

    public static void main(String args[]) {
            int arr1[]  = {1,3,5,7,190};
            int arr2[] = {2,4,6,8,10,12};


            int result[] = merge(arr1,arr2);
            Arrays.stream(result).forEach(i -> System.out.print(i + " "));
    }

    private static int[] merge(int[] arr1, int[] arr2) {

        int result[] = new int[arr1.length + arr2.length];

        int i = 0, j= 0, k =0;

        while (i < arr1.length && j < arr2.length) {

            if (arr1[i] < arr2[j]){
                result[k] = arr1[i];
                i++;
            } else {
                result[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < arr1.length){
            result[k] = arr1[i];
            i++;
            k++;
        }

        while (j < arr2.length){
            result[k] = arr2[j];
            j++;
            k++;
        }

        return result;
    }
}
