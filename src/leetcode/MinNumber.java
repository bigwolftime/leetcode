package leetcode;

import java.util.Arrays;

/**
 * 从两个数字数组里生成最小数字
 * https://leetcode.cn/problems/form-smallest-number-from-two-digit
 *
 * 两个数组里是否有共同的元素, 有则返回最小的;
 * 没有则从两数组各取一个最小元素, 组成两位数字
 *
 * @author liuxin
 * @date 2023/9/5 19:30
 */
public class MinNumber {

    private static int minNumber(int[] nums1, int[] nums2) {
        int minVal1 = Integer.MAX_VALUE, minVal2 = Integer.MAX_VALUE;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int p = 0, q = 0;
        // 两数组共有元素的最小值, 无共有元素则为初始值
        int minSameValue = Integer.MAX_VALUE;
        while (p < nums1.length && q < nums2.length) {
            int val1 = nums1[p];
            int val2 = nums2[q];

            if (val1 < val2) {
                p++;
            } else if (val1 > val2) {
                q++;
            } else {
                minSameValue = Math.min(minSameValue, nums1[p]);
                p++;
                q++;
            }

            minVal1 = Math.min(minVal1, val1);
            minVal2 = Math.min(minVal2, val2);
        }

        // 循环结束, 如果 minSameValue 还是初始值, 也不用管了
        // 继续维护 minVal1, minVal2
        while (p < nums1.length) {
            minVal1 = Math.min(minVal1, nums1[p]);
            p++;
        }
        while (q < nums2.length) {
            minVal2 = Math.min(minVal2, nums2[q]);
            q++;
        }

        if (minSameValue != Integer.MAX_VALUE) {
            return minSameValue;
        }
        if (minVal1 <= minVal2) {
            return minVal1 * 10 + minVal2;
        } else {
            return minVal2 * 10 + minVal1;
        }
    }


    public static void main(String[] args) {

    }

}
