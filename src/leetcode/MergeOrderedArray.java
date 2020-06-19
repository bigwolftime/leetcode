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


    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};

        merge(nums1, 3, nums2, 3);
    }
}
