package leetcode;

/**
 * 删掉一个元素以后全为 1 的最长数组
 * https://leetcode-cn.com/problems/longest-subarray-of-1s-after-deleting-one-element/
 *
 * 双周赛 29 第三题
 *
 * 待优化
 *
 * @author liuxin
 * @time 2020/6/28 17:27
 */
public class LongestSubarray {

    private static int longestSubarray(int[] nums) {
        int leftZeroCount, rightZeroCount;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            leftZeroCount = getLeftZeroCount(nums, i - 1);
            rightZeroCount = getRightZeroCount(nums, i + 1);
            maxLen = Math.max(maxLen, leftZeroCount + rightZeroCount);
        }

        return maxLen;
    }

    private static int getLeftZeroCount(int[] nums, int index) {
        int count = 0;
        while (index >= 0 && nums[index] == 1) {
            count++;
            index--;
        }
        return count;
    }

    private static int getRightZeroCount(int[] nums, int index) {
        int count = 0;
        while (index < nums.length && nums[index] == 1) {
            count++;
            index++;
        }
        return count;
    }

    public static void main(String[] args) {
        longestSubarray(new int[]{ 1,1,1 });
    }

}
