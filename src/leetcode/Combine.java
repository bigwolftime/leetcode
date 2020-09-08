package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 * https://leetcode-cn.com/problems/combinations/
 *
 * 回溯 + 剪枝
 *
 */
public class Combine {

	private static List<List<Integer>> resList;

	private static List<List<Integer>> combine(int n, int k) {
		resList = new ArrayList<>();

		dfs(1, n, k, new ArrayList<>());

		return resList;
	}

	private static void dfs(int cur, int n, int k, List<Integer> list) {
		if (list.size() == k) {
			resList.add(list);
			return;
		}

		if (cur > n) {
			return;
		}
		if (list.size() + (n - cur + 1) < k) {
			return;
		}

		List<Integer> originList = new ArrayList<>(list);
		list.add(cur);

		dfs(cur + 1, n, k, list);
		dfs(cur + 1, n, k, originList);
	}

	public static void main (String[] args) {
		System.err.println(combine(4,2));
	}

}
