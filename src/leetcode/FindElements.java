package leetcode;

import utils.TreeNode;

import java.util.HashSet;

/**
 * 在受污染的二叉树中寻找元素
 * https://leetcode.cn/problems/find-elements-in-a-contaminated-binary-tree
 *
 * @author liuxin
 * @date 2024/3/12 19:43
 */
public class FindElements {

    private final HashSet<Integer> set;

    public FindElements(TreeNode root) {
        set = new HashSet<>();

        if (root == null) {
            return;
        }

        root.val = 0;
        set.add(0);

        reset(root, 0);
    }

    private void reset(TreeNode node, int curDeep) {
        if (node == null) {
            return;
        }

        int val = node.val;
        if (node.left != null) {
            int leftVal = 2 * val + 1;
            node.left.val = leftVal;
            set.add(leftVal);

            reset(node.left, curDeep + 1);
        }
        if (node.right != null) {
            int rightVal = 2 * val + 2;
            node.right.val = rightVal;
            set.add(rightVal);

            reset(node.right, curDeep + 1);
        }
    }


    public boolean find(int target) {
        return set.contains(target);
    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(-1);
        TreeNode a = new TreeNode(-1);
        TreeNode b = new TreeNode(-1);
        TreeNode c = new TreeNode(-1);
        TreeNode d = new TreeNode(-1);

        root.left = a;
        root.right = b;

        a.left = c;
        a.right = d;

        FindElements findElements = new FindElements(root);

    }

}
