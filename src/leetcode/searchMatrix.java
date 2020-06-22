package leetcode;

/**
 * 搜索二维矩阵
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 * <p>
 * 使用两次二分 或者 从左下角搜索
 *
 * @author liuxin
 * @time 2020/6/19 18:31
 */
public class searchMatrix {

    private static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        // 从左下角搜索
        int x = matrix.length - 1, y = 0;

        while (x >= 0) {
            if (matrix[x][y] < target) {
                break;
            } else if (matrix[x][y] == target) {
                return true;
            }
            x--;
        }

        while (y < matrix[0].length && x >= 0) {
            if (matrix[x][y] < target) {
                y++;
            } else {
                return matrix[x][y] <= target;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {}
        };

        System.err.println(searchMatrix(matrix, 1));;
    }

}
