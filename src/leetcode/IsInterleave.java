package leetcode;

/**
 * 交错字符串
 * https://leetcode-cn.com/problems/interleaving-string/
 *
 * f(i, j) 表示 s1 的前 i 个字符与 s2 的前 j 个字符可以交错组成 s3.
 *
 * 题解大概读懂了, 不过好像不得要领.
 *
 * @author liuxin
 * @date 2020/7/18 5:15
 */
public class IsInterleave {

    private static boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length()) {
            return false;
        }

        // 0: normal -1: abnormal
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 1;

        int len;
        for (int p = 0; p <= m; p++) {
            for (int q = 0; q <= n; q++) {
                len = p + q - 1;

                if (p > 0) {
                    dp[p][q] = dp[p][q] == 1 || (dp[p - 1][q] == 1 && s1.charAt(p - 1) == s3.charAt(len)) ? 1 : 0;
                }
                if (q > 0) {
                    dp[p][q] = dp[p][q] == 1 || (dp[p][q - 1] == 1 && s2.charAt(q - 1) == s3.charAt(len)) ? 1 : 0;
                }
            }
        }

        return dp[m][n] == 1;
    }

    public static void main(String[] args) {
        System.err.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));;
    }

}
