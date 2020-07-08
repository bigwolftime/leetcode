package lcci;

/**
 * 跳水板
 * https://leetcode-cn.com/problems/diving-board-lcci/
 *
 * @author liuxin
 * @time 2020/7/8 9:48
 */
public class DivingBoard {

    private static int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (shorter == longer) {
            return new int[]{ k * shorter };
        }

        int[] arr = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            arr[i] = longer * i + shorter * (k - i);
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] ints = divingBoard(1, 2, 3);

        for (int i : ints) {
            System.err.println(i);
        }
    }

}
