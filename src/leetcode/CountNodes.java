package leetcode;

import utils.TreeNode;

/**
 * 完全二叉树的节点数
 * https://leetcode-cn.com/problems/count-complete-tree-nodes/
 *
 * @author liuxin
 * @time 2020/10/9 11:20
 */
public class CountNodes {

    private static int count;

    private static int countNodes(TreeNode root) {
        count = 0;

        dfs(root);

        return count;
    }

    private static void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        count++;
        dfs(node.left);
        dfs(node.right);
    }

    public static void main(String[] args) {

    }

}
