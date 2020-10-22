package offer;

/**
 * 礼物的最大价值
 * https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 *
 * @author liuxin
 * @time 2020/10/22 15:45
 */
public class MaxValue {

    private static int maxValue(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int[][] valArr = new int[row][col];
        int val;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (i == 0 && j == 0) {
                    val = grid[0][0];
                } else if (i == 0) {
                    // 第一行, 只能从左到右
                    val = grid[i][j] + valArr[i][j - 1];
                } else if (j == 0) {
                    // 第一列
                    val = grid[i][j] + valArr[i - 1][j];
                } else {
                    val = grid[i][j] + Math.max(valArr[i - 1][j], valArr[i][j - 1]);
                }

                valArr[i][j] = val;
            }
        }

        return valArr[row - 1][col - 1];
    }

    public static void main(String[] args) {

    }

}
