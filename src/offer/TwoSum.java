package offer;

import java.util.HashSet;

/**
 * 和为 s 的两个数字
 * https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 */
public class TwoSum {

    private static int[] twoSum(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();
        int diff = 0;

        for (int i : nums) {
            diff = target - i;
            if (set.contains(diff)) {
                return new int[]{ i, diff };
            }

            set.add(i);
        }

        return new int[]{0,0};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{ 10,26,30,31,47,60 };
        twoSum(nums, 7);
    }

}
