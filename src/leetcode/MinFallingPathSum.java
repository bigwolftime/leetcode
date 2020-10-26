package leetcode;

/**
 * 下降路径最小和
 * https://leetcode-cn.com/problems/minimum-falling-path-sum/
 *
 * 动态规划, 老法师了
 *
 * @author liuxin
 * @time 2020/10/26 16:24
 */
public class MinFallingPathSum {

    private static int minFallingPathSum(int[][] A) {
        int len = A.length;
        int[][] arr = new int[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {

                if (i == 0) {
                    // 第一行
                    arr[i][j] = A[i][j];
                } else {
                    int top = arr[i - 1][j];

                    if (j + 1 < len) {
                        top = Math.min(top, arr[i - 1][j + 1]);
                    }
                    if (j - 1 >= 0) {
                        top = Math.min(top, arr[i - 1][j - 1]);
                    }

                    arr[i][j] = top + A[i][j];
                }
            }
        }

        int min = arr[len - 1][0];
        for (int i = 1; i < len; i++) {
            min = Math.min(min, arr[len - 1][i]);
        }

        return min;
    }

    public static void main(String[] args) {
        int[][] A = new int[][]{
                { 1,2,3 },
                { 4,5,6 },
                { 7,8,9 }
        };

        minFallingPathSum(A);
    }

}
