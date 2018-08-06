/**
 * 最大子序和
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/23/dynamic-programming/56/
 * @author bwt
 *
 *	思路：
 *	两个变量 curNum 和 res，遍历数组： 将 nums[i] 和 curNum + nums[i] 中的最大值赋给 curNum，
 *然后将 res 的值和 curNum 比较，将大的数值赋给 res。
 */
public class MaxSubArray {

    public static int maxSubArray(int[] nums) {
    	if (nums.length < 2)
    		return nums[0];
    	
    	int res = Integer.MIN_VALUE >> 1, curNum = 0;
    	
    	for (int i = 0; i < nums.length; i++) {
    		curNum = Math.max(nums[i], curNum + nums[i]);
    		res = Math.max(curNum, res);
    	}
    	
        return res;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
		System.err.println(maxSubArray(nums));
	}
}
