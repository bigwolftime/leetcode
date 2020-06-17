package leetcode;

/**
 * 最大连续 1 的个数
 * https://leetcode-cn.com/problems/max-consecutive-ones/description/
 * @author bwt
 *
 *	思路：
 *	简单的动态规划，时间复杂度 O(n)，res 作为最后的返回结果，cur 表示截至当前最大连续 1 
 *的个数，当出现 1 时 cur++，同时将 res 与 cur 较大的值赋给 res。
 */
public class FindMaxConsecutiveOnes {

	public static int findMaxConsecutiveOnes(int[] nums) {
        int res = 0, cur = 0;
        
        for (int i : nums) {
			if (i == 0)
				cur = 0;
			else {
				cur++;
				res = Math.max(cur, res);
			}
		}
        
        return res;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {1,1,0,1,1,1};
		findMaxConsecutiveOnes(nums);
	}
}
