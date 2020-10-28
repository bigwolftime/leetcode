package leetcode;

import java.util.HashSet;

/**
 * 零钱兑换
 * https://leetcode-cn.com/problems/coin-change/
 *
 * 动态规划, 自底向上
 * 起初的想法是: dp[i] = Math.min(dp[1] + dp[i - 1]) + Math.min(dp[2] + dp[i - 2])... 但是超时
 * 官方的解法是: 只需遍历 coins 中的 dp 数据即可
 *
 * @author liuxin
 * @time 2020/10/28 14:18
 */
public class CoinChange {

    private static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        HashSet<Integer> set = new HashSet<>();
        for (int val : coins) {
            set.add(val);
        }

        for (int i = 1; i <= amount; i++) {
            if (set.contains(i)) {
                dp[i] = 1;
            } else {
                int min = Integer.MAX_VALUE;
                boolean flag = false;

                for (int coin : coins) {
                    int leftAmount = i - coin;

                    if (leftAmount <= 0 || dp[coin] == -1 || dp[leftAmount] == -1) {
                        continue;
                    }

                    min = Math.min(min, dp[coin] + dp[leftAmount]);
                    flag = true;
                }

                dp[i] = flag ? min : -1;
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        System.err.println(coinChange(new int[]{2}, 1));
    }

}
