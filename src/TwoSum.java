/**
 * 两数之和 II - 输入有序数组
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/description/
 * 
 * 	思路：
 * 	有点暴力的解法，从第一个元素一直试到最后一个元素；
 * 	因为数组升序，所以当 numbers[i] + numbers[j] > target 时，即可结束当前一层的循环，如果循环结
 * 束还没有返回，那么返回默认的 {0, 0}
 */
public class TwoSum {

	public static int[] twoSum(int[] numbers, int target) {
		for(int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] + numbers[j] > target)
					break;
				else if (numbers[i] + numbers[j] == target)
					return new int[] {i + 1, j + 1};
			}
		}
		
		return new int[] {0, 0};
    }
	
	public static void main(String[] args) {
		int[] numbers = new int[] {2, 7, 11, 15};
		int[] res = twoSum(numbers, 26);
		for (int i : res) {
			System.err.println(i);
		}
	}
}
