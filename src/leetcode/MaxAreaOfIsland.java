package leetcode;

/**
 * 岛屿的最大面积
 * https://leetcode-cn.com/problems/max-area-of-island/
 *
 * 回溯 + 剪枝 + 染色
 *
 * @author liuxin
 * @time 2020/10/14 18:22
 */
public class MaxAreaOfIsland {

    private static final int TRAVEL_COLOR = -1;
    private static int CUR_AREA;

    private static int maxAreaOfIsland(int[][] grid) {
        int MAX_AREA = 0;

        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                CUR_AREA = 0;
                dfs(grid, x, y);
                MAX_AREA = Math.max(CUR_AREA, MAX_AREA);
            }
        }

        return MAX_AREA;
    }

    private static void dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            // 坐标溢出 -> 结束
            return;
        }

        int num = grid[x][y];
        if (num == TRAVEL_COLOR) {
            // 已被遍历到 -> 结束
            return;
        }

        if (num == 0) {
            // 数据不符 -> 结束
            return;
        }

        // 1
        CUR_AREA++;
        grid[x][y] = TRAVEL_COLOR;

        dfs(grid, x - 1, y);
        dfs(grid, x + 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
    }

    public static void main(String[] args) {

    }

}
