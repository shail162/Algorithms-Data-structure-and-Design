package recursionAndDP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Input : arr[] = {2, 3, 5, 6, 8, 10}
 *         sum = 10
 * Output : 5 2 3
 *          2 8
 *          10
 *
 * Input : arr[] = {1, 2, 3, 4, 5}
 *         sum = 10
 * Output : 4 3 2 1
 *          5 3 2
 *          5 4 1
 */
public class AllSubsetsWithGivenSum {

    public static List<List<Integer>> subsets(int[] nums, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0, sum);
        return list;
    }

    private static void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start, int sum){
        if (sum == 0)
            list.add(new ArrayList<>(tempList));
        else {
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, i + 1, sum - nums[i]);
                tempList.remove(tempList.size() - 1);
            }
        }
    }


    public static void main(String args[]) {
        int nums[] = {1,2,3,4,5,6};
        int sum = 6;
        subsets(nums, sum).stream().forEach(list -> System.out.println(list));
    }
}
