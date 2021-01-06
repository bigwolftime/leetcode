package offer;

import utils.TreeNode;

/**
 * 树的子结构
 * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 */
public class IsSubStructure {

    private static boolean flag;
    private static boolean allFlag;
    private static TreeNode newB;

    private static boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) {
            return false;
        }

        newB = B;
        allFlag = false;

        dfs(A);

        return allFlag;
    }

    private static void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        if (allFlag) {
            return;
        }

        flag = true;
        match(node, newB);

        if (flag) {
            allFlag = true;
            return;
        }

        dfs(node.left);
        dfs(node.right);
    }


    private static void match(TreeNode A, TreeNode B) {
        if (!flag) {
            // not match certainly
            return;
        }

        if (B == null && A == null) {
            return;
        }

        if (A == null) {
            // A null  B not null -> not match
            flag = false;
            return;
        }

        if (B == null) {
            // B null  A not null -> uncertain
            return;
        }

        if (A.val != B.val) {
            // not match certainly
            flag = false;
            return;
        }

        match(A.left, B.left);
        match(A.right, B.right);
    }


    public static void main(String[] args) {

    }

}
