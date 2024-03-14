package leetcode;

/**
 * 合并后数组中的最大元素
 * https://leetcode.cn/problems/largest-element-in-an-array-after-merge-operations/
 *
 * @author liuxin
 * @date 2024/3/14 10:02
 */
public class MaxArrayValue {

    private static long maxArrayValue(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int cur = nums.length - 1;
        int pre = cur - 1;

        long maxVal = 0;
        long curVal = nums[cur];

        while (pre >= 0) {

            int preVal = nums[pre];

            if (curVal < preVal) {
                cur = pre;
                pre = cur - 1;

                curVal = nums[cur];
            } else {
                curVal += preVal;
                pre--;
            }

            maxVal = Math.max(maxVal, Math.max(curVal, preVal));
        }

        return maxVal;
    }


    public static void main(String[] args) {
        // 2,3,7,9,3
        long l = maxArrayValue(new int[]{2, 3, 7, 9, 3});
        System.err.println(l);
    }

}
