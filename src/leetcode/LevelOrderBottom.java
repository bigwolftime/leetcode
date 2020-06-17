package leetcode;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Liuxin
 * @Date 2019/5/9 10:54
 *
 * 二叉树的层次遍历 II
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 */
public class LevelOrderBottom {

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {


        return new ArrayList<>();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode a = new TreeNode(9);
        TreeNode b = new TreeNode(20);
        TreeNode c = new TreeNode(15);
        TreeNode d = new TreeNode(7);

        root.left = a;
        root.right = b;
        b.left = c;
        b.right = d;

        levelOrderBottom(root);
    }
}
