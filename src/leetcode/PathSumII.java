package leetcode;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 路径总和 II
 * https://leetcode-cn.com/problems/path-sum-ii/
 *
 * 回溯 + 剪枝
 */
public class PathSumII {

	private static List<List<Integer>> resList;

	private static List<List<Integer>> pathSum(TreeNode root, int sum) {
		resList = new ArrayList<>();

		if (root == null) {
			return resList;
		}

		dfs(root, new ArrayList<>(), 0, sum);

		return resList;
	}

	private static void dfs(TreeNode node, List<Integer> list, int curSum, int sum) {
		if (node == null) {
			return;
		}

		curSum += node.val;
		list.add(node.val);

		if (node.left == null && node.right == null && curSum == sum) {
			resList.add(list);
			return;
		}

		List<Integer> originList = new ArrayList<>(list);
		dfs(node.left, list, curSum, sum);
		dfs(node.right, originList, curSum, sum);
	}

}
