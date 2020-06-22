package leetcode;

/**
 * 螺旋矩阵II
 * https://leetcode-cn.com/problems/spiral-matrix-ii/
 *
 * 正方形矩阵
 *
 * @author liuxin
 * @time 2020/6/22 19:01
 */
public class GenerateMatrix {

    private static int[][] generateMatrix(int n) {
        int minX = 0, maxX = n - 1;
        int minY = 0, maxY = n - 1;
        int num = 1;

        int[][] matrix = new int[n][n];
        int x = minX, y = minY;

        while (minX <= maxX && minY <= maxY) {
            for (; y < maxY; y++) {
                matrix[x][y] = num++;
            }
            minX++;

            for (; x < maxX; x++) {
                matrix[x][y] = num++;
            }
            maxY--;

            for (; y > minY; y--) {
                matrix[x][y] = num++;
            }
            maxX--;

            for (; x > minX; x--) {
                matrix[x][y] = num++;
            }
            minY++;
        }

        matrix[x][y] = num;
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = generateMatrix(4);

        System.err.println();
        for (int[] arr : matrix) {
            for (int i : arr) {
                System.err.print(i + " ");
            }
            System.err.println();
        }
    }

}
