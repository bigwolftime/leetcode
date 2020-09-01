package leetcode;

/**
 * 统计有序矩阵中的负数
 * https://leetcode-cn.com/problems/count-negative-numbers-in-a-sorted-matrix/
 *
 * @author liuxin
 * @date 2020/9/1 17:50
 */
public class CountNegatives {

    private static int countNegatives(int[][] grid) {
        int count = 0;

        for (int[] arr : grid) {
            int j = 0;
            for (; j < arr.length; j++) {
                if (arr[j] < 0) {
                    break;
                }
            }

            count += (arr.length - j);
        }

        return count;
    }

    public static void main(String[] args) {
        int i = countNegatives(new int[][]{
                {4, 3, 2, -1},
                {3, 2, 1, -1},
                {1, 1, -1, -2},
                {-1, -1, -2, -3}
        });
        System.err.println(i);
    }

}
