package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 非递增序列的最小子序列
 * https://leetcode-cn.com/problems/minimum-subsequence-in-non-increasing-order/
 *
 * 其实就是排序, 从后向前取数
 */
public class MinSubsequence {

	private List<Integer> minSubsequence(int[] nums) {
		Arrays.sort(nums);

		int sum = 0;
		for (int val : nums) {
			sum += val;
		}

		int curSum = 0;
		List<Integer> list = new ArrayList<>();
		for (int i = nums.length - 1; i >= 0; i--) {
			curSum += nums[i];
			sum -= nums[i];
			list.add(nums[i]);

			if (curSum > sum) {
				break;
			}
		}

		return list;
	}

	public static void main (String[] args) {

	}

}
