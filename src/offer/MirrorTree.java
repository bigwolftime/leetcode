package offer;

import utils.TreeNode;

import java.util.Stack;

/**
 * 二叉树的镜像
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 */
public class MirrorTree {

    private static TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return null;

        TreeNode cur = null, tmp = null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.empty()) {
            cur = stack.pop();

            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);

            tmp = cur.left;
            cur.left = cur.right;
            cur.right = tmp;
        }

        return root;
    }

    public static void main(String[] args) {

    }

}
