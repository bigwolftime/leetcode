package leetcode;

import java.util.Arrays;

/**
 * 使数组唯一的最小增量
 * https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique/
 *
 * 排序
 */
public class MinIncrementForUnique {

    private static int minIncrementForUnique(int[] A) {
        Arrays.sort(A);

        int count = 0;

        for (int i = 1; i < A.length; i++) {
            int incrVal = A[i] - A[i - 1];
            if (incrVal > 0) {
                continue;
            }

            incrVal = -incrVal + 1;
            A[i] += incrVal;
            count += incrVal;
        }

        return count;
    }


    public static void main(String[] args) {

    }

}
