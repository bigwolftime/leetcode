package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 矩阵置零
 * https://leetcode-cn.com/problems/set-matrix-zeroes/
 *
 * 想用染色的思路, 不过数组元素可能为任何值.
 *
 * @author liuxin
 * @time 2020/6/17 16:18
 */
public class SetZeroes {

    private static void setZeroes(int[][] matrix) {
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
        int[][] matrix = new int[][]{
                { 2,3,7,0 },
                { 0,5,8,1 },
                { 1,4,2,0 }
        };

        setZeroByPoint(matrix, 0,1);

        System.err.println("");
    }

}
