package lcci;

/**
 * 排序矩阵查找
 * https://leetcode-cn.com/problems/sorted-matrix-search-lcci/
 *
 * 左下角 -> 右上角
 */
public class SearchMatrix {

    private static boolean searchMatrix(int[][] matrix, int target) {
        int x = matrix.length - 1, y = 0;
        int num;

        while (x >= 0 && x < matrix.length && y >=0 && y < matrix[0].length) {
            num = matrix[x][y];

            if (target < num) {
                x--;
            } else if (target > num) {
                y++;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

    }

}
