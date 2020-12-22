package leetcode;

import utils.TreeNode;

import java.util.*;

/**
 * 二叉树的锯齿形层序遍历
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class ZigzagLevelOrder {

    private static final int XOR_VAL = 1;

    private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        int CUR_ORDER = 0;
        List<List<Integer>> resList = new ArrayList<>();

        List<TreeNode> nextList = new ArrayList<>();
        nextList.add(root);

        while (!nextList.isEmpty()) {

            List<Integer> list = new ArrayList<>();
            for (TreeNode node : nextList) {
                list.add(node.val);
            }
            resList.add(list);

            if (CUR_ORDER == 1) {
                Collections.reverse(list);
            }

            List<TreeNode> tempList = new ArrayList<>();
            for (TreeNode node : nextList) {
                if (node.left != null) {
                    tempList.add(node.left);
                }
                if (node.right != null) {
                    tempList.add(node.right);
                }
            }

            nextList = tempList;
            CUR_ORDER ^= XOR_VAL;
        }

        return resList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(5);

        root.left = a;
        root.right = b;
        a.left = c;
        b.right = d;

        List<List<Integer>> lists = zigzagLevelOrder(root);

        System.err.println(lists);
    }

}
