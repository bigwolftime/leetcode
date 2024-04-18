package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 从双倍数组中还原原数组<br/>
 * <a href="https://leetcode.cn/problems/find-original-array-from-doubled-array/">...</a>
 *
 * 二分
 *
 * @author liuxin
 * @date 2024/4/18 21:39
 */
public class FindOriginalArray {

    private static int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0) {
            return new int[0];
        }

        List<Integer> list = new ArrayList<>();
        for (int i : changed) {
            list.add(i);
        }

        list.sort(Comparator.comparingInt(i -> i));

        int[] arr = new int[changed.length / 2];
        int idx = 0;

        while (!list.isEmpty()) {
            int target = list.get(0);

            int index = find(target * 2, list, 1, list.size() - 1);
            if (index == -1) {
                return new int[0];
            }

            arr[idx++] = target;

            list.remove(index);
            list.remove(0);
        }

        return arr;
    }

    private static int find(int target, List<Integer> list, int start, int end) {
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            Integer i = list.get(mid);

            if (i > target) {
                end = mid - 1;
            } else if (i < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }


    public static void main(String[] args) {

        findOriginalArray(new int[]{1, 3, 4, 2, 6, 8});

    }

}
