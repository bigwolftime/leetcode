package leetcode;

import java.util.Arrays;

/**
 * 三个数的最大乘积
 * https://leetcode-cn.com/problems/maximum-product-of-three-numbers/
 *
 * 1. 排序
 * 2. 2负数 + 1正数
 * 2. 3正数
 */
public class MaximumProduct {

    private static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;

        int max = 0;
        if (nums[0] < 0 && nums[1] < 0) {
            max = nums[0] * nums[1] * nums[len - 1];
        }

        max = Math.max(max, nums[len - 1] * nums[len - 2] * nums[len - 3]);

        return max;
    }

    public static void main(String[] args) {

    }

}
