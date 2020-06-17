package leetcode;

/**
 * 最大正方形
 * https://leetcode-cn.com/problems/maximal-square/
 *
 * 1. 动态规划;
 * 2. 暴力循环每一个元素;
 */
public class MaximalSquare {

    private static int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        int max = 0;
        int[][] arr = new int[matrix.length][matrix[0].length];
        int temp, tempI, tempJ;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    arr[i][j] = 0;
                } else {
                    // 取 min(左上, 左, 上), 然后 +1 [考虑边界]
                    tempI = i - 1;
                    tempJ = j - 1;
                    if (tempI >= 0 && tempJ >= 0) {
                        // 非最上 && 非最左
                        temp = Math.min(Math.min(arr[tempI][tempJ], arr[i][tempJ]), arr[tempI][j]);
                        arr[i][j] = temp + 1;
                    } else {
                        arr[i][j] = 1;
                    }

                    max = Math.max(max, arr[i][j]);
                }
            }
        }

        return max * max;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][] {
                { '0', '1', '1', '1', '0' },
                { '1', '1', '1', '1', '0' },
                { '0', '1', '1', '1', '1' },
                { '0', '1', '1', '1', '1' },
                { '0', '0', '1', '1', '1' }
        };

        System.err.println(maximalSquare(matrix));
    }

}
