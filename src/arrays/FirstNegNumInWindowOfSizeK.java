package arrays;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Input : arr[] = {-8, 2, 3, -6, 10}, k = 2
 * Output : -8 0 -6 -6
 * First negative integer for each window of size k
 * {-8, 2} = -8
 * {2, 3} = 0 (does not contain a negative integer)
 * {3, -6} = -6
 * {-6, 10} = -6
 *
 * Input : arr[] = {12, -1, -7, 8, -15, 30, 16, 28} , k = 3
 * Output : -1 -1 -7 -15 -15 0
 */
public class FirstNegNumInWindowOfSizeK {

    public static void main(String args[]){
        int arr[] = {12, -1, -7, 8, -15, 30, 16, 28} ;
        int k =3;

        int arr2[] ={-8, 2, 3, -6, 10};
        int k1 =2;

        //findFirstNegativeNumEachWindow(arr2, k1);

        findFirstNegativeOptimzed(arr, k);

    }


    /**
     * Brute force
     * @param arr
     * @param k
     *  O(nk)
     *
     * Time Complexity : The outer loop runs n-k+1 times and the inner loop runs k times for every iteration of outer loop.
     * So time complexity is O((n-k+1)*k) which can also be written as O(nk) when k is comparitively much smaller than n, otherwise when k tends to reach n, complexity becomes O(k).
     */
    public static void findFirstNegativeNumEachWindow(int arr[], int k){

        for (int i = 0; i <= arr.length - k ; i++){
            int j = 0;
            boolean found = Boolean.FALSE;
            while (j < k){
                if (arr[i+j] < 0) {
                    System.out.print(arr[i+j] + " ");
                    found = Boolean.TRUE;
                    break;
                }
                j++;
            }

            if(!found){
                System.out.print(0 + " ");
            }
        }
    }

    /**
     * Optimized
     *
     *  int arr[] = {12, -1, -7, 8, -15, 30, 16, 28} ;
     *         int k =3;
     *  Output : -1 -1 -7 -15 -15 0
     *
     *  Time Complexity: O(n)
     * Auxiliary Space: O(k)
     */

    public static void findFirstNegativeOptimzed(int arr[], int k){
        Deque<Integer> queue = new LinkedList<>();
        int i = 0;
        for ( ; i < k ; i++){
            if(arr[i] < 0){
                queue.add(i);
            }
        }

        for (; i <= arr.length  ; i++){

            if(!queue.isEmpty()) {
                System.out.print(arr[queue.peek()] + " ");
            }
            else {
                System.out.print("0 ");
            }

            //remove elements out of the window
            while(!queue.isEmpty() && queue.peek() <= (i-k)){
                queue.removeFirst();
            }

            if(i < arr.length-1 && arr[i] < 0)
             queue.addLast(i);

        }
    }
}
