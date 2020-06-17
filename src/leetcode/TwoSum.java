package leetcode;

import java.util.HashMap;
import java.util.Objects;

/**
 * 两数之和 II - 输入有序数组
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/description/
 */
public class TwoSum {

	/*public static int[] twoSum(int[] numbers, int target) {
		for(int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] + numbers[j] > target)
					break;
				else if (numbers[i] + numbers[j] == target)
					return new int[] {i + 1, j + 1};
			}
		}
		
		return new int[] {0, 0};
    }*/

	public static int[] twoSum(int[] numbers, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < numbers.length; i++){
			map.put(numbers[i], i);
		}

		Integer key;
		for (int i = 0; i < numbers.length; i++){
			key = target - numbers[i];
			if (Objects.nonNull(map.get(key)) && i != map.get(key)){
				return new int[] {i, map.get(key)};
			}
		}

		return new int[]{0, 0};
	}
	
	public static void main(String[] args) {
		int[] numbers = new int[] {2, 7, 11, 15};
		int[] res = twoSum(numbers, 18);

		for (int i : res) {
			System.err.println(i);
		}
	}
}
