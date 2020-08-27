package leetcode;

/**
 * 逐步求和得到正数的最小值
 * https://leetcode-cn.com/problems/minimum-value-to-get-positive-step-by-step-sum/
 *
 * @author liuxin
 * @time 2020/8/27 20:13
 */
public class MinStartValue {

    private static int minStartValue(int[] nums) {
        int min = nums[0], res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            res += nums[i];
            min = Math.min(res, min);
        }

        return min < 0 ? -min + 1 : 1;
    }

    public static void main(String[] args) {
        System.err.println(minStartValue(new int[]{1,-2,-3}));
    }

}
