/**
 * 存在重复元素 II
 * https://leetcode-cn.com/problems/contains-duplicate-ii/description/
 * @author bwt
 *
 *	思路：
 *	这道题如果按照在 "存在重复元素(https://leetcode-cn.com/problems/contains-
 *duplicate/description/)" 的做法就不行了，上题使用的 HashSet 记录并不适用；
 *	遍历数组，看下标在 i + k 的范围内相等的情况，时间复杂度 O(N)
 */
public class ContainsNearbyDuplicate {

	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j <= i + k && j < nums.length; j++) {
				if (nums[i] == nums[j])
					return true;
			}
		}
		
		return false;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[] {1,2,3,1};
		System.err.println(containsNearbyDuplicate(nums, 3));
	}
}
