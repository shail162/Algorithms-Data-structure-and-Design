package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Remove duplicates from a given string
 *
 * Time O(n)
 * Space O(n)
 */
public class RemoveDuplicates {

    public static String removeDupliates(char[] str) {

        boolean present[] = new boolean[256];
        List<Character> result = new ArrayList<>();
        int n = str.length;  // str is input string

        Arrays.fill(present, true);
        /* In place removal of duplicate characters*/
        for (int i = 0; i < n; i++) {
            if (present[str[i]] == true) {
                result.add(str[i]);
                present[str[i]] = false;
            }
        }
        return  result.stream().map(c->c.toString()).collect(Collectors.joining());

        //OR     result.forEach(ch->builder.append(ch));
        /** OR
         * return result.stream().collect(Collector.of(
         *     StringBuilder::new,
         *     StringBuilder::append,
         *     StringBuilder::append,
         *     StringBuilder::toString));
         */
    }

    public static void main(String args[]) {
        char arr[] = "geeksforgeeks".toCharArray();

        System.out.println(removeDupliates(arr));
    }
}
