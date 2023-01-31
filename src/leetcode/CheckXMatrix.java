package leetcode;

/**
 * 判断矩阵是否是一个 X 矩阵
 * https://leetcode.cn/problems/check-if-matrix-is-x-matrix/
 *
 * @author liuxin
 * @date 2023/1/31 14:12
 */
public class CheckXMatrix {

    public static boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean diagonal = isDiagonal(i, j, n);
                int val = grid[i][j];

                if ((diagonal && val == 0) || (!diagonal && val != 0)) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * 判断是否对角线元素
     * @param x
     * @param y
     * @param n
     * @return
     */
    public static boolean isDiagonal(int x, int y, int n) {
        return x + y + 1 == n || x == y;
    }

    public static void main(String[] args) {

    }

}
