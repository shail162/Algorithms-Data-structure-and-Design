package strings.Q1_01_Is_Unique;

import java.util.HashSet;
import java.util.Set;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * Time complexity O(n)
 */
public class IsUniqueHashSet {
    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            System.out.println(word + ": " + isUniqueChars(word));
        }
    }

    private static boolean isUniqueChars(String word) {
        char[] charArray = word.toCharArray();
        Set<Character> set = new HashSet<>();

        for (char ch : charArray){
            if (set.add(ch) == false){
                return false;
            }
        }
        return true;
    }
}
