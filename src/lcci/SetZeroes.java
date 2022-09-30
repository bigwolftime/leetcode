package lcci;

import java.util.ArrayList;
import java.util.List;

/**
 * 零矩阵
 * https://leetcode.cn/problems/zero-matrix-lcci/
 *
 * @author liuxin
 * @date 2022/9/30 3:05 PM
 */
public class SetZeroes {

    public void setZeroes(int[][] matrix) {
        List<Integer> zeroPointList = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroPointList.add(i);
                    zeroPointList.add(j);
                }
            }
        }

        int i = 0;
        while (i < zeroPointList.size()) {
            setZeroByPoint(matrix, zeroPointList.get(i++), zeroPointList.get(i++));
        }
    }

    /**
     * 给一个数组和坐标，将其对应的行列置0
     * @param matrix
     * @param x
     * @param y
     */
    private static void setZeroByPoint(int[][] matrix, int x, int y) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[x][i] = 0;
        }
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][y] = 0;
        }
    }


    public static void main(String[] args) {

    }

}
