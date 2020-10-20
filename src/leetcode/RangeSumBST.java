package leetcode;

import utils.TreeNode;

/**
 * 二叉搜索树的范围和
 * https://leetcode-cn.com/problems/range-sum-of-bst/
 *
 * @author liuxin
 * @time 2020/10/20 14:38
 */
public class RangeSumBST {

    private static int sum;

    private static int rangeSumBST(TreeNode root, int L, int R) {
        sum = 0;

        dfs(root, L, R);

        return sum;
    }

    private static void dfs(TreeNode node, int L, int R) {
        if (node == null) {
            return;
        }

        int val = node.val;
        if (val >= L && val <= R) {
            sum += val;
        }

        dfs(node.left, L, R);
        dfs(node.right, L, R);
    }

    public static void main(String[] args) {

    }

}
