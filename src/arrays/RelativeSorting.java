package arrays;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Sort an array according to the order defined by another array
 * Given two arrays A1[] and A2[], sort A1 in such a way that the relative order among the elements will be same as those are in A2.
 *
 * For the elements not present in A2, append them at last in sorted order.
 * Input: A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8}
 *        A2[] = {2, 1, 8, 3}
 * Output: A1[] = {2, 2, 1, 1, 8, 8, 3, 5, 6, 7, 9}
 */
public class RelativeSorting {

    public static void main(String args[]){
        int arr1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
        int arr2[] = {2, 1, 8, 3};

        new RelativeSorting().relativeSorting(arr1, arr2);

        Arrays.stream(arr1).forEach(value -> System.out.print(value +" "));
    }


    public void relativeSorting(int arr1[], int arr2[]) {

       Map<Integer, Integer> freqMap =  createFreqMap(arr1);
       int index = 0;
       for (int i = 0; i < arr2.length ; i++){
            Integer value  = freqMap.get(arr2[i]);

            for (int j = 0 ; j < value ; j++){
                arr1[index++] = arr2[i];
            }
            freqMap.remove(arr2[i]);
       }

       //sort the remaining map
        Map<Integer, Integer> sorted = freqMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap
                        (Map.Entry::getKey, Map.Entry::getValue, (oldValue,newValue) -> oldValue, LinkedHashMap::new));

       //copy remaining sorted values into original array
       for (Map.Entry<Integer,Integer> entry : sorted.entrySet()){
           arr1[index++] = entry.getKey();
       }

    }

    /**
     * Create frequency map
     * @param arr1
     * @return
     */
    private static Map<Integer, Integer> createFreqMap(int[] arr1) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i =0; i< arr1.length; i++){

           Integer count =  map.getOrDefault(arr1[i], 0) ;
           map.put(arr1[i], ++count);
        }

        return map;
    }
}
