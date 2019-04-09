package recursionAndDP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllPossibleSubsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }


    public static void main(String args[]) {
        int nums[] = {1,2,3, 4};
        subsets(nums).stream().forEach(list -> System.out.println(list));
    }
}
