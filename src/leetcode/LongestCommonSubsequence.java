package leetcode;

/**
 * 最长公共子序列
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 *
 * 经典 dp
 * dp[i][j] 表示 text1 的前 i 个长度，text2 的前 j 个长度 能够匹配的最长子序列
 */
public class LongestCommonSubsequence {

    private static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {

                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }

            }
        }

        return dp[text1.length()][text2.length()];
    }

    public static void main(String[] args) {

    }

}
