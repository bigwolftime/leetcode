package leetcode;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的后续遍历
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 *
 * @Author Liuxin
 * @Date 2019/5/6 14:41
 */
public class PostorderTraversal {

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrder(root, list);
        return list;
    }

    private static void postOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        postOrder(node.left, list);
        postOrder(node.right, list);
        list.add(node.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);

        root.right = a;
        a.left = b;

        postorderTraversal(root);
    }
}
