import utils.TreeNode;

import java.util.HashMap;

/**
 * 从前序与中序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * @author liuxin
 * @date 2020/5/22 22:20
 */
public class BuildTree {

    private static HashMap<Integer, Integer> map;

    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < preorder.length; i++) {
            map.put(inorder[i], i);
        }

        return recursion(preorder, 0, preorder.length - 1, inorder, 0, - 1);
    }

    private static TreeNode recursion(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd) {
        return null;
    }

    public static void main(String[] args) {

    }

}
