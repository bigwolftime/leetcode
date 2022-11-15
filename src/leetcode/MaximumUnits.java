package leetcode;

import java.util.Arrays;

/**
 * 卡车上的最大单元数
 * https://leetcode.cn/problems/maximum-units-on-a-truck/
 *
 * @author liuxin
 * @date 2022/11/15 1:48 PM
 */
public class MaximumUnits {

    private static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (o1, o2) -> o2[1] - o1[1]);

        int max = 0;
        for (int[] boxType : boxTypes) {
            if (boxType[0] <= truckSize) {
                truckSize -= boxType[0];
                max += (boxType[0] * boxType[1]);
            } else {
                max += (truckSize * boxType[1]);
                break;
            }
        }

        return max;
    }


    public static void main(String[] args) {
        int i = maximumUnits(new int[][]{
                {1, 3}, {2, 2}, {3, 1}
        }, 4);
        System.err.println(i);
    }

}
