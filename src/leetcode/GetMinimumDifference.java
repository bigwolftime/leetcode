package leetcode;

import utils.TreeNode;

/**
 * 二叉搜索树的最小绝对差
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 *
 * BST 特性, 中序遍历
 *
 * @author liuxin
 * @time 2020/10/12 12:27
 */
public class GetMinimumDifference {

    private static Integer lastNum;
    private static int minDiff;

    private static int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }

        lastNum = null;
        minDiff = Integer.MAX_VALUE;

        dfs(root);

        return minDiff;
    }

    private static void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        dfs(node.left);

        if (lastNum != null) {
            minDiff = Math.min(minDiff, Math.abs(node.val - lastNum));
        }
        lastNum = node.val;

        dfs(node.right);
    }

    public static void main(String[] args) {

    }

}
