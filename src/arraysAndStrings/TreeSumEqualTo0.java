package arraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeSumEqualTo0 {
    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);


        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0 ;i < nums.length-2; i++){

            int l = i+1;
            int h = nums.length-1;

            while (l < h){
                int sum = nums[i] + nums[l] + nums[h] ;
                if (sum == 0) {
                    List<Integer> list = new ArrayList();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[h]);
                    if (!result.contains(list)){
                        result.add(list);
                    }

                    l++;
                    h--;
                } else if (sum < 0){
                    l++;
                } else {
                    h--;
                }
            }
        }

        return result;
    }

    public static void main(String args[]) {
        int arr[] = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        List<List<Integer>> result  = threeSum(arr);

        result.stream().forEach(list -> System.out.println(list));
    }
}
