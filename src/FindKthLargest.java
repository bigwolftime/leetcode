/**
 * 数组中的第 K 个最大元素
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/description/
 * @author bwt
 *
 *	待更正。。。
 */
public class FindKthLargest {

	public static int findKthLargest(int[] nums, int k) {
		int temp;
		for (int end = nums.length - 1; end > 0; end--) {
			for (int j = 0; j < end; j++) {
				if (nums[j] > nums[j + 1]) {
					temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
				}
			}
		}
		
		return nums[nums.length - k];
    }
	
	public static void main(String[] args) {
		int[] nums = new int[] {
			3,2,1,5,6,4
		};
		System.err.println(findKthLargest(nums, 2));
	}
}
