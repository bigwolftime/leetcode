package leetcode;

import utils.TreeNode;

/**
 * 平衡二叉树
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 */
public class IsBalanced {

	private static boolean isBalanced (TreeNode root) {
		if (root == null) {
			return true;
		}

		int left = height(root.left);
		int right = height(root.right);

		return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);

//		return false;
	}

	private static int height (TreeNode node) {
		if (node == null) {
			return 0;
		}


		return Math.max(height(node.left), height(node.right)) + 1;
//		}

//		if (node.left == null) {
//			return height(node.right, height + 1);
//		}

//		return height(node.left, height + 1);
	}

	public static void main (String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode a = new TreeNode(9);
		TreeNode b = new TreeNode(20);
		TreeNode c = new TreeNode(15);
		TreeNode d = new TreeNode(7);

		root.left = a;
		root.right = b;

		b.left = c;
		b.right = d;

		System.err.println(isBalanced(root));
		;
	}

}
