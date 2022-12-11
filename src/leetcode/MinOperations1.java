package leetcode;

/**
 * 最少操作使数组递增
 * https://leetcode.cn/problems/minimum-operations-to-make-the-array-increasing/
 *
 * @author liuxin
 * @date 2022/12/11 10:56 AM
 */
public class MinOperations1 {


    private static int minOperations(int[] nums) {
        int cnt = 0;
        int lastVal = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int curVal = nums[i];
            if (curVal <= lastVal) {
                int diff = lastVal - curVal + 1;
                cnt += diff;
                lastVal = curVal + diff;
            } else {
                lastVal = curVal;
            }

        }

        return cnt;
    }


    public static void main(String[] args) {

    }

}
