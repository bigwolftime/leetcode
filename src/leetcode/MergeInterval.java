package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 * https://leetcode-cn.com/problems/merge-intervals/
 *
 * 取并集
 *
 * @author liuxin
 * @time 2020/6/19 9:56
 */
public class MergeInterval {

    private static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }

        // 按照区间最小值进行排序
        // input: [1,2] [5,8] [3,4] -> [1,2] [3,4] [5,8]
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));

        List<int[]> resList = new ArrayList<>();

        int min = intervals[0][0], max = intervals[0][1];
        int curMin, curMax;
        int[] arr;
        for (int i = 1; i < intervals.length; i++) {
            arr = intervals[i];

            curMin = arr[0];
            curMax = arr[1];

            if (curMin <= max) {
                if (curMax > max) {
                    // 可以合并区间
                    max = curMax;
                }
            } else {
                // 不符合区间合并条件
                resList.add(new int[]{ min, max });

                min = curMin;
                max = curMax;
            }
        }

        resList.add(new int[]{ min, max });

        int[][] resArr = new int[resList.size()][];
        return resList.toArray(resArr);
    }


    public static void main(String[] args) {
        int[][] intervals = new int[][] {
                { 1,4 },
                {2,3}
        };
        int[][] merge = merge(intervals);

        for (int[] arr : merge) {
            for (int i : arr) {
                System.err.print(i + " ");
            }
            System.err.println();
        }
    }

}

/**
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */
