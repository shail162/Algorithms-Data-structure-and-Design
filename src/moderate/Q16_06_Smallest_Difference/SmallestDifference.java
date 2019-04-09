package moderate.Q16_06_Smallest_Difference;

/**
 * Given 2 arrays of integers, compute the pair of values (one value in each array) with the smallest non-negative difference.
 * Return the difference.
 *
 * Example:
 * Input : {1,3,15,11,2}, {23,127,235,19,8}
 * Output: 3
 */
public class SmallestDifference {
	public static int findSmallestDifference(int[] arrayA, int[] arrayB) {
		if (arrayA.length == 0 || arrayB.length == 0) return -1;
	
		int smallestDifference = Integer.MAX_VALUE;
		for (int a : arrayA) {
			for (int b : arrayB) {
				smallestDifference = Math.min(smallestDifference, Math.abs(a - b));
			}
		}
		return smallestDifference;
	}
	
	public static void main(String[] args) {
		int[] array1 = {1, 3, 15, 11, 2};
		int[] array2 = {23, 127, 234, 19, 8};
		int difference = findSmallestDifference(array1, array2);
		System.out.println(difference);
	}

}
