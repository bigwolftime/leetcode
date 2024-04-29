package leetcode;

/**
 * 将矩阵按对角线排序<br/>
 * <a href="https://leetcode.cn/problems/sort-the-matrix-diagonally">...</a>
 *
 * @author liuxin
 * @date 2024/4/29 09:51
 */
public class DiagonalSort {

    private static int[][] diagonalSort(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            sort(mat, i, 0);
        }
        for (int j = 1; j < mat[0].length; j++) {
            sort(mat, 0, j);
        }


        return mat;
    }

    private static void sort(int[][] mat, int i, int j) {
        for (int startI = i, startJ = j; startI < mat.length && startJ < mat[0].length; startI++, startJ++) {
            int val = mat[startI][startJ];
            int nextI = startI + 1;
            int nextJ = startJ + 1;
            while (nextI < mat.length && nextJ < mat[0].length) {
                int nextVal = mat[nextI][nextJ];
                if (val > nextVal) {
                    swap(mat, startI, startJ, nextI, nextJ);
                    val = nextVal;
                }
                nextI++;
                nextJ++;
            }
        }
    }

    private static void swap(int[][] mat, int i1, int j1, int i2, int j2) {
        int swap = mat[i1][j1];
        mat[i1][j1] = mat[i2][j2];
        mat[i2][j2] = swap;
    }


    public static void main(String[] args) {
        // [3,3,1,1],[2,2,1,2],[1,1,1,2]
        int[][] mat = new int[][]{
                {3,3,1,1},
                {2,2,1,2},
                {1,1,1,2}
        };
        diagonalSort(mat);
    }

}
