package leetcode;

/**
 * @author liuxin
 * @date 2020/5/2 12:55
 *
 * 滑动窗口最大值
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class MaxSlidingWindow {

    private static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }

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
        int[] nums = new int[]{ };
        int[] ints = maxSlidingWindow(nums, 0);

        for (int i : ints) {
            System.err.println(i);
        }
    }

}
