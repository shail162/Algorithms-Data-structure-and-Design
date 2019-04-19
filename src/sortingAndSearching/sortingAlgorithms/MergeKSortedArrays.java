package sortingAndSearching.sortingAlgorithms;

import java.util.PriorityQueue;

/**
 * Min heap approach
 * O(k*nlogk)
 */
public class MergeKSortedArrays {

    public static void main(String args[]){

        int arr[][] = {
                            {1,8,9,14,17},
                            {6,10,19,40,50},
                            {4,5,11,15,20},
                            {2,3,7,12,16}
                           // {21,22,23,24,25}
                        };
        mergeKSortedArrays(arr);
    }


    public static void mergeKSortedArrays(int arr[][]){
        int row = arr.length, col = arr[0].length;
        int result[] = new int[row*col];

        PriorityQueue<Node> queue = new PriorityQueue<>();

        for (int i = 0 ; i < row; i++){
            queue.add(new Node(arr[i][0],i,0));
        }

        int k = 0;
        for (int i = 1 ; i < col; i++){
            for(int j = 0; j < row; j++){
                queue.add(new Node(arr[j][i], j,j));
                result[k++] = queue.poll().val;
            }
        }

        while(!queue.isEmpty()) {
            result[k++] = queue.poll().val;
        }

        printResult(result);

    }


    public static void printResult(int result[]){
        for (int val : result){
            System.out.print(val + " ");
        }
    }
}


class Node {

    int val;
    int arrayIndex;
    int valueIndex;


    public Node(int val, int arrayIndex, int valueIndex) {
        this.val = val;
        this.arrayIndex = arrayIndex;
        this.valueIndex = valueIndex;
    }


}
