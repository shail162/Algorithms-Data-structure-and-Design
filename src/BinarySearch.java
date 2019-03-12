/**
 * Divide and Conquer
 *
 * Time complexity O(logn)
 *
 * It is based on height of a tree. If there are 16 elements then max comparison required will be 4 which is height of a tree.
 * log16 = 4 where n = 16
 */

public class BinarySearch {

    public static void main(String args[]){
        int arr[] = {1,4,6,8,10};
        int index  = iterative(arr, 5);
        System.out.println("found at index " + index);

        int rindex = recursive(arr, 0, arr.length-1, 5);
        System.out.println("found at index " + rindex);
    }

    public static int iterative(int arr[], int search){

        int high = arr.length -1 ;
        int low = 0;

        while (low <= high){
            int mid = (low+high)/2 ;

            if (arr[mid] == search){
                return mid;
            }
            if (arr[mid] < search){
                low = mid +1;
            } else {
                high = mid -1;
            }
        }
        return -1;
    }


    public static int recursive(int arr[], int low, int high, int search){

        if (low > high){
            return -1;
        }

        int mid = (low + high) /2;

        if (arr[mid] == search){
            return mid;
        } else if(arr[mid] < search){
               return recursive(arr, mid+1, high, search);
        } else {
            return recursive(arr, low, mid-1, search);
        }
    }
}
