import org.omg.SendingContext.RunTime;

import java.util.HashMap;

public class Solution1 {

    public static void main(String[] args) {
//        int[] result = twoSum1(new int[]{2, 7, 11, 15}, 17);
        int[] result = twoSum2(new int[]{3, 2, 4}, 6);
        System.err.println(result[0]);
        System.err.println(result[1]);
    }

    public static int[] twoSum1(int[] nums, int target) {
        int[] result = new int[]{0,0};
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            record.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int targetKey = target - nums[i];
            Integer targetValue = record.get(targetKey);
            if (targetValue!=null && targetValue!=i) {
                return new int[]{i, targetValue};
            }
        }
        throw new IllegalArgumentException("no result ");
    }
}
