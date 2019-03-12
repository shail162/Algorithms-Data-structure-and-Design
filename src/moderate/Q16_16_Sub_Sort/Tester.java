package moderate.Q16_16_Sub_Sort;

import library.AssortedMethods;

public class Tester {

	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			int[] array = AssortedMethods.randomArray(7, 1, 3);
			Range r1 = SubSort.findUnsortedSequence(array);
			Range r2 = SubSort.findUnsortedSequence(array);
			if (r1 == null && r2 == null) {
				continue;
			}
			if (r1 == null || !r1.equals(r2)) {
				System.out.println("ERROR");
				System.out.println(AssortedMethods.arrayToString(array));

				System.out.println(r1 == null ? "null" : r1.toString());

				System.out.println(r2 == null ? "null" : r2.toString());
			}
		}

	}

}
