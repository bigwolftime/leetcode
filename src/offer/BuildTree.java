package offer;

import utils.TreeNode;

/**
 * 重建二叉树
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 * todo
 */
public class BuildTree {

    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        int len = preorder.length;
        TreeNode root =

        return root;
    }

    private static void build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {

    }

    public static void main(String[] args) {
        int[] preorder = new int[]{ 3,9,20,15,7 };
        int[] inorder = new int[]{ 9,3,15,20,7 };
        buildTree(preorder, inorder);
    }

}
