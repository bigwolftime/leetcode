package leetcode;

/**
 * 使数组中所有元素相等的最小操作数
 * https://leetcode-cn.com/problems/minimum-operations-to-make-array-equal/
 */
public class MinOperations {

	private static int minOperations(int n) {
		int count = 0;

		int mid;
		int step;
		if ((n & 1) == 0) {
			// 偶数个
			mid = (n - 1) >> 1;
			step = 1;
		} else {
			// 奇数个
			mid = ((n - 1) >> 1) - 1;
			step = 2;
		}

		for (int i = mid; i >= 0; i--, step += 2) {
			count += step;
		}

		return count;
	}

	public static void main (String[] args) {
		System.err.println(minOperations(3));;
	}

}
