package leetcode;

/**
 * 地下城游戏
 * https://leetcode-cn.com/problems/dungeon-game/
 *
 * 开始的思路是从左上角到右下角动态规划, 但是发现不是那么一回事...
 * 为了处理路径和的问题, 可以从右下角到左上角搜索...
 * 真是固步自封了...
 *
 * @author liuxin
 * @date 2020/7/12 20:53
 */
public class CalculateMinimumHP {

    private static int calculateMinimumHP(int[][] dungeon) {
        int curSum;
        for (int x = dungeon.length - 1; x >= 0; x--) {
            for (int y = dungeon[0].length - 1; y >= 0 ; y--) {
                if (x == dungeon.length - 1 && y == dungeon[0].length - 1) {
                    curSum = Math.min(dungeon[x][y], 0);
                } else if (x == dungeon.length - 1) {
                    curSum = dungeon[x][y + 1] + dungeon[x][y];
                } else if (y == dungeon[0].length - 1) {
                    curSum = dungeon[x + 1][y] + dungeon[x][y];
                } else {
                    curSum = Math.max(dungeon[x][y + 1], dungeon[x + 1][y]) + dungeon[x][y];
                }

                dungeon[x][y] = Math.min(curSum, 0);
            }
        }

        return Math.abs(dungeon[0][0]) + 1;
    }

    public static void main(String[] args) {
        int i = calculateMinimumHP(new int[][]{
                {100}
        });
        System.err.println(i);
    }

}
