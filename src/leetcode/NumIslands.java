package leetcode;

/**
 * 岛屿数量
 * https://leetcode-cn.com/problems/number-of-islands/
 *
 * dfs + 染色
 */
public class NumIslands {

    private static final char POLLUTE = 'x';


    private static int numIslands(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                char cur = grid[i][j];
                if (cur == '1') {
                    count++;
                }

                dfs(grid, i, j);
            }
        }

        return count;
    }


    private static void dfs(char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            // Out bound
            return;
        }

        if (grid[x][y] == POLLUTE || grid[x][y] == '0') {
            // 已遍历过 || 非岛屿
            return;
        }

        // grid[x][y] = 1

        grid[x][y] = POLLUTE;

        // 向右
        dfs(grid, x, y + 1);
        // 向下
        dfs(grid, x + 1, y);
        // 向上
        dfs(grid, x - 1, y);
        // 向左
        dfs(grid, x, y - 1);
    }



    public static void main(String[] args) {
        char[][] grid = new char[][]{
                { '1', '1', '1' },
                { '0', '1', '0' },
                { '1', '1', '1' }
        };


        System.err.println(numIslands(grid));;
    }

}
