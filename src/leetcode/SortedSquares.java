package leetcode;

import java.util.Arrays;

/**
 * 有序数组的平方
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 *
 * @author liuxin
 * @time 2020/10/16 10:49
 */
public class SortedSquares {

    private static int[] sortedSquares(int[] A) {
        int[] arr = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            arr[i] = A[i] * A[i];
        }

        Arrays.sort(arr);

        return arr;
    }

    public static void main(String[] args) {

    }

}
