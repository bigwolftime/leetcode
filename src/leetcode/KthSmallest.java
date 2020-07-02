package leetcode;

import java.util.Arrays;

/**
 * 有序矩阵中第 K 小的元素
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
 *
 * 1. 把 matrix copy 到新数组 arr, 对新数组 arr 排序, 返回第 k - 1 个; 10ms
 * 2. mid = (matrix[0][0] + matrix[n-1][n-1]) >> 1, 然后计算出 <= midVal 的数量 lessCount(左下角起始遍历);
 *      1). 如果 k <= lessCount, 则范围在 [matrix[0][0], midVal];
 *      2). 否则范围在 [midVal, matrix[n-1][n-1]] 之间, 寻找第 k - lessCount 小的数字
 *    对范围内的数组筛选并排序.
 *    5ms
 *
 * @author liuxin
 * @time 2020/7/2 9:51
 */
public class KthSmallest {

    private static int kthSmallest(int[][] matrix, int k) {
        int len = matrix.length;

        int midVal = (matrix[0][0] + matrix[len - 1][len - 1]) >> 1;
        int lessCount = len * len;

        int x = len - 1, y = 0;
        while (x >= 0 && y < len) {
            if (matrix[x][y] <= midVal) {
                y++;
            } else {
                x--;
                lessCount -= (len - y);
            }
        }

        boolean flag = k > lessCount;
        int[] arr = new int[flag ? len * len - lessCount : lessCount];

        copyMatrix(arr, midVal, flag, matrix);
        Arrays.sort(arr);

        return flag ? arr[k - lessCount - 1] : arr[k - 1];

        // 1. copy 到一维数组后重排序
        /*int[] arr = new int[matrix.length * matrix[0].length];
        int idx = 0;
        for (int[] ints : matrix) {
            for (int x : ints) {
                arr[idx++] = x;
            }
        }

        Arrays.sort(arr);
        return arr[k - 1];*/
    }

    private static void copyMatrix(int[] arr, int midVal, boolean flag, int[][] matrix) {
        int idx = 0;
        for (int[] ints : matrix) {
            for (int x : ints) {
                if (flag && x > midVal) {
                    arr[idx++] = x;
                } else if (!flag && x <= midVal) {
                    arr[idx++] = x;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1,3,5,7,9},
                {2,4,6,8,10},
                {11,13,15,17,19},
                {12,14,16,18,20},
                {21,23,25,27,29}
        };

        int i = kthSmallest(matrix, 20);
        System.err.println(i);
    }

}
