package leetcode;

/**
 * 矩阵中移动的最大次数
 * <a href="https://leetcode.cn/problems/maximum-number-of-moves-in-a-grid">...</a>
 * <br/>
 * 今天算是入了 dp 的门槛了.
 * <br/>
 * 如何推导出 dp 做法呢?<br/>
 * 首先退一步想: 如果不用 dp 的做法, 那么可能需要一个 set 来记录遍历过的 (x,y) 坐标, 否则必然会重复计算, 那 set 里的值怎么来的呢? 可以用
 * "-" 将 x, y 拼接得到一个字符串, 遍历前先判断坐标 x-y 是否在 set 里, 若在则说明已遍历过, 忽略即可, 若不在则继续走, 同时将 x-y 填进 set;
 * 此外, 再定义一个 maxStep, 表示可以走的最大步数.<br/>
 * 想到这其实就差不多了, 我们要做的其实就是将 set 改成二维的 dp 数组来存储, 这样就能省略拼接 x-y 了, 而 dp 的值可以存储最大步数, 一举两得.
 * 剩下的就是完善思路: 对于当前坐标 (x,y), 其前一步可能来自左(x, y-1), 左上(x-1, y-1), 左下(x+1, y-1)三个方向, 在 dp 数组中找出这三个
 * 坐标的最大值, 在此基础上加1即可, 此外需要考虑边界以及是否可达(即: preX preY 不越界且 grid[preX][preY] < grid[x][y]).
 *
 * @author liuxin
 * @date 2024/3/16 18:07
 */
public class MaxMoves {

    private static int maxMoves(int[][] grid) {
        int resMaxStep = 0;
        int[][] dp = new int[grid.length][grid[0].length];

        for (int y = 1; y < grid[0].length; y++) {
            for (int x = 0; x < grid.length; x++) {

                int maxStep = 0;
                int preX, preY;

                // left
                preX = x;
                preY = y - 1;
                maxStep = Math.max(calcMaxStep(grid, dp, preX, preY, x, y), maxStep);

                // left top
                preX = x - 1;
                preY = y - 1;
                maxStep = Math.max(calcMaxStep(grid, dp, preX, preY, x, y), maxStep);

                // left bottom
                preX = x + 1;
                preY = y - 1;
                maxStep = Math.max(calcMaxStep(grid, dp, preX, preY, x, y), maxStep);

                dp[x][y] = maxStep;
                resMaxStep = Math.max(resMaxStep, maxStep);
            }
        }

        return resMaxStep;
    }

    private static int calcMaxStep(int[][] grid, int[][] dp, int preX, int preY, int x, int y) {
        if (isOverSize(preX, preY, grid) || isOverSize(x, y, grid) || grid[x][y] <= grid[preX][preY]) {
            // oversize or noway
            return 0;
        } else {
            // calc maxStep
            int preMaxStep = dp[preX][preY];
            if (preMaxStep == 0 && preY != 0) {
                // noway to this point
                return 0;
            }

            return preMaxStep + 1;
        }
    }

    private static boolean isOverSize(int x, int y, int[][] grid) {
        return x < 0 || y < 0 || x >= grid.length || y >= grid[0].length;
    }


    public static void main(String[] args) {

        int[][] grid = new int[][] {
                { 3,2,4 },
                { 2,1,9 },
                { 1,1,7 },
        };

        int i = maxMoves(grid);
        System.err.println(i);
    }

}
