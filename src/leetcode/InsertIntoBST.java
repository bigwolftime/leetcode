package leetcode;

import utils.TreeNode;

/**
 * 二叉搜索树中的插入操作
 * https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
 *
 * BST 不需要考虑平衡
 *
 */
public class InsertIntoBST {

	private static TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);
		}

		dfs(root, val);

		return root;
	}

	private static void dfs(TreeNode node, int val) {
		if (val < node.val) {
			if (node.left == null) {
				node.left = new TreeNode(val);
				return;
			}

			dfs(node.left, val);
		} else {
			if (node.right == null) {
				node.right = new TreeNode(val);
				return;
			}

			dfs(node.right, val);
		}
	}

	public static void main (String[] args) {

	}

}
