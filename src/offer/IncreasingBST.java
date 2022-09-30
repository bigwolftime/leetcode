package offer;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 展平二叉搜索树
 * https://leetcode-cn.com/problems/NYBBNL/
 * @author liuxin
 * @date 2022/4/2 9:03 PM
 */
public class IncreasingBST {

    private static List<TreeNode> list;


    public static TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        list = new ArrayList<>();
        inOrder(root);

        root = list.get(0);
        root.left = null;

        TreeNode cur = root;
        for (int i = 1; i < list.size(); i++) {
            cur.left = null;
            cur.right = list.get(i);

            cur = list.get(i);
        }
        cur.left = null;
        cur.right = null;
        return root;
    }

    private static void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            inOrder(node.left);
        }
        list.add(node);
        inOrder(node.right);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(6);
        root.left = a;
        root.right = b;

        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(4);
        a.left = c;
        a.right = d;

        c.left = new TreeNode(1);

        TreeNode e = new TreeNode(8);
        b.right = e;

        e.left = new TreeNode(7);
        e.right = new TreeNode(9);

        increasingBST(root);
    }

}
