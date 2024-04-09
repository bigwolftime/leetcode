package leetcode;

/**
 * 正整数和负整数的最大计数<br/>
 * <a href="https://leetcode.cn/problems/maximum-count-of-positive-integer-and-negative-integer">...</a>
 * @author liuxin
 * @date 2024/4/9 10:19
 */
public class MaximumCount {

    private static int maximumCount(int[] nums) {
        int pos = 0, neg = 0;

        for (int num : nums) {
            if (num > 0) {
                pos++;
            } else if (num < 0) {
                neg++;
            }
        }

        return Math.max(pos, neg);
    }


    public static void main(String[] args) {

    }

}
