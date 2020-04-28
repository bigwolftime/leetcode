package offer;

import java.util.HashSet;

/**
 * 数组中重复的数字
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 */
public class FindRepeatNumber {

    private static int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.add(i)) {
                return i;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{ 2, 3, 1, 0, 2, 5, 3 };
        findRepeatNumber(nums);
    }

}
