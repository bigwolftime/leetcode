import java.util.Arrays;

/**
 * 最接近的三数之和
 * https://leetcode-cn.com/problems/3sum-closest/
 *
 * 暴力法: O(N^3)
 * 优化为: O(N^2)
 * 1. start 指向 i + 1, end 指向 len - 1
 * 2. sum < target 则 start++, sum > target 则 end--.
 *
 * @author liuxin
 * @date 2020/5/31 9:52
 */
public class threeSumClosest {

    private static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int sum = nums[0] + nums[1] + nums[2];
        int tempSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                tempSum += nums[i];
                tempSum += nums[start];
                tempSum += nums[end];

                int x = Math.abs(tempSum - target);
                int y = Math.abs(sum - target);
                sum = x < y ? tempSum : sum;

                if (tempSum < target) {
                    start++;
                } else if (tempSum > target) {
                    end--;
                } else if (tempSum == target) {
                    return tempSum;
                }

                tempSum = 0;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        threeSumClosest(new int[]{ 1,2,4,8,16,32,64,128 }, 82);
    }

}
