package hard;

import java.util.Arrays;

/**
 * Let’s visualize a better solution using an example, the given number is 12543 and
 * the resulting next higher number should be 13245.
 *
 * We scan the digits of the given number starting from the tenths digit (which is 4 in our case) going towards left.
 * At each iteration we check the right digit of the current digit we’re at,
 * and if the value of right is greater than current we stop, otherwise we continue to left.
 * So we start with current digit 4, right digit is 3, and 4>=3 so we continue. Now current digit is 5, right digit is 4, and 5>= 4, continue.
 * Now current is 2, right is 5, but it’s not 2>=5, so we stop. The digit 2 is our pivot digit. From the digits to the right of 2,
 * we find the smallest digit higher than 2, which is 3. This part is important,
 * we should find the smallest higher digit for the resulting number to be precisely the next higher than original number.
 * We swap this digit and the pivot digit, so the number becomes 13542. Pivot digit is now 3.
 * We sort all the digits to the right of the pivot digit in increasing order, resulting in 13245.
 *
 * O(logN)
 */
public class FindNextGreaterElement {
        // Utility function to swap two digit
        static void swap(char ar[], int i, int j)
        {
            char temp = ar[i];
            ar[i] = ar[j];
            ar[j] = temp;
        }

        // Given a number as a char array number[],
        // this function finds the next greater number.
        // It modifies the same array to store the result
        static void findNext(char ar[], int n)
        {
            int i;

            // I) Start from the right most digit
            // and find the first digit that is smaller
            // than the digit next to it.
            for (i = n - 1; i > 0; i--)
            {
                if (ar[i] > ar[i - 1]) {
                    break;
                }
            }

            // If no such digit is found, then all
            // digits are in descending order means
            // there cannot be a greater number with
            // same set of digits
            if (i == 0)
            {
                System.out.println("Not possible");
            }
            else
            {
                int x = ar[i - 1], min = i;

                // II) Find the smallest digit on right
                // side of (i-1)'th digit that is greater
                // than number[i-1]
                for (int j = i + 1; j < n; j++)
                {
                    if (ar[j] > x && ar[j] < ar[min])
                    {
                        min = j;
                    }
                }

                // III) Swap the above found smallest
                // digit with number[i-1]
                swap(ar, i - 1, min);

                // IV) Sort the digits after (i-1)
                // in ascending order
                Arrays.sort(ar, i, n);
                System.out.print("Next number with same" +
                        " set of digits is ");
                for (i = 0; i < n; i++)
                    System.out.print(ar[i]);
            }
        }

        public static void main(String[] args)
        {
            char digits[] = { '5','3','4','9','7','6' };
            int n = digits.length;
            findNext(digits, n);
        }

}
