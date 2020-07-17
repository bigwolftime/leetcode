package leetcode;

/**
 * 搜索插入位置
 * https://leetcode-cn.com/problems/search-insert-position/
 *
 * 二分.
 * 最早的一个提交是2年前, 当时用的暴力法...
 *
 * @author liuxin
 * @time 2020/7/17 8:57
 */
public class SearchInsert {

    private static int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int mid;

        while (start < end) {
            mid = start + ((end - start) >> 1);

            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                return mid;
            }
        }

        return nums[end] >= target ? start : start + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1,3,5,6 };
        int i = searchInsert(nums, 0);
        System.err.println(i);
    }

}
