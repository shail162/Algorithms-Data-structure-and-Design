package moderate.Q16_11_Diving_Board;

import java.util.HashSet;

/**
 * You are building a diving board by placing a bunch of planks of wood end-to-end. These are two
 * types of planks, one of length shorter and one of length longer. you must use exactly K planks of wood. Write
 * method of generate all possible lengths for the diving board.
 */
public class DivingBoardAllLengths {
	public static int counter = 0;
	
	public static HashSet<Integer> allLengths(int k, int shorter, int longer) {
		counter++;
		HashSet<Integer> lengths = new HashSet<Integer>();
		for (int nShorter = 0; nShorter <= k; nShorter++) {
			int nLonger = k - nShorter;
			int length = nShorter * shorter + nLonger * longer;
			lengths.add(length);
		}
		return lengths;
	}
	
	public static void main(String[] args) {
		HashSet<Integer> lengths = allLengths(12, 1, 3);
		System.out.println(lengths.toString());
	}

}
