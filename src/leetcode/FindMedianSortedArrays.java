package leetcode;

import java.util.ArrayList;

/**
 * 寻找两个有序数组的中位数
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 *
 * 时间复杂度要求：O(log(m + n))
 * 目前能想到的最简单的办法：将其遍历一遍，时间复杂度 O(m + n)
 *
 * @author Liuxin
 * @since 2019/8/16 17:27
 */
public class FindMedianSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> res = new ArrayList<>(nums1.length + nums2.length);
        int p = 0, q = 0;
        while (p < nums1.length && q < nums2.length) {
            if (nums1[p] < nums2[q]) {
                res.add(nums1[p]);
                p++;
            } else {
                res.add(nums2[q]);
                q++;
            }
        }

        while (p < nums1.length) {
            res.add(nums1[p++]);
        }
        while ((q < nums2.length)) {
            res.add(nums2[q++]);
        }

        int mid = res.size() / 2;
        if (res.size() % 2 == 0) {
            return (res.get(mid) + res.get(mid - 1)) / 2.0;
        }else {
            return res.get(mid);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        double res = findMedianSortedArrays(nums1, nums2);
        System.err.println(res);
    }
}
