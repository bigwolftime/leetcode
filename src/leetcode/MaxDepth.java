package leetcode;

import utils.TreeNode;

/**
 * @Author Liuxin
 * @Date 2019/3/25 19:12
 *
 * 二叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class MaxDepth {

    public static int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode a = new TreeNode(9);
        TreeNode b = new TreeNode(20);
        root.left = a;
        root.right = b;

        TreeNode c = new TreeNode(15);
        TreeNode d = new TreeNode(7);
        b.left = c;
        b.right = d;

        System.err.println(maxDepth(root));
    }
}
