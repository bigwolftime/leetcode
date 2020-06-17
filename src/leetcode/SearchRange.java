package leetcode;

/**
 * 在排序数组中查找元素的第一个和最后一个的位置
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * like: https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 */
public class SearchRange {

    private static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return new int[]{ -1, -1 };
        }

        int start = 0, end = nums.length - 1;
        int mid = (start + end) / 2;
        while (start < end) {
            if (nums[mid] > target) {
                // 目标在左
                end = mid;
            } else if (nums[mid] < target) {
                // 目标在右
                start = mid + 1;
            } else {
                break;
            }
            mid = (start + end) / 2;
        }

        if (nums[mid] != target) {
            return new int[]{ -1, -1 };
        }

        // 目标已经定位到, 向左右延伸
        int left = mid, right = mid;
        while (left >= 0) {
            if (nums[left] != target) {
                break;
            }
            left--;
        }
        while (right < nums.length) {
            if (nums[right] != target) {
                break;
            }
            right++;
        }

        return new int[]{ left + 1, right - 1 };
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 8 };
        int[] res = searchRange(nums, 8);
        System.err.println(res[0]);
        System.err.println(res[1]);
    }

}
