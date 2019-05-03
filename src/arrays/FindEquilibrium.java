package arrays;

/**
 *
 * Equilibrium index of an array is an index such that the sum of elements at lower indexes
 * is equal to the sum of elements at higher indexes. For example, in an array A:
 *
 * Example :
 *
 * Input : A[] = {-7, 1, 5, 2, -4, 3, 0}
 * Output : 3
 * 3 is an equilibrium index, because:
 * A[0] + A[1] + A[2]  =  A[4] + A[5] + A[6]
 *
 *
 * Solution O(n)
 * 1) Initialize leftsum  as 0
 * 2) Get the total sum of the array as sum
 * 3) Iterate through the array and for each index i, do following.
 *     a)  Update sum to get the right sum.
 *            sum = sum - arr[i]
 *        // sum is now right sum
 *     b) If leftsum is equal to sum, then return current index.
 *     c) leftsum = leftsum + arr[i] // update leftsum for next iteration.
 * 4) return -1 // If we come out of loop without returning then
 *              // there is no equilibrium index
 */
public class FindEquilibrium {

    public static void main(String args[]){
        int arr[] = {1 ,3 ,5 ,2 ,2}; //ouput index 3

        int result = findEquilibrium(arr);
        System.out.println(result);
    }

        //Time Complexity: O(n)
    public static int findEquilibrium(int arr[]){
        int totalSum = 0;
        for (int i =0 ; i < arr.length; i++){
            totalSum+= arr[i];
        }

        int leftSum = 0;
        int rightSum = totalSum;
        int j = arr.length-1;
        for (int i =0; i <= j; i++,j--){

            rightSum = rightSum - arr[i];

            if (leftSum == rightSum){
                return i;
            }

            leftSum += arr[i];
        }

        return -1;
    }
}
