package offer;

/**
 * 滑动窗口的最大值
 * https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 */
public class MaxSlidingWindow {

    private static int[] maxSlidingWindow(int[] nums, int k) {
        // 无数据
        if (nums == null || nums.length == 0) {
            return new int[]{0};
        }

        // k > nums.length
        int max = getMaxNum(nums, k);
        if (k > nums.length) {
            return new int[]{ max };
        }

        int start = 1, end = Math.min(nums.length, k);
        int[] res = new int[nums.length - k + 1];
        while (end < nums.length) {
            res[start] = Math.max(max, nums[end]);

            start++;
            end++;
        }
        res[0] = max;

        return res;
    }

    private static int getMaxNum(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{ 1,3,-1,-3,5,3,6,7 };
        int[] arr = maxSlidingWindow(nums, 3);
        for (int i : arr) {
            System.err.println(i);
        }
    }

}
