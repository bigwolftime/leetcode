package leetcode;

/**
 * 使用最小花费爬楼梯
 * https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 *
 * 需要判断数组的最后两个元素, 取最小的.
 *
 * @author liuxin
 * @time 2020/10/26 15:43
 */
public class MinCostClimbingStairs {

    private static int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < len; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        return Math.min(dp[len - 2], dp[len - 1]);
    }

    public static void main(String[] args) {

    }

}
