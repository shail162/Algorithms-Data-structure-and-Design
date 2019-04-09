package arraysAndStrings;

import java.util.Stack;

public class GreaterElementsRight {

    public static void main(String args[]) {
        int arr[] = {6,10,11,9,2} ; //{6,3,9,1,7,8};
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
