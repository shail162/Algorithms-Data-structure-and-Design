package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * We want to make an array sorted in non-decreasing order by deleting exactly one item from it. How many ways can we do that ?
 *
 * For example, if the input array is [3, 4, 5, 4], the answer will 2, as we can delete either 5 or the second 4.
 *
 * If the array is [3, 4, 5, 2] the answer will be 1, as we can delete 2.
 *
 * If the array is [1, 2, 3, 4, 5] the answer will be 5, as we can delete any one of the elements.
 *
 */

public class NumberOfWaysToMakeSortByDeleting1Element {

    public static void main(String args[]) {
        int a[] = {3, 4, 5, 4};
        int res = solution2(a);
        System.out.println(res);
    }

    /**
     * efficient O(n)
     * @param arr
     * @return
     */
    public static int solution2(int arr[]){

        int count  = 0;

        for (int i = 1; i < arr.length ; i++){
            if(arr[i-1] > arr[i]){
                if(count != 0){
                    return 0;
                }
                if (i == 1 || arr[i-2] <= arr[i]) ++count;
                if (i == arr.length - 1 || arr[i-1] <= arr[i+1]) ++count;
                if (count == 0) return 0;
            }
        }
        return (count == 0) ? arr.length : count;
    }

    /**
     * Bruteforce approach O(n2)
     * @param a
     * @return
     */
    public static int solution(int a[]){
        List<Integer> list = new ArrayList<>();
        Arrays.stream(a).forEach(v ->list.add(v));
        int count = 0;
        for (int i = 0; i < a.length ; i++){
            list.remove(i);
            if (checkIfArrayIsSorted(list)) {
                count++;
            }
            list.add(i, a[i]);
        }
        return count;
    }

    private static boolean checkIfArrayIsSorted(List<Integer> list) {

        for (int i = 0 ; i < list.size() -1; i++ ){
            if (! (list.get(i) <= list.get(i+1) )){
                return false;
            }
        }
        return true;
    }
}
