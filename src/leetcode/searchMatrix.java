package leetcode;

/**
 * 搜索二维矩阵
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 * <p>
 * 使用两次二分
 *
 * todo
 * @author liuxin
 * @time 2020/6/19 18:31
 */
public class searchMatrix {

    private static boolean searchMatrix(int[][] matrix, int target) {
        int start = 0, end = matrix.length - 1;
        int mid = 0;
        int temp;

        // 第一次二分 确定行数
        while (start + 1 < end) {
            mid = start + ((end - start) >> 1);
            temp = matrix[mid][0];

            if (temp > target) {
                end = mid;
            } else if (temp < target) {
                start = mid;
            } else {
                break;
            }
        }

        int row = start;
        start = 0;
        end = matrix[row].length - 1;

        // 第二次二分 寻找 target
        while (start + 1 < end) {
            mid = start + ((end - start) >> 1);
            temp = matrix[row][mid];

            if (temp > target) {
                end = mid;
            } else if (temp < target) {
                start = mid;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };

        searchMatrix(matrix, 3);
    }

}
