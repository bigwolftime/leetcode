package leetcode;

/**
 * 搜索旋转排序数组II
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
 *
 * 两次二分
 *
 * 前提：按非降序排列 -> 某位置旋转
 */
public class Search {

    private static boolean search(int[] nums, int target) {
        // 寻找旋转位置
        int rotateIndex = findRotateIndex(nums);

        if (rotateIndex == -1) {
            // 没有发生旋转，按升序二分查询
            return binarySearchAsc(nums, 0, nums.length - 1, target) != -1;
        }

        if (binarySearchAsc(nums, 0, rotateIndex - 1, target) != -1) {
            return true;
        }

        return binarySearchAsc(nums, rotateIndex, nums.length - 1, target) != -1;
    }

    /**
     * 查找旋转位置
     * @param nums
     * @return
     */
    private static int findRotateIndex(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return i;
            }
        }

        // 没有发生旋转
        return -1;
    }

    /**
     * 升序数组二分查询
     * @param nums
     * @param start
     * @param end
     * @param target
     * @return
     */
    private static int binarySearchAsc(int[] nums, int start, int end, int target) {
        int mid;
        while (start <= end) {
            mid = start + ((end - start) >> 1);
            int midVal = nums[mid];

            if (target > midVal) {
                start = mid + 1;
            } else if (target < midVal) {
                end = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{ 1,0,1,1,1 };

        search(nums, 0);
    }

}
