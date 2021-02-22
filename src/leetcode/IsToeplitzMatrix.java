package leetcode;

/**
 * 拖普力茨矩阵
 * https://leetcode-cn.com/problems/toeplitz-matrix/
 */
public class IsToeplitzMatrix {

    private static int M, N;

    private static boolean isToeplitzMatrix(int[][] matrix) {
        M = matrix.length;
        N = matrix[0].length;

        for (int i = M - 1; i >= 0; i--) {
            int tempI = i;
            int k = 0;
            int original = matrix[tempI][k];

            tempI++;
            k++;
            while (isInRange(tempI, k)) {
                if (matrix[tempI][k] != original) {
                    return false;
                }

                tempI++;
                k++;
            }
        }

        for (int i = 1; i < N - 1; i++) {
            int tempI = i;
            int k = 0;
            int original = matrix[k][tempI];

            tempI++;
            k++;
            while (isInRange(k, tempI)) {
                if (matrix[k][tempI] != original) {
                    return false;
                }

                tempI++;
                k++;
            }
        }

        return true;
    }

    private static boolean isInRange(int x, int y) {
        return x >= 0 && x < M && y >= 0 && y < N;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                { 1,2,3,4 },
                { 5,1,2,3 },
                { 9,5,1,2 }
        };

        isToeplitzMatrix(matrix);
    }

}
