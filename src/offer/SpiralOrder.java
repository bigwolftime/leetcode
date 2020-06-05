package offer;

/**
 * @author liuxin
 * @time 2020/6/5 19:37
 */
public class SpiralOrder {

    private static int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int minX = 0, minY = 0;
        int maxX = matrix.length, maxY = matrix[0].length;
        int[] res = new int[maxX * maxY];

        maxX--;
        maxY--;
        int count = 0;

        while (minX < maxX && minY < maxY) {
            // 右向 遍历
            for (int y = minY; y <= maxY; y++) {
                res[count++] = matrix[minX][y];
            }
            minX++;

            // 下向 遍历
            for (int x = minX; x <= maxX; x++) {
                res[count++] = matrix[x][maxY];
            }
            maxY--;

            // 左向 遍历
            for (int y = maxY; y >= minY; y--) {
                res[count++] = matrix[maxX][y];
            }
            maxX--;

            for (int x = maxX; x >= minX; x--) {
                res[count++] = matrix[x][minY];
            }
            minY++;
        }


        if (minX < maxX && minY <= maxY) {
            for (int x = minX; x <= maxX; x++) {
                res[count++] = matrix[x][minY];
            }
        } else if (minX <= maxX) {
            for (int y = minY; y <= maxY; y++) {
                res[count++] = matrix[minX][y];
            }
        }

        return res;
    }

    public static void main(String[] args) {

    }

}
