package leetcode;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层序遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 *
 * 使用了两个队列, 交替存储层序.
 */
public class LevelOrder {

	private static final int XOR_VAL = 1;

	private static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> resList = new ArrayList<>();
		if (root == null) {
			return resList;
		}

		Queue<TreeNode>[] queueArr = new Queue[]{ new LinkedList<TreeNode>(), new LinkedList<TreeNode>() };
		Queue<TreeNode> tempQueue;

		int curIndex = 1, newIndex;
		curIndex ^= XOR_VAL;
		queueArr[curIndex].add(root);

		TreeNode node;
		while (true) {
			List<Integer> list = new ArrayList<>();

			newIndex = curIndex ^ XOR_VAL;
			queueArr[newIndex].clear();

			tempQueue = queueArr[curIndex];
			while (!tempQueue.isEmpty()) {
				node = tempQueue.poll();
				list.add(node.val);


				if (node.left != null) {
					queueArr[newIndex].add(node.left);
				}
				if (node.right != null) {
					queueArr[newIndex].add(node.right);
				}
			}

			resList.add(list);

			if (queueArr[newIndex].isEmpty()) {
				break;
			}

			curIndex = newIndex;
		}

		return resList;
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

		levelOrder(root);
	}

}
