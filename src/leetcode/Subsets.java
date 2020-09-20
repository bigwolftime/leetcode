package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 * https://leetcode-cn.com/problems/subsets/
 *
 * 思路: 回溯 + 剪枝
 * 对于每种长度, 进行 DFS
 *
 */
public class Subsets {

	private static List<List<Integer>> resList;

	private static List<List<Integer>> subsets(int[] nums) {
		resList = new ArrayList<>();

		for (int len = 0; len <= nums.length; len++) {
			dfs(0, nums, len, new ArrayList<>());
		}

		return resList;
	}

	/**
	 *
	 * @param curIdx 当前索引位置
	 * @param nums
	 * @param len	要凑的长度
	 * @param list	已凑的数据
	 */
	private static void dfs(int curIdx, int[] nums, int len, List<Integer> list) {
		if (list.size() == len) {
			if (list.size() == 0 && resList.size() != 0) {
				return;
			}

			resList.add(list);
			return;
		}

		if (curIdx >= nums.length) {
			// 越界了呢
			return;
		}

		if (len > nums.length) {
			// 要凑的长度 连数组都不够了呢
			return;
		}

		if (list.size() + (nums.length - curIdx) < len) {
			// 当前已凑的数据 + 数组剩余的数据 < len
			return;
		}

		List<Integer> originList = new ArrayList<>(list);
		list.add(nums[curIdx]);
		dfs(curIdx + 1, nums, len, list);
		dfs(curIdx + 1, nums, len, originList);
	}

	public static void main (String[] args) {

	}

}
