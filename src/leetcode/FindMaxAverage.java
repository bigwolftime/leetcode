package leetcode;

/**
 * 子数组最大平均数 I
 * https://leetcode-cn.com/problems/maximum-average-subarray-i/
 */
public class FindMaxAverage {

    private static double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int p = 0, q = k - 1;
        int tempSum = sum;
        while (++q < nums.length) {
            tempSum -= nums[p];
            tempSum += nums[q];

            if (tempSum > sum) {
                sum = tempSum;
            }
            p++;
        }

        return (double) sum / k;
    }


    public static void main(String[] args) {

    }

}
