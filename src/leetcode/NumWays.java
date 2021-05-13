package leetcode;

/**
 * https://leetcode-cn.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/
 *
 * DFS 超时
 *
 * Try with Dynamic programming, dp(pos,steps): number of ways to back pos = 0 using exactly "steps" moves.
 *
 * if pos == 0
 *      dp(pos + 1, steps - 1) + dp(pos, steps - 1)
 *  else
 *      dp(pos, steps - 1) + dp(pos - 1, steps - 1) + dp(pos + 1, steps - 1)
 */
public class NumWays {

    private static final double MOD = 1e9 + 7;

    private static int numWays(int steps, int arrLen) {
        /*return (int) (dfs(0, steps, arrLen) % (1e9 + 7));*/

        int min = Math.min(steps + 1, arrLen);

        long[][] dp = new long[min][steps + 1];
        dp[0][0] = 1;

        for (int restStep = 1; restStep <= steps; restStep++) {

            dp[0][restStep] = (long) (dp[0][restStep - 1] % MOD + dp[1][restStep - 1] % MOD);

            for (int curPos = 1; curPos < min; curPos++) {
                dp[curPos][restStep] = (long) (dp[curPos][restStep - 1] % MOD + dp[curPos - 1][restStep - 1] % MOD);
                if (curPos < min - 1) {
                    dp[curPos][restStep] += (dp[curPos + 1][restStep - 1] % MOD);
                }
            }
        }

        return (int) (dp[0][steps] % MOD);
    }

    private static long dfs(int curPos, int restStep, int arrLen) {
        if (restStep < 0) {
            return 0;
        }
        if (curPos > arrLen) {
            return 0;
        }
        if (restStep == 0) {
            return curPos == 0 ? 1 : 0;
        }

        if (curPos == 0) {
            return dfs(curPos, restStep - 1, arrLen) + dfs(curPos + 1, restStep - 1, arrLen);
        }
        if (curPos == arrLen - 1) {
            return dfs(curPos, restStep - 1, arrLen) + dfs(curPos - 1, restStep - 1, arrLen);
        }

        return dfs(curPos, restStep - 1, arrLen) + dfs(curPos - 1, restStep - 1, arrLen) + dfs(curPos + 1, restStep - 1, arrLen);
    }

    public static void main(String[] args) {
        System.err.println(numWays(27, 7));
    }

}
