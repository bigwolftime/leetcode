package leetcode;

import utils.TreeNode;

/**
 * 二叉搜索树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 *
 * 有个规律: 如果 p,q 分别在 root 的两侧(即 p <= root.val && q >= root.val || p >= root.val && q <= root.val),
 * 可以直接判定: root 为 p q 的最近公共祖先.
 * 否则为同一侧, 需要继续向下遍历
 *
 * @author liuxin
 * @date 2020/9/1 17:26
 */
public class LowestCommonAncestor {

    private static TreeNode tempNode;

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p,TreeNode q) {
        tempNode = root;

        if (p.val <= q.val) {
            dfs(root, p, q);
        } else {
            dfs(root, q, p);
        }

        return tempNode;
    }

    private static void dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return;
        }

        if (p.val < node.val && q.val > node.val) {
            tempNode = node;
            return;
        }

        if (p.val == node.val && q.val > node.val) {
            tempNode = node;
            return;
        }
        if (p.val < node.val && q.val == node.val) {
            tempNode = node;
            return;
        }

        dfs(node.left, p, q);
        dfs(node.right, p, q);
    }

    public static void main(String[] args) {

    }

}
