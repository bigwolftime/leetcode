package offer;

/**
 * @author liuxin
 * @date 2020/5/1 9:30
 *
 * 二维数组中的查找
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 *
 * like: https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 */
public class FindNumberIn2DArray {

    private static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int maxRow = matrix.length, maxCol = matrix[0].length;

        // 左下角
        int col = 0, row = matrix.length - 1;
        int temp;
        while (col >= 0 && row >= 0 && col < maxCol) {
            temp = matrix[row][col];
            if (temp == target) {
                return true;
            } else if (temp > target) {
                row--;
            } else {
                col++;
            }
        }

        // 非正方形情况
        if (maxRow < maxCol) {
            int newRow = Math.max(row, 0);
            col = maxCol - 1;
            while (col < maxCol) {
                if (matrix[newRow][col] == target) {
                    return true;
                }
                col++;
            }
        } else if (maxCol < maxRow) {
            row = maxRow - 1;

            if (col >= maxCol) {
                col--;
            }
            int newCol = Math.max(col, 0);
            while (row < maxRow) {
                if (matrix[row][newCol] == target) {
                    return true;
                }
                row++;
            }
        }

        return false;
    }

    public static void main(String[] args) {

    }

}
