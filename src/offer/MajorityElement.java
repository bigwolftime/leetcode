package offer;

import java.util.Arrays;

/**
 * 数组中出现次数超过一半的数字
 * https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 * 数组中一个数栈一半以上, 那么排序之后, 一定在中间
 */
public class MajorityElement {

    private static int majorityElement(int[] nums) {
        Arrays.sort(nums);

        return nums[nums.length >> 1];
    }

    public static void main(String[] args) {

    }

}
