package hard.Q17_20_Continuous_Median;

import java.util.PriorityQueue;

/**
 * https://www.youtube.com/watch?v=VmogG01IjYc
 */
public class ContinuousMedian2 {

    public static void addNewNumber(int randomNumber, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){
        if(lowers.size() ==0 || randomNumber < lowers.peek()){
            lowers.add(randomNumber);
        } else {
            highers.add(randomNumber);
        }
    }


    public static void rebalanced(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){

        PriorityQueue<Integer> biggerHeap  = highers.size() > lowers.size() ? highers : lowers;
        PriorityQueue<Integer> smallerHeap =  highers.size() > lowers.size() ? lowers : highers;

        if (biggerHeap.size() - smallerHeap.size() >= 2 ){
            smallerHeap.add(biggerHeap.poll());
        }
    }

    public static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){
        PriorityQueue<Integer> biggerHeap  = highers.size() > lowers.size() ? highers : lowers;
        PriorityQueue<Integer> smallerHeap =  highers.size() > lowers.size() ? lowers : highers;

        if (biggerHeap.size() == smallerHeap.size() ){
            return ((double)biggerHeap.peek() + (double)smallerHeap.peek())/2;
        } else {
            return biggerHeap.peek();
        }
    }


    public static void main(String args[]) {
        int arraySize = 10;
        int range = 7;
        int arr[] = {100,50,80,150,40,60,75};

        MaxHeapComparator maxHeapComparator = new MaxHeapComparator();
        MinHeapComparator minHeapComparator = new MinHeapComparator();
        PriorityQueue maxHeap = new PriorityQueue<Integer>(maxHeapComparator);
        PriorityQueue minHeap = new PriorityQueue<Integer>();

        for(int i = 0; i < arr.length; i++) {
            int randomNumber = arr[i];
            addNewNumber(randomNumber, maxHeap, minHeap);
            rebalanced(maxHeap,minHeap);
            double median = getMedian(maxHeap, minHeap);
            System.out.println("Median "  + median);
        }
    }
}
