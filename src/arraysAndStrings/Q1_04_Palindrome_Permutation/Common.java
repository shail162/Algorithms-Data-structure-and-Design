package arraysAndStrings.Q1_04_Palindrome_Permutation;

/**
 * Given a string, write a function to check if it is a permutation of a palindrome. Permutation is re-arrangement
 * of letters.
 *
 * Example: Tact Coa
 * Output : true (permutations: "tacocat" , "atcocta" etc)
 */
public class Common {

	public static int getCharNumber(Character c) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		
		int val = Character.getNumericValue(c);
		if (a <= val && val <= z) {
			return val - a;
		}
		return -1;
	}
	
	public static int[] buildCharFrequencyTable(String phrase) {
		int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		for (char c : phrase.toCharArray()) {
			int x = getCharNumber(c);
			if (x != -1) {
				table[x]++;
			}
		}
		return table;
	}

}
