package leetcode;

/**
 * 旋转图像
 * https://leetcode-cn.com/problems/rotate-image/
 *
 * @author liuxin
 * @time 2020/6/8 16:19
 */
public class Rotate90 {

    private static void rotate(int[][] matrix) {
        int minX = 0, minY = 0;
        int maxX = matrix.length - 1, maxY = matrix[0].length - 1;
        int step, temp;
        int count;

        while (minX < maxX) {
            step = maxY - minY;
            count = 0;

            while (step > 0) {
                temp = matrix[minX][minY + count];
                matrix[minX][minY + count] = matrix[maxX - count][minY];
                matrix[maxX - count][minY] = matrix[maxX][maxY - count];
                matrix[maxX][maxY - count] = matrix[minX + count][maxY];
                matrix[minX + count][maxY] = temp;

                step--;
                count++;
            }

            minX++;
            maxX--;
            minY++;
            maxY--;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                { 1,2,3,4 },
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };


        rotate(matrix);


        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.err.print(matrix[i][j] + " ");
            }
            System.err.println();
        }


    }

}
