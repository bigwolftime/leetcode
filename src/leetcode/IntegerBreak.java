package leetcode;

/**
 * 整数拆分
 * https://leetcode-cn.com/problems/integer-break/
 *
 * 一个数 K, 比如第一次拆分出 i, 那么剩下的部分就是 k - i, k - i 需要拆分吗? 这要看 i >= k / 2 与否.
 * 考虑动态规划:
 *  当 k - i 不需要拆分, 即 i >= k / 2, 那么此时 dp[k] = i * (k - i)
 *  当 k - i 需要拆分时, dp[k] = i * dp[k - i].
 *  所以: dp[k] = Math.max(i * (k - i), i * dp[k - i])
 *
 *  其中: dp[0] = dp[1] = 0. 循环从 2 开始
 *
 *  时间复杂度: O(n ^ 2)
 *
 * @author liuxin
 * @date 2020/7/30 22:23
 */
public class IntegerBreak {

    private static int integerBreak(int n) {
        int[] dp = new int[n + 1];

        int split;
        int left;
        for (int i = 2; i <= n; i++) {
            for (split = 1; split <= (i >> 1); split++) {
                left = i - split;

                if (left < 1) {
                    break;
                }

                dp[i] = Math.max(dp[i], split * left);
                dp[i] = Math.max(dp[i], split * dp[left]);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.err.println(integerBreak(10));
    }

}
