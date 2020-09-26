package leetcode;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树中的众数
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 *
 * 中序遍历, 得到递增序列
 * 计算出现的次数, 最大次数..
 * 根据出现次数取数
 */
public class FindMode {

	private static int[] findMode(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		inOrder(root, list);

		if (list.size() == 0) {
			return new int[0];
		}

		int maxCount = 0;
		int curMaxCount = 0;
		List<Integer> counterList = new ArrayList<>();
		int curNum = list.get(0);

		for (int val : list) {
			if (val == curNum) {
				curMaxCount++;
			} else {
				maxCount = Math.max(maxCount, curMaxCount);
				counterList.add(curMaxCount);
				curMaxCount = 1;
				curNum = val;
			}
		}
		maxCount = Math.max(curMaxCount, maxCount);
		counterList.add(curMaxCount);

		List<Integer> resList = new ArrayList<>();
		int idx = -1;
		for (Integer cnt : counterList) {
			idx += cnt;
			if (cnt == maxCount) {
				resList.add(list.get(idx));
			}
		}

		int[] resArr = new int[resList.size()];
		for (int i = 0; i < resList.size(); i++) {
			resArr[i] = resList.get(i);
		}

		return resArr;
	}

	private static void inOrder(TreeNode node, List<Integer> list) {
		if (node == null) {
			return;
		}

		inOrder(node.left, list);
		list.add(node.val);
		inOrder(node.right, list);
	}

	public static void main (String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(2);

		root.right = a;
		a.left = b;

		System.err.println(findMode(root));
	}

}
