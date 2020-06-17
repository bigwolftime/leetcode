package leetcode;

/**
 * 移除元素
 * https://leetcode-cn.com/problems/remove-element/description/
 * @author bwt
 *
 *	思路：
 *	两个指针 before 和 after 分别指向数组的首、尾，当 当前值不等于 val 时，before 向后移动
 *一位，等于 val 时，判断 nums[after] 是否等于 val，等于的话 after 向前移动一位，否则交换。
 */
public class RemoveElement {

	public static int removeElement(int[] nums, int val) {
		int before = 0, after = nums.length - 1;
		int temp;
		
		while(before <= after) {
			if (nums[before] == val) {
				if (nums[after] == val)
					after--;
				else {
					temp = nums[before];
					nums[before] = nums[after];
					nums[after] = temp;
					
					before++;
					after--;
				}
			}else
				before++;
		}
		
        return before;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[] {0,1,2,2,3,0,4,2};
		removeElement(nums, 2);
	}
}
