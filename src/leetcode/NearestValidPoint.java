package leetcode;

/**
 * 找到最近的有相同 X 或 Y 的坐标点
 * https://leetcode.cn/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/
 *
 * @author liuxin
 * @date 2022/12/1 2:28 PM
 */
public class NearestValidPoint {

    private static int nearestValidPoint(int x, int y, int[][] points) {
        int minLen = Integer.MAX_VALUE;
        int idx = -1;
        
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            if (isValid(x, y, point)) {

                int distance = calcDistance(x, y, point);
                if (distance < minLen) {
                    minLen = distance;
                    idx = i;
                }
            }
        }

        return idx;
    }


    private static boolean isValid(int x, int y, int[] point) {
        return x == point[0] || y == point[1];
    }

    private static int calcDistance(int x, int y, int[] point) {
        return Math.abs(x - point[0]) + Math.abs(y - point[1]);
    }


    public static void main(String[] args) {

    }

}
