package arraysAndStrings;

import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * Example:
 *
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * https://leetcode.com/problems/3sum-closest/
 */
public class ThreeSumCloset {

    public static void main(String args[]) {
        int arr[] = {-1,2,1,-4};
        int result = threeSumClosest(arr, 1);
        System.out.println(result);
    }


    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int rsum = 0;
        for (int i = 0 ;i < nums.length-2; i++){

            int l = i+1;
            int h = nums.length-1;

            while (l < h){
                int sum = nums[i] + nums[l] + nums[h] ;
                int m = sum - target;
                if (Math.abs(m)  < min){
                    min = Math.abs(m);
                    rsum = sum;
                }
                if (sum < target){
                    l++;
                } else {
                    h--;
                }
            }
        }
        return rsum;
    }
}
