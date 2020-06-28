package leetcode;

/**
 * 长度最小的子数组
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 *
 * 使用 前缀和 + 双指针
 *
 * @Author Liuxin
 * @Date 2019/4/1 17:26
 */
public class MinSubArrayLen {

    public static int minSubArrayLen(int s, int[] nums) {
        int start = 0, end = 0;
        int sum = 0;
        Integer minLen = null;
        boolean expand = false;

        while (end < nums.length) {
            if (start != end) {
                sum = expand ? sum + nums[end] : sum - nums[start - 1];
            } else {
                sum = nums[start];
            }

            if (sum >= s) {
                minLen = minLen != null ? Math.min(minLen, end - start + 1) : end - start + 1;
                start++;
                expand = false;
            } else {
                end++;
                expand = true;
            }
        }

        return minLen == null ? 0 : minLen;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1};
        System.err.println(minSubArrayLen(3, nums));
    }
}
