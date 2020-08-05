package leetcode;

import utils.TreeNode;

/**
 * 打家劫舍III
 * https://leetcode-cn.com/problems/house-robber-iii/
 *
 * @author liuxin
 * @date 2020/8/5 21:17
 */
public class RobIII {

    private static int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(f(root), g(root));
    }

    private static int f(TreeNode node) {
        if (node.left == null && node.right == null) {
            return node.val;
        }

        if (node.left == null) {
            return node.val + g(node.right);
        }
        if (node.right == null) {
            return node.val + g(node.left);
        }

        return node.val + g(node.left) + g(node.right);
    }

    private static int g(TreeNode node) {
        if (node.left == null && node.right == null) {
            return 0;
        }

        int left = 0, right = 0;
        if (node.left == null) {
            return Math.max(f(node.right), g(node.right));
        }
        if (node.right == null) {
            return Math.max(f(node.left), g(node.left));
        }

        return Math.max(f(node.left), g(node.left)) + Math.max(f(node.right), g(node.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(1);
        TreeNode d = new TreeNode(3);

        root.left = a;
        root.right = b;
        a.right  = d;
        b.left = c;

        System.err.println(rob(root));;
    }

}
