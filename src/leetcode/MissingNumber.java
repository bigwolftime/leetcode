package leetcode;

/**
 * 缺失数字
 * https://leetcode-cn.com/problems/missing-number/description/
 * @author bwt
 *
 *	思路：
 *	第一个思路是：sum1 记录 nums 数组中所有数之和，sum2 记录没有缺失数字时所有数
 *之和，因为 nums 少了一个数字，所以最后 sum2 还要加上 cur，最后做减法就是缺失的数字。
 *时间复杂度：O(N)，空间复杂度：O(1)
 *	第二个思路是使用位运算，用不缺失数字的数组 与 缺失数字的数组进行 ^ 异或运算，最后结果
 *就是缺失的数字
 */
public class MissingNumber {

	public static int missingNumber(int[] nums) {
		/*int sum1 = 0, sum2 = 0;
		int cur = 0;
		for (int i = 0; i < nums.length; i++) {
			sum1 += nums[i];
			
			sum2 += cur++;
		}
		sum2 += cur;
		
		return sum2 - sum1;*/
		
		int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            res ^= (i + 1) ^ nums[i];
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[] {
			9,6,4,2,3,5,7,0,1
		};
		System.err.println(missingNumber(nums));
	}
}
