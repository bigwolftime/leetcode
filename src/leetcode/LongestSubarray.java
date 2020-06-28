package leetcode;

/**
 * 删掉一个元素以后全为 1 的最长数组
 * https://leetcode-cn.com/problems/longest-subarray-of-1s-after-deleting-one-element/
 *
 * 双周赛 29 第三题
 *
 * @author liuxin
 * @time 2020/6/28 17:27
 */
public class LongestSubarray {

    private static int longestSubarray(int[] nums) {
        int leftZeroCount = 0, rightZeroCount = 0;
        int maxLen = 0;

        for (int num : nums) {
            if (num == 0) {
                leftZeroCount = rightZeroCount;
                rightZeroCount = 0;
            } else {
                rightZeroCount++;
            }

            maxLen = Math.max(maxLen, leftZeroCount + rightZeroCount);
        }

        return maxLen != nums.length ? maxLen : nums.length - 1;
    }

    public static void main(String[] args) {
        System.err.println(longestSubarray(new int[]{ 0,0,1,1,0,0,1,1,1,0,1 }));;
    }

}
