package leetcode;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 递增顺序查找树
 * https://leetcode-cn.com/problems/increasing-order-search-tree/
 *
 * 思路：中序遍历需要会，使用递归或者栈
 * 1. 中序遍历后，重建一个数，时间复杂度：O(N) 空间复杂度：O(N)
 * 2. 中序遍历的同时更改指针指向
 *
 * @author Liuxin
 * @since 2019/8/19 17:25
 */
public class IncreasingBST {

    public static TreeNode increasingBST(TreeNode root) {
        List<Integer> order = new ArrayList<>();
        inorderRecursive(root, order);

        TreeNode newRoot = new TreeNode(order.get(0));
        TreeNode retRoot = newRoot;
        for (int i = 1; i < order.size(); i++) {
            TreeNode node = new TreeNode(order.get(i));
            newRoot.right = node;
            newRoot = node;
        }

        return retRoot;
    }

    /**
     * 递归中序遍历
     */
    private static void inorderRecursive(TreeNode root, List<Integer> order) {
        if (root == null) {
            return;
        }

        inorderRecursive(root.left, order);
        order.add(root.val);
        inorderRecursive(root.right, order);
    }

    /**
     * 使用栈中序遍历
     */
    private static void inorderStack(TreeNode root, List<Integer> order) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    order.add(root.val);
                    root = root.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(6);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(8);
        TreeNode f = new TreeNode(1);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(9);

        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        c.left = f;
        b.right = e;
        e.left = g;
        e.right = h;

        TreeNode retRoot = increasingBST(root);
        while (retRoot != null) {
            System.err.println(retRoot.val);
            retRoot = retRoot.right;
        }
    }
}
