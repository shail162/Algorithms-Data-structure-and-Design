import java.util.Arrays;

/**
 * Given an array of integers, write a function that returns true if there is a triplet (a, b, c) that satisfies a2 + b2 = c2.
 *
 * Method 1 (Naive)
 * A simple solution is to run three loops, three loops pick three array elements and check if current three elements form a Pythagorean Triplet.
 *
 * Method 2 (Use Sorting)
 * We can solve this in O(n2) time by sorting the array first.
 *
 * 1) Do square of every element in input array. This step takes O(n) time.
 *
 * 2) Sort the squared array in increasing order. This step takes O(nLogn) time.
 *
 * 3) To find a triplet (a, b, c) such that a2 = b2 + c2, do following.
 *
 * Fix ‘a’ as last element of sorted array.
 * Now search for pair (b, c) in subarray between first element and ‘a’.
 * A pair (b, c) with given sum can be found in O(n) time using meet in middle algorithm discussed in method 1 of this post.
 * If no pair found for current ‘a’, then move ‘a’ one position back and repeat step 3.2.
 *
 * Input: arr[] = {3, 1, 4, 6, 5}
 * Output: True
 * There is a Pythagorean triplet (3, 4, 5).
 *
 * Input: arr[] = {10, 4, 6, 12, 5}
 * Output: False
 * There is no Pythagorean triplet.
 *
 */
class PythagoreanTriplet {


    //naive approach O(n3)
    static boolean isTripletNaive(int ar[], int n)
    {
        for (int i=0; i<n; i++)
        {
            for (int j=i+1; j<n; j++)
            {
                for (int k=j+1; k<n; k++)
                {
                    // Calculate square of array elements
                    int x = ar[i]*ar[i], y = ar[j]*ar[j], z = ar[k]*ar[k];

                    if (x == y + z || y == x + z || z == x + y)
                        return true;
                }
            }
        }

        // If we reach here, no triplet found
        return false;
    }



    // Returns true if there is a triplet with following property
    // A[i]*A[i] = A[j]*A[j] + A[k]*[k]
    // Note that this function modifies given array
    //O(n2)
    //Input: arr[] = {3, 1, 4, 6, 5}
    //sort and square: {1, 9, 16, 25, 36}

    static boolean isTriplet(int arr[], int n) {
        // Square array elements
        for (int i = 0; i < n; i++)
            arr[i] = arr[i] * arr[i];

        // Sort array elements
        Arrays.sort(arr);

        // Now fix one element one by one and find the other two
        // elements
        for (int i = n - 1; i >= 2; i--) {
            // To find the other two elements, start two index
            // variables from two corners of the array and move
            // them toward each other
            int l = 0; // index of the first element in arr[0..i-1]
            int r = i - 1; // index of the last element in arr[0..i-1]
            while (l < r) {
                // A triplet found
                if (arr[l] + arr[r] == arr[i])
                    return true;

                // Else either move 'l' or 'r'
                if (arr[l] + arr[r] < arr[i])
                    l++;
                else
                    r--;
            }
        }

        // If we reach here, then no triplet found
        return false;
    }

    public static void main(String args[]) {
        int arr[] = {3, 1, 4, 6, 5};
        System.out.println(isTriplet(arr, arr.length));
    }


}
