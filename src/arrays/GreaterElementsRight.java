package arrays;

import java.util.Stack;

/**
 * Given an array of positive integers. Your task is to find the leaders in the array.
 * Note: An element of array is leader if it is greater than or equal to all the elements to its right side.
 * Also, the rightmost element is always a leader.
 *
 * input : 16, 17, 4, 3, 5, 2
 * output 17 5 2
 *
 */
public class GreaterElementsRight {

    public static void main(String args[]) {
        int arr[] = {16, 17, 4, 3, 5, 2} ; //{6,3,9,1,7,8};
        printAllElementsGreaterThanRight(arr);
    }


    public static void printAllElementsGreaterThanRight(int arr[]) {

        if (arr.length == 0){
            return;
        }

        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int maxElement = arr[n-1];

        stack.push(maxElement);

        for (int i = n-2 ; i>=0 ; i--){
            if(arr[i] > maxElement){
                maxElement = arr[i];
                stack.push(maxElement);
            }
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
}
