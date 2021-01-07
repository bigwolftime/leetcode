package leetcode;

import java.util.Arrays;

/**
 * 拼车
 * https://leetcode-cn.com/problems/car-pooling/
 *
 * 左闭右开
 * 使用笨办法: 数组填充
 */
public class CarPooling {

    private static boolean carPooling(int[][] trips, int capacity) {
        // 排序
        final int[] max = {trips[0][2]};
        Arrays.sort(trips, (o1, o2) -> {
            max[0] = Math.max(max[0], o1[2]);
            max[0] = Math.max(max[0], o2[2]);

            int diff = o1[1] - o2[1];
            if (diff != 0) {
                return diff;
            }

            return o1[2] - o2[2];
        });

        int min = trips[0][1];
        int[] arr = new int[max[0] - min];

        int idx;
        for (int[] trip : trips) {
            int inc = trip[0];

            for (int i = trip[1]; i < trip[2]; i++) {
                idx = i - min;
                arr[idx] += inc;

                if (arr[idx] > capacity) {
                    return false;
                }
            }

        }

        return true;
    }

    public static void main(String[] args) {
        int[][] trips = new int[][]{
                { 9,3,4 },
                { 9,1,7 },
                { 4,2,4 },
                { 7,4,5 }
        };
        carPooling(trips, 23);
    }

}
