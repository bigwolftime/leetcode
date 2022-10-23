package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 最小绝对差
 * https://leetcode.cn/problems/minimum-absolute-difference/
 *
 * @author liuxin
 * @date 2022/7/4 10:07 PM
 */
public class MinimumAbsDifference {

    private static int MIN_STEP;

    private static List<List<Integer>> minimumAbsDifference(int[] arr) {
        MIN_STEP = Integer.MAX_VALUE;

        Arrays.sort(arr);

        List<List<Integer>> list = new ArrayList<>();
        int i = 0;
        while (++i < arr.length) {
            int diff = arr[i] - arr[i - 1];

            if (diff > MIN_STEP) {
                continue;
            }

            if (diff < MIN_STEP) {
                MIN_STEP = diff;
                list = new ArrayList<>();
            }

            List<Integer> subList = new ArrayList<>();
            subList.add(arr[i - 1]);
            subList.add(arr[i]);

            list.add(subList);
        }

        return list;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{ 7,5,1,3,9,8,6,2,4,0 };

        // bubbleSort(arr);

        minimumAbsDifference(arr);

        System.err.println("");
    }

}
