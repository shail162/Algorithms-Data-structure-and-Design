package strings.Q1_04_Palindrome_Permutation;

/**
 * Given a string, write a function to check if it is a permutation of a palindrome. Permutation is re-arrangement
 * of letters.
 *
 * Example: Tact Coa
 * Output : true (permutations: "tacocat" , "atcocta" etc)
 */
public class PalindromePermutation {

	public static boolean isPermutationOfPalindrome(String phrase) {
		int countOdd = 0;
		int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		for (char c : phrase.toCharArray()) {
			int x = Common.getCharNumber(c);
			if (x != -1) {
				table[x]++;

				if (table[x] % 2 == 1) {
					countOdd++;
				} else {
					countOdd--;
				}
			}
		}
		return countOdd <= 1;
	}
	
	public static void main(String[] args) {
		String pali = "Ratzs live on no evil starz";
		System.out.println(isPermutationOfPalindrome(pali));
		String pali2 = "Zeus was deified, saw Suez";
		System.out.println(isPermutationOfPalindrome(pali2));
	}
}
