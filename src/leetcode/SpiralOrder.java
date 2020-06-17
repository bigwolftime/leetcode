package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 * https://leetcode-cn.com/problems/spiral-matrix/
 *
 * @author liuxin
 * @time 2020/6/5 18:18
 */
public class SpiralOrder {

    private static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }

        int minX = 0, minY = 0;
        int maxX = matrix.length - 1, maxY = matrix[0].length - 1;

        while (minX < maxX && minY < maxY) {
            // 右向 遍历
            for (int y = minY; y <= maxY; y++) {
                list.add(matrix[minX][y]);
            }
            minX++;

            // 下向 遍历
            for (int x = minX; x <= maxX; x++) {
                list.add(matrix[x][maxY]);
            }
            maxY--;

            // 左向 遍历
            for (int y = maxY; y >= minY; y--) {
                list.add(matrix[maxX][y]);
            }
            maxX--;

            for (int x = maxX; x >= minX; x--) {
                list.add(matrix[x][minY]);
            }
            minY++;
        }


        if (minX < maxX && minY <= maxY) {
            for (int x = minX; x <= maxX; x++) {
                list.add(matrix[x][minY]);
            }
        } else if (minX <= maxX) {
            for (int y = minY; y <= maxY; y++) {
                list.add(matrix[minX][y]);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                { 1,2,3 },
                {4,5,6}
        };
        spiralOrder(matrix);
    }

}
