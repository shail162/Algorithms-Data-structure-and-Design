package linkedList;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Sort the linked list in the order of elements appearing in the array
 * Given an array of size N and a Linked List where elements will be from the array but can also be duplicated,
 * sort the linked list in the order, elements are appearing in the array.
 * It may be assumed that the array covers all elements of the linked list.
 *
 * arr[] = 5 1 3 2 8
 *
 * list = 3 2 5 8 5 2 1 X
 *
 * Sorted list = 5 5 1 3 2 2 8 X
 *
 * Time complexity O(n)
 */
public class SortLinkedListFromArrayOrder {

    public static void main(String args[]){
        int arr[] = {5,1,3,2,8};
        LinkedList<Integer> list = new LinkedList<>();
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(8);
        list.add(5);
        list.add(2);
        list.add(1);

        sortList(arr, list);
    }


    public static void sortList(int arr[], LinkedList<Integer> list){
        Map<Integer, Integer> freqMap = buildFreqTable(list);
        LinkedList<Integer> temp = new LinkedList<>();

        for (int value : arr){
            int freq = freqMap.get(value);
            while(freq > 0){
                freq--;
                temp.add(value);
            }
        }

        printList(temp);
    }

    private static void printList(LinkedList<Integer> temp) {
        for(Integer value : temp){
            System.out.print(value + " ");
        }
    }


    public static Map<Integer, Integer> buildFreqTable(LinkedList<Integer> list){
        Map<Integer,Integer> freqTable = new HashMap<>();

        for (Integer value : list){
            Integer frequency  = freqTable.get(value);
            if (frequency == null){
                freqTable.put(value, 1);
            } else {
                freqTable.put(value, ++frequency);
            }
        }

        return freqTable;
    }
}
