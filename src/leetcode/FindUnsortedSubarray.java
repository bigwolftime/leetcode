package leetcode;

import java.util.Arrays;

/**
 * 最短连续无序子数组
 * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
 *
 * 排序后判断不同的元素
 */
public class FindUnsortedSubarray {

    private static int findUnsortedSubarray(int[] nums) {
        int startUnsortedIdx = -1, endUnsortedIdx = -1;
        int[] copyArr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copyArr);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != copyArr[i]) {
                startUnsortedIdx = i;
                break;
            }
        }

        if (startUnsortedIdx == -1) {
            // 整体有序
            return 0;
        }

        for (int i = nums.length - 1; i >= startUnsortedIdx; i--) {
            if (nums[i] != copyArr[i]) {
                endUnsortedIdx = i;
                break;
            }
        }

        return endUnsortedIdx - startUnsortedIdx + 1;
    }

    public static void main(String[] args) {
        int unsortedSubarray = findUnsortedSubarray(new int[]{2, 3, 3, 2, 4});
        System.err.println(unsortedSubarray);
    }

}
