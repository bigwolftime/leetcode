package leetcode;

/**
 * 最小路径和
 * https://leetcode-cn.com/problems/minimum-path-sum/
 *
 * 动态规划
 *
 * @author liuxin
 * @date 2020/7/23 7:09
 */
public class MinPathSum {

    private static int minPathSum(int[][] grid) {
        int maxX = grid.length, maxY = grid[0].length;
        Integer top = null, left = null;

        for (int x = 0; x < maxX; x++) {
            for (int y = 0; y < maxY; y++) {
                if (x > 0) {
                    top = grid[x - 1][y];
                }
                if (y > 0) {
                    left = grid[x][y - 1];
                }

                if (top != null && left != null) {
                    grid[x][y] = Math.min(left, top) + grid[x][y];
                } else if (top != null) {
                    grid[x][y] = top + grid[x][y];
                } else if (left != null) {
                    grid[x][y] = left + grid[x][y];
                }

                top = null;
                left = null;
            }
        }

        return grid[maxX - 1][maxY - 1];
    }

    public static void main(String[] args) {

    }

}
