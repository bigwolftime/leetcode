package leetcode;

/**
 * 寻找旋转排序数组中的最小值II
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 *
 * @author liuxin
 * @date 2020/7/22 7:40
 */
public class FindMinII {

    private static int findMin(int[] nums) {
        int last = Integer.MIN_VALUE;

        for (int i : nums) {
            if (i < last) {
                return i;
            }
            last = i;
        }

        return nums[0];
    }

    public static void main(String[] args) {
        System.err.println(findMin(new int[]{ 3,5,1 }));
    }

}
