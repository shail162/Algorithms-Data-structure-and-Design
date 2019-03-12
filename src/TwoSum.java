import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class TwoSum {

    public static void main(String args[]) {
            int nums[] = {2, 7, 11, 15};
            Integer result[] = twoSum(nums, 9 );
            Arrays.stream(result).forEach(integer -> System.out.print(integer + ","));
    }

    public static Integer[] twoSum(int[] nums, int target) {
        Integer result[] = new Integer[2];
        Map<Integer,Integer> map = new HashMap<>();

        for (Integer i = 0; i < nums.length ; i++){
            if (map.get(nums[i])!=null){
                result[0] = map.get(nums[i]);
                result[1] = i;
                break;
            } else {
                map.put(target - nums[i], i);
            }
        }
        return result;
    }
}