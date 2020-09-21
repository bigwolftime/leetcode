package leetcode;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 把二叉搜索树转化成累加树
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 */
public class ConvertBST {

	private static List<TreeNode> list;
	private static HashMap<TreeNode, Integer> sumMap;

	private static TreeNode convertBST(TreeNode root) {
		list = new ArrayList<>();
		sumMap = new HashMap<>();
		inOrder(root);

		if (list.size() > 0) {
			sumMap.put(list.get(list.size() - 1), list.get(list.size()  - 1).val);
			for (int i = list.size() - 2; i >= 0; i--) {
				sumMap.put(list.get(i), sumMap.get(list.get(i + 1)) + list.get(i).val);
			}
		}

		inOrderChange(root);

		return root;
	}

	private static void inOrder(TreeNode node) {
		if (node == null) {
			return;
		}

		inOrder(node.right);
		list.add(node);
		inOrder(node.left);
	}

	private static void inOrderChange(TreeNode node) {
		if (node == null) {
			return;
		}

		inOrderChange(node.left);
		node.val = sumMap.get(node);
		inOrderChange(node.right);
	}

	public static void main (String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(1);
		TreeNode c = new TreeNode(4);
		TreeNode d = new TreeNode(3);
		TreeNode e = new TreeNode(13);

		root.left = a;
		root.right = e;

		a.left = b;
		a.right = c;

		c.left = d;

		convertBST(root);
	}

}
