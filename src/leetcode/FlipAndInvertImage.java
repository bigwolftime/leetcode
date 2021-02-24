package leetcode;

/**
 * 翻转图片
 * https://leetcode-cn.com/problems/flipping-an-image/
 */
public class FlipAndInvertImage {

    private static int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {

            int p = 0, q = A[i].length - 1;
            while (p < q) {
                swap(A, i, p, i, q);
                p++;
                q--;
            }
        }

        for (int i = 0; i < A.length; i++) {

            for (int j = 0; j < A[i].length; j++) {
                A[i][j] ^= 1;
            }
        }

        return A;
    }

    private static void swap(int[][] A, int i1, int j1, int i2, int j2) {
        int temp = A[i1][j1];
        A[i1][j1] = A[i2][j2];
        A[i2][j2] = temp;
    }


    public static void main(String[] args) {

    }

}
