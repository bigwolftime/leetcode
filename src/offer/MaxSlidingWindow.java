package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 滑动窗口的最大值
 * https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 *
 * 1. 双指针 暴力解法
 * 2. 双端队列
 * todo
 */
public class MaxSlidingWindow {

    private static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        // 解法 2:

        int p = 0, q = p + k - 1;
        if (q >= nums.length) {
            // 区间已覆盖所有元素
            int max = Integer.MIN_VALUE;
            for (int num : nums) {
                max = Math.max(max, num);
            }
            return new int[]{max};
        }

        List<Integer> list = new ArrayList<>();
        int[] res = new int[nums.length - k + 1];

        int max = nums[0];
        for (int i = 1; i < k; i++) {
            max = Math.max(max, nums[i]);
        }
        list.add(max);
        res[0] = max;

        int lastIdx;
        int tail;
        int index = 1;
        for (int i = k; i < nums.length; i++) {
            lastIdx = list.size() - 1;
            tail = list.get(lastIdx);

            while (nums[i] > tail) {
                list.remove(lastIdx);

                if (list.isEmpty()) {
                    break;
                }

                lastIdx = list.size() - 1;
                tail = list.get(lastIdx);
            }

            list.add(nums[i]);


            max = Integer.MIN_VALUE;
            for (int m = list.size() - 1; m >= 0 && m > list.size() - 1 - k; m--) {
                max = Math.max(max, list.get(m));
            }

            res[index++] = max;
        }

        return res;


        // 解法 1:
        /*int i = 0, j = i + k - 1;
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

        return res;*/
    }

    public static void main(String[] args) {
        int[] nums = new int[]{ 1,3,-1,-3,5,3,6,7 };
        int[] arr = maxSlidingWindow(nums, 3);

        for (int i : arr) {
            System.err.println(i);
        }
    }

}
