package leetcode;

import utils.TreeNode;

/**
 * 对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/
 * 思路：中序遍历
 * 单纯中序遍历并不能解决问题
 *
 * @Author Liuxin
 * @Date 2019/2/26 16:55
 */
public class IsSymmetric {

    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private static boolean isMirror(TreeNode t1, TreeNode t2){
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }

        return t1.val == t2.val && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(2);

        root.left = a;
        root.right = b;
        a.left = c;
        b.left = d;

        System.err.println(isSymmetric(root));;
    }

}
