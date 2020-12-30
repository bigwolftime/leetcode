package leetcode;


import java.util.Arrays;

/**
 * 最后一块石头的重量
 * https://leetcode-cn.com/problems/last-stone-weight/
 */
public class LastStoneWeight {

    private static int lastStoneWeight(int[] stones) {
        int len = stones.length;

        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return stones[0];
        }

        while (true) {
            Arrays.sort(stones);

            int p = len - 2, q = len - 1;
            int x = stones[p], y = stones[q];

            if (x == 0 && y == 0) {
                return 0;
            } else if (x == 0) {
                return y;
            } else if (y == 0) {
                return x;
            }

            if (x < y) {
                stones[p] = 0;
                stones[q] -= x;
            } else if (stones[p] > stones[q]) {
                stones[q] = 0;
                stones[p] -= y;
            } else {
                stones[p] = 0;
                stones[q] = 0;
            }
        }
    }

    public static void main(String[] args) {

    }

}
