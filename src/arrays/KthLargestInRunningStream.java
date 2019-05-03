package arrays;

import java.util.PriorityQueue;
import java.util.Queue;


/**
 * Input:
 * stream[] = {10, 20, 11, 70, 50, 40, 100, 5, ...}
 * k = 3
 * Output:    {_,   _, 10, 11, 20, 40, 50,  50, ...}
 */
public class KthLargestInRunningStream {


    public static void main(String args[]) {
            int arr[] = {23,10,15,70,5,80,100}    ;
            findKthLargestRunningStream(arr, 3);
    }


    public static void findKthLargestRunningStream(int arr[], int k){

        Queue<Integer> minHeap = new PriorityQueue<>();

        int i=0;
        for (; i < k ; i++){
            minHeap.add(arr[i]);
        }

        for (; i < arr.length ; i++){
            System.out.println(minHeap.poll());

            minHeap.add(arr[i]);
        }
    }
}
