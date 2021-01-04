package leetcode;

/**
 * 乘积最大子数组
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 *
 * 状态转移方程需要考虑特殊情况:
 * [-2,3,-4]
 * 当前位置的最优解不一定是前一个位置的最优解转移得到的.
 */
public class maxProduct {

    private static int maxProduct(int[] nums) {
        int[] maxArr = new int[nums.length];
        int[] minArr = new int[nums.length];
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < nums.length; i++) {
            maxArr[i] = Math.max(maxArr[i - 1] * nums[i], Math.max(nums[i], minArr[i - 1] * nums[i]));
            minArr[i] = Math.min(minArr[i - 1] * nums[i], Math.min(nums[i], maxArr[i - 1] * nums[i]));
        }

        return max;
    }

    public static void main(String[] args) {
        int i = maxProduct(new int[]{-2, 3, -4});
        System.err.println(i);
    }

}
