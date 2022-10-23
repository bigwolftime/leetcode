package leetcode;

/**
 * 玩筹码
 * https://leetcode.cn/problems/minimum-cost-to-move-chips-to-the-same-position/
 *
 * 数组元素的含义是：筹码所在的位置索引，并非筹码数量
 * 本质上是计算 奇/偶 位置的筹码数量
 *
 * @author liuxin
 * @date 2022/7/8 9:11 PM
 */
public class MinCostToMoveChips {

    private static int minCostToMoveChips(int[] position) {
        int oddCnt = 0, evenCnt = 0;

        for (int pos : position) {
            if ((pos & 1) == 0) {
                // even
                evenCnt++;
            } else {
                oddCnt++;
            }
        }

        return Math.min(oddCnt, evenCnt);
    }

    public static void main(String[] args) {

    }

}
