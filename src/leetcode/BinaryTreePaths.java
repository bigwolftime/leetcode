package leetcode;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的所有路径
 * https://leetcode-cn.com/problems/binary-tree-paths/
 *
 * 需要注意遍历时, 需要保存下当前的遍历路径.
 *
 * 另外 LeetCode 尽量不使用 static 类型, 因为仅一次初始化, 后面的调用会有影响
 *
 */
public class BinaryTreePaths {

	private static List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<>();
		List<Integer> pathList = new ArrayList<>();

		dfs(root, pathList, res);

		return res;
	}

	private static void dfs(TreeNode node, List<Integer> pathList, List<String> resList) {
		if (node == null) {
			return;
		}

		if (node.left == null && node.right == null) {
			StringBuilder sb = new StringBuilder();
			for (Integer i : pathList) {
				sb.append(i).append("->");
			}
			sb.append(node.val);

			resList.add(sb.toString());
		}

		pathList.add(node.val);

		List<Integer> originPathList = new ArrayList<>(pathList);

		dfs(node.left, pathList, resList);
		dfs(node.right, originPathList, resList);
	}

	public static void main (String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(3);
		TreeNode c = new TreeNode(5);

		root.left = a;
		root.right = b;
		a.right = c;

		binaryTreePaths(root);
	}

}
