package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 优势洗牌
 * https://leetcode.cn/problems/advantage-shuffle/
 *
 * 田忌赛马思路
 *
 * @author liuxin
 * @date 2022/10/8 11:04
 */
public class AdvantageCount {

    private static int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);

        List<Integer> list = new ArrayList<>(nums1.length);
        for (int i : nums1) {
            list.add(i);
        }

        int p = 0;
        while (p < nums2.length) {

            // 二分查找 > target 的索引
            int i = binarySearchWithGtTarget(list, nums2[p]);
            Integer remove = list.remove(i == -1 ? 0 : i);
            nums1[p] = remove;
            p++;
        }

        return nums1;
    }

    /**
     * 二分查找 变种
     * @param list
     * @param target
     * @return
     */
    private static int binarySearchWithGtTarget(List<Integer> list, int target) {
        int p = 0, q = list.size() - 1;
        int mid;

        while (p < q) {
            mid = p + ((q - p) >> 1);
            if (list.get(mid) > target) {
                q = mid - 1;
            } else if (list.get(mid) <= target) {
                p = mid + 1;
            }
        }

        /*
         * q < p
         */

        // 向右遍历, 找第一个 > target 索引
        while (q < list.size()) {
            if (q >= 0 && list.get(q) > target) {
                return q;
            }
            q++;
        }

        return -1;
    }


    public static void main(String[] args) {
        // [5621,1743,5532,3549,9581]
        // [913,9787,4121,5039,1481]
        int[] nums1 = new int[]{ 5621,1743,5532,3549,9581 };
        int[] nums2 = new int[]{913,9787,4121,5039,1481 };
        int[] ints = advantageCount(nums1, nums2);
        System.err.println("");
    }

}
