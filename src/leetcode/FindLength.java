package leetcode;

/**
 * 最长重复子数组
 * https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
 *
 * 解法很好理解, 就是想不出来.
 *
 * 1. dp: 从后向前遍历, 如果 A[i] == A[j],
 *      则若 A[i - 1] == B[j - 1], dp[i - 1][j - 1] = dp[i][j] + 1.
 *      否则 dp[i - 1][j - 1] = 0.
 *
 *    时间复杂度: O(n * m), 空间复杂度: O(n * m)
 *
 *    相当于创建一个二维数组, 在数组中以 右下角 的方向进行搜索, 最多连续多少个 1.(或者理解为如果相等, 则等于 左上角的值 + 1, 否则为 0)
 *
 * @author liuxin
 * @time 2020/7/1 10:14
 */
public class FindLength {

    private static int findLength(int[] A, int[] B) {
        int max = 0;

        if (A.length == 0 || B.length == 0) {
            return max;
        }

        int[][] dp = new int[A.length + 1][B.length + 1];
        for (int i = A.length - 1; i >= 0; i--) {
            for (int j = B.length - 1; j >= 0; j--) {
                dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
                max = Math.max(dp[i][j], max);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int length = findLength(new int[]{5, 3, 2, 1, 4, 0}, new int[]{2, 7, 3, 2, 1, 0});
        System.err.println(length);
    }

}
