import java.util.HashMap;

/**
 * 多数元素
 * https://leetcode-cn.com/problems/majority-element/description/
 * @author bwt
 *
 *	思路：
 *	使用辅助空间 O(N)，循环记录每个数字的次数，办法不是特别好。
 */
public class MajorityElement {

	public static int majorityElement(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
			}else {
				map.put(nums[i], 1);
			}
			
			if (map.get(nums[i]) > (nums.length >> 1))
				return nums[i];
		}
		
        return -1;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[] {3,2,3};
		int res = majorityElement(nums);
		System.err.println(res);
	}
}
