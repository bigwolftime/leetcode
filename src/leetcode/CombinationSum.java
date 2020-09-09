package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 组合总和
 * https://leetcode-cn.com/problems/combination-sum/
 *
 * 回溯 + 剪枝
 * 与 [组合] 一题类似, 不过允许数据重复选取
 */
public class CombinationSum {

	private static HashSet<List<Integer>> set;

	private static List<List<Integer>> combinationSum(int[] candidates, int target) {
		set = new HashSet<>();

		dfs(0, candidates, target, new ArrayList<>());

		return new ArrayList<>(set);
	}

	private static void dfs(int index, int[] candidates, int target, List<Integer> list) {
		if (0 == target) {
			set.add(list);
			return;
		}

		if (target < 0) {
			return;
		}
		if (index >= candidates.length) {
			return;
		}

		List<Integer> originList = new ArrayList<>(list);

		list.add(candidates[index]);
		dfs(index, candidates, target - candidates[index], list);

		dfs(index + 1, candidates, target, originList);
	}

	public static void main (String[] args) {
		System.err.println(combinationSum(new int[]{ 2,3,5 }, 8));
	}

}
