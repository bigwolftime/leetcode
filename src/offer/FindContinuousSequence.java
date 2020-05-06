package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 和为 s 的连续正数序列
 * https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 */
public class FindContinuousSequence {

    private static int[][] findContinuousSequence(int target) {
        int i = 1, j;
        int count;
        List<Integer> list = new ArrayList<>();

        while (i < (target / 2 + 1)) {
            count = i;
            j = i + 1;
            while ((count = count + j) < target) {
                j++;
            }

            if (count == target) {
                list.add(i);
                list.add(j);
            }

            i++;
        }

        int[][] res = new int[list.size() >> 1][];
        int start, end;
        int index;
        int allIndex = 0;

        for (int k = 0; k < list.size(); k += 2) {
            start = list.get(k);
            end = list.get(k + 1);
            index = 0;

            int[] arr = new int[end - start + 1];
            while (start <= end) {
                arr[index++] = start++;
            }

            res[allIndex] = arr;
            allIndex++;
        }

        return res;
    }

    public static void main(String[] args) {
        findContinuousSequence(9);
    }

}
