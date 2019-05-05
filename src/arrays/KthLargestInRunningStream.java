package arrays;

import java.util.PriorityQueue;
import java.util.Queue;


/**
 * K’th largest element in a stream
 * Given an infinite stream of integers, find the k’th largest element at any point of time.
 *
 * Input:
 * stream[] = {10, 20, 11, 70, 50, 40, 100, 5, ...}
 * k = 3
 * Output:    {_,   _, 10, 11, 20, 40, 50,  50, ...}
 */
public class KthLargestInRunningStream {


    public static void main(String args[]) {
            int arr[] = {10, 20, 11, 70, 50, 40, 100, 5}    ;
            findKthLargestRunningStream(arr, 3);
    }


    public static void findKthLargestRunningStream(int arr[], int k){

        Queue<Integer> minHeap = new PriorityQueue<>();

        int i=0;

        for (; i < k ; i++){
            minHeap.add(arr[i]);
        }
        System.out.println(minHeap.peek());
        for (; i < arr.length ; i++){
            if(arr[i] >= minHeap.peek()) {
                minHeap.poll();
                minHeap.add(arr[i]);
            }
            System.out.println(minHeap.peek());
        }
    }
}
