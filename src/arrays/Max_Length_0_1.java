package arrays;

import java.io.IOException;
import java.util.HashMap;

/**
 *
 * Length of the longest substring with equal 1s and 0s
 * Given a binary string. We need to find the length of longest balanced sub string.
 * A sub string is balanced if it contains equal number of 0 and 1.
 *
 * Examples:
 *
 * Input : input = 110101010
 * Output : Length of longest balanced
 *          sub string = 8
 *
 * Input : input = 0000
 * Output : Length of longest balanced
 *          sub string = 0
 *
 *
 * A simple solution is to use two nested loops to generate every substring.
 * And a third loop to count number of 0s and 1s in current substring. Time complexity of this would be O(n3)
 *
 * An efficient solution is to use hashing.
 * 1) Traverse string and keep track of counts of 1s and 0s as count_1 and count_0 respectively.
 * 2) See if current difference between two counts has appeared before. (We use hashing to store all differences and first index where a difference appears).
 * If yes, then substring from previous appearance and current index has same number of 0s and 1s.
 *
 * Below is the implementation of above approach
 */
public class Max_Length_0_1 {
        public static void main(String args[])throws IOException
        {
            String str = "101001000";

            // Create a map to store differences
            //between counts of 1s and 0s.
            HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

            // Initially difference is 0;
            map. put(0, -1);
            int res =0;
            int count_0 = 0, count_1 = 0;
            for(int i=0; i<str.length();i++)
            {
                // Keep track of count of 0s and 1s
                if(str.charAt(i)=='0')
                    count_0++;
                else
                    count_1++;

                // If difference between current counts
                // already exists, then substring between
                // previous and current index has same
                // no. of 0s and 1s. Update result if this
                // substring is more than current result.

                if(map.containsKey(count_1-count_0))
                    res = Math.max(res, (i - map.get(count_1-count_0)));

                    // If the current difference is seen first time.
                else
                    map.put(count_1-count_0,i);

            }

            System.out.println("Length of longest balanced sub string = "+res);
    }
}
