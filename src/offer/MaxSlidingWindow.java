package offer;

/**
 * 滑动窗口的最大值
 * https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 *
 * 1. 双指针 暴力解法
 * 2. 双端队列
 */
public class MaxSlidingWindow {

    private static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        // 解法 1:
        int i = 0, j = i + k - 1;
        if (j >= nums.length) {
            // 区间已覆盖所有元素
            int max = Integer.MIN_VALUE;
            for (int num : nums) {
                max = Math.max(max, num);
            }
            return new int[]{max};
        }

        int[] res = new int[nums.length - k + 1];
        int index = 0;

        while (j < nums.length) {
            int max = Integer.MIN_VALUE;
            while (i <= j) {
                max = Math.max(max, nums[i++]);
            }
            res[index] = max;

            j++;
            i = j - k + 1;
            index++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{ 1,3,-1,-3,5,3,6,7 };
        int[] arr = maxSlidingWindow(nums, 3);

        for (int i : arr) {
            System.err.println(i);
        }
    }

}
