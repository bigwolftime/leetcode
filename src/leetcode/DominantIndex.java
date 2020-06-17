package leetcode;

/**
 * 至少是其他数字两倍的最大数
 * https://leetcode-cn.com/explore/learn/card/array-and-string/198/introduction-to-array/771/
 * @author bwt
 * 
 * 思路：
 * 两个变量 max 和 second 分别存储数组中最大值和第二大的值，遍历数组。
 * 
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 *
 */
public class DominantIndex {

	public static int dominantIndex(int[] nums) {
		if (nums.length <= 1)
			return 0;
		
		int second = 0, max = 0, index = -1;
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max) {
				second = max;
				max = nums[i];
				index = i;
			}else if (nums[i] > second) {
				second = nums[i];
			}
		}
        return max >= second * 2 ? index : -1;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[] {1, 2, 3, 4};
		System.err.println(dominantIndex(nums));
	}
}
