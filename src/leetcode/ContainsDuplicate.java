package leetcode;

import java.util.HashSet;

/**
 * 存在重复元素
 * https://leetcode-cn.com/problems/contains-duplicate/description/
 * @author bwt
 *
 *	思路：
 *	使用 HashSet 存储数据，时间、空间复杂度为  O(N)；
 */
public class ContainsDuplicate {

	public static boolean containsDuplicate(int[] nums) {
		HashSet<Integer> hashSet = new HashSet<>();
		
		for (int i : nums) {
			if (!hashSet.contains(i))
				hashSet.add(i);
			else
				return true;
		}
		
        return false;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[] {1,1,1,3,3,4,3,2,4,2};
		System.err.println(containsDuplicate(nums));
	}
}
