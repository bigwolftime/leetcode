package leetcode;

import utils.TreeNode;

/**
 * 另一个树的子树
 * https://leetcode-cn.com/problems/subtree-of-another-tree/
 *
 * 1. 使用先序遍历, 遇到空则以 null 标记, 然后使用匹配.(KMP, 朴素).
 *    还不会匹配算法, 所以先用 String#contains()
 */
public class IsSubtree {

    private static boolean isSubtree(TreeNode s, TreeNode t) {
        // 先序遍历 t
        String tStr = preOrder(t);

        // 先序遍历 s
        String sStr = preOrder(s);

        return sStr.contains(tStr);
    }

    private static String preOrder(TreeNode root) {
        // s: 12.n.n  t: 2.n.n  如果开头不加. 那么此例不符合预期
        StringBuilder sb = new StringBuilder(".");
        recursive(root, sb);
        return sb.toString();
    }

    private static void recursive(TreeNode node, StringBuilder sb) {
        if (node != null) {
            sb.append(node.val).append(".");

            recursive(node.left, sb);
            recursive(node.right, sb);
        } else {
            sb.append("n").append(".");
        }
    }

    public static void main(String[] args) {
        TreeNode s = new TreeNode(12);


        TreeNode t = new TreeNode(2);

        System.err.println(isSubtree(s, t));
    }

}
