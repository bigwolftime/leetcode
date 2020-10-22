package leetcode;

/**
 * 不同路径
 * https://leetcode-cn.com/problems/unique-paths/
 *
 * 经典动态规划
 *
 * @author liuxin
 * @time 2020/10/22 20:36
 */
public class UniquePaths {

    private static int uniquePaths(int m, int n) {
        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    arr[0][0] = 1;
                } else if (i == 0) {
                    // 第一行
                    arr[i][j] = 1;
                } else if (j == 0) {
                    // 第一列
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
                }
            }
        }

        return arr[m - 1][n - 1];
    }

    public static void main(String[] args) {

    }

}
