public class Solution1 {

    public static void main(String[] args) {
        int[] result = twoSum(new int[]{2, 7, 11, 15}, 26);
        System.err.println(result[0]);
        System.err.println(result[1]);
    }
    public static int[] twoSum(int[] nums, int target) {
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
