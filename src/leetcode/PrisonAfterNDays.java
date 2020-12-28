package leetcode;

import java.util.Arrays;

/**
 * N 天后的牢房
 * https://leetcode-cn.com/problems/prison-cells-after-n-days/
 *
 * 如果一间牢房的两个相邻的房间都被占用或都是空的，那么该牢房就会被占用。
 * 否则，它就会被空置。
 *
 * 两边的始终为 0, 即未占用状态，因为左右没有房子
 *
 * 总状态数: 2 ^ 6 = 64  (左右只能为 0)
 *
 * 但是实测是 14 天一个周期.
 *
 * 1. 判断起始的 N 是否为 0，是则直接返回；
 * 2. N % 14，如果得到 0，则 N 需要重新赋值为 14
 *
 */
public class PrisonAfterNDays {

    /**
     * 占用
     */
    private static final int USED = 1;

    /**
     * 空闲
     */
    private static final int IDLE = 0;

    private static final int BASE_MOD = 14;


    private static int[] prisonAfterNDays(int[] cells, int N) {
        if (N == 0) {
            return cells;
        }

        int[] nextCell = new int[cells.length];

        N %= BASE_MOD;

        if (N == 0) {
            N = BASE_MOD;
        }

        while (N-- > 0) {
            for (int i = 1; i < cells.length - 1; i++) {
                boolean flag = (cells[i - 1] == IDLE && cells[i + 1] == IDLE) || (cells[i - 1] == USED && cells[i + 1] == USED);
                nextCell[i] = flag ? USED : IDLE;
            }

            cells = nextCell;
            nextCell = new int[cells.length];
        }

        return cells;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,0,0,1,0,0,0,1};

        int[] originArr = prisonAfterNDays(nums, 14);

        for (int i = 2; i < 827; i++) {
            int[] arr = prisonAfterNDays(nums, i);
            if (Arrays.equals(originArr, arr)) {
                System.err.println(i);
                // 14 天一周期
            }
        }
    }

}
