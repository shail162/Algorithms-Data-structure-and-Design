package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElement {

    public static void main(String args[]) {
        Integer arr[] = {3,2,1,5,6,4};
        System.out.println(findKthLargest(arr, 1));

        System.out.println(findKthLargestMaxHeap(arr, 1));

    }

    /**
     * Complexity is O(nlogn)
     * @param arr
     * @param k
     * @return
     */
    public static int findKthLargest(Integer arr[], int k){

        if(k > arr.length || k <= 0 ){
            return -1;
        }
        Arrays.sort(arr, Collections.reverseOrder());
        return arr[k-1];
    }

    /**
     * O(n + klogn)
     * @param arr
     * @param k
     * @return
     */
    public static int findKthLargestMaxHeap(Integer arr[], int k){

        if(k > arr.length || k <= 0 ){
            return -1;
        }

        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Arrays.stream(arr).forEach(i->maxHeap.add(i));

        for (int i =0; i< k -1 ;i++){
            maxHeap.poll();
        }

        return maxHeap.peek();
    }

}
