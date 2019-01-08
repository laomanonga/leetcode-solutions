public class Solution1 {

    public static void main(String[] args) {
        int[] result = twoSum1(new int[]{2, 7, 11, 15}, 17);
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
}
