package lcp;

/**
 * 宝石补给
 * https://leetcode.cn/problems/WHnhjV
 *
 * @author liuxin
 * @date 2023/9/15 14:41
 */
public class GiveGem {

    private static int giveGem(int[] gem, int[][] operations) {
        for (int[] operation : operations) {
            int idx1 = operation[0];
            int idx2 = operation[1];

            int val = Math.floorDiv(gem[idx1], 2);
            gem[idx1] -= val;
            gem[idx2] += val;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // 找到最值
        for (int i : gem) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        return max - min;
    }

    public static void main(String[] args) {
        /**
         * gem =
         * [100,0,50,100]
         * operations =
         * [[0,2],[0,1],[3,0],[3,0]]
         */
        int[] gem = new int[]{ 100,0,50,100 };
        int[][] operations = new int[][]{
                { 0,2 },
                { 0,1 },
                { 3,0 },
                { 3,0 }
        };

        giveGem(gem, operations);
    }

}
