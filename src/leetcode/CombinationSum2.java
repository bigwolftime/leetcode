package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * 组合总和II
 * https://leetcode-cn.com/problems/combination-sum-ii/
 */
public class CombinationSum2 {

	private static HashSet<List<Integer>> set;

	private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		set = new HashSet<>();

		dfs(0, candidates, new ArrayList<>(), target);

		return new ArrayList<>(set);
	}

	private static void dfs(int idx, int[] candidates, List<Integer> list, int target) {
		if (target == 0) {
			list.sort(Comparator.comparingInt(i -> i));
			set.add(list);
			return;
		}

		if (target < 0) {
			return;
		}
		if (idx >= candidates.length) {
			return;
		}

		List<Integer> originList = new ArrayList<>(list);

		list.add(candidates[idx]);
		dfs(idx + 1, candidates, list, target - candidates[idx]);
		dfs(idx + 1, candidates, originList, target);
	}

	public static void main (String[] args) {

	}

}
