package leetcode;

/**
 * 一维数组的动态和
 * https://leetcode-cn.com/problems/running-sum-of-1d-array/
 *
 * @author liuxin
 * @time 2020/6/18 10:03
 */
public class RunningSum {

    private static int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        nums = runningSum(nums);

        for (int i : nums) {
            System.err.println(i);
        }
    }

}
