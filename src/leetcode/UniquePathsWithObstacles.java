package leetcode;

/**
 * 不同路径II
 * https://leetcode-cn.com/problems/unique-paths-ii/
 *
 * 时隔一年再看动态规划, 感觉没那么晦涩难懂了.
 * 这道题很好理解
 *
 * 以 f(x,y) 表示到达 x,y 处的走法, 由于只能向右或者向下走, 所以 f(x,y) = f(x-1, y) + f(x, y-1).
 * 特殊情况, 当 x,y 位置为 1, 即有障碍, 则 f(x,y) = 0 表示永远不可达.
 * 所以可得状态转移方程.
 *
 * @author liuxin
 * @date 2020/7/6 22:33
 */
public class UniquePathsWithObstacles {

    private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int xLen = obstacleGrid.length, yLen = obstacleGrid[0].length;
        if (xLen == 0 || yLen == 0 || obstacleGrid[0][0] == 1) {
            return 0;
        }

        // 初始化
        obstacleGrid[0][0] = 1;

        int top, left;

        for (int x = 0; x < obstacleGrid.length; x++) {
            for (int y = 0; y < obstacleGrid[0].length; y++) {
                if (x == 0 && y == 0) {
                    continue;
                }

                if (obstacleGrid[x][y] == 1) {
                    obstacleGrid[x][y] = 0;
                    continue;
                }

                top = x - 1 >= 0 ? obstacleGrid[x - 1][y] : 0;
                left = y - 1 >= 0 ? obstacleGrid[x][y - 1] : 0;
                obstacleGrid[x][y] = top + left;
            }
        }

        return obstacleGrid[xLen - 1][yLen - 1];
    }

    public static void main(String[] args) {

    }

}
