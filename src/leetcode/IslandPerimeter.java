package leetcode;

/**
 * 岛屿的周长
 * https://leetcode-cn.com/problems/island-perimeter/
 *
 * 从左上角开始, 如果为 1, 则 temp = 4. 如果右边为 1 则 temp -= 2; 下边为 1 则 temp -= 2
 *
 * @author liuxin
 * @time 2020/10/30 9:56
 */
public class IslandPerimeter {

    private static int islandPerimeter(int[][] grid) {
        int sum = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int temp;

                if (grid[i][j] == 0) {
                    continue;
                }

                temp = 4;

                if (i + 1 < grid.length && grid[i + 1][j] == 1) {
                    temp -= 2;
                }
                if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
                    temp -= 2;
                }

                sum += temp;
            }
        }

        return sum;
    }

    public static void main(String[] args) {

    }

}
