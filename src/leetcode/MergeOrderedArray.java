package leetcode;

/**
 * 合并两个有序数组
 * https://leetcode-cn.com/problems/merge-sorted-array/
 *
 * @author bwt
 *
 * 思路：(双指针法)题目描述下面有一个提示：What if you fill the longer array from the end instead of start ?
 * 即从后向前比较，如果从前向后比较的话要涉及到元素的移动，比较麻烦。
 */
public class MergeOrderedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //最后一个元素的下标
        int end = m + n - 1;

        int p = m - 1, q = n - 1;

        while (p >= 0 && q >= 0){
            if (nums1[p] <= nums2[q]){
                nums1[end] = nums2[q];
                q--;
            }else {
                nums1[end] = nums1[p];
                p--;
            }

            end--;
        }

        while (p >= 0){
            nums1[end] = nums1[p];
            end--;
            p--;
        }
        while (q >= 0){
            nums1[end] = nums2[q];
            end--;
            q--;
        }
    }


    /**
     * 逆向双指针
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }

        int p = m - 1;
        int q = n - 1;
        int curIdx = m + n - 1;

        while (p >= 0 && q >= 0) {
            int val1 = nums1[p];
            int val2 = nums2[q];

            if (val1 > val2) {
                nums1[curIdx] = val1;
                p--;
            } else if (val1 < val2) {
                nums1[curIdx] = val2;
                q--;
            } else {
                // 两个值相等，取其中一个
                nums1[curIdx] = val1;
                p--;
            }

            curIdx--;
        }

        while (p >= 0) {
            nums1[curIdx] = nums1[p];
            p--;
            curIdx--;
        }
        while (q >= 0) {
            nums1[curIdx] = nums2[q];
            q--;
            curIdx--;
        }
    }



    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};

        merge(nums1, 3, nums2, 3);


        int[] nums3 = new int[]{0};
        int[] nums4 = new int[]{1};
        merge2(nums3, 0, nums4, 1);
    }
}
