package leetcode;

/**
 * 从排序数组中删除重复项
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/21/
 * @author bwt
 *
 *	思路：
 *	声明两个指针 slow 和 fast，首先都指向数组的第一个元素的，即下标为 0；
 *	如果 slow 指向的元素与 fast 之乡的元素相等，那么 fast 向后移动一步，直到 fast 
 *指向的元素与 slow 指向的元素不相等，那么当前 fast 指向的值赋给 slow 的下一位，同时 slow 指针后移，fast 不再向后移动；
 *	因为 fast 从 0 开始，nums.length 从 1 开始，所以外部循环条件为：fast < nums.length - 1；
 *	同样 slow + 1 代表处理后的数组长度。
 *
 *	时间复杂度：O(n)
 *	空间复杂度：O(1)
 */
public class RemoveDuplicates {

	public static int removeDuplicates(int[] nums) {	
		int slow = 0, fast = 0;
		while (fast < nums.length - 1) {
			if (nums[slow] == nums[fast]) {
				while(fast < nums.length && nums[++fast] != nums[slow]) {
					nums[++slow] = nums[fast];
					break;
				}
			}
		}
		
		return slow + 1;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[] {1, 2, 3, 3, 4};
		removeDuplicates(nums);
	}
}
