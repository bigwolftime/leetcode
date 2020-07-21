package leetcode;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 不同的二叉搜索树II
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 *
 * 这题我独立做真的做不来...
 *
 * @author liuxin
 * @date 2020/7/21 7:51
 */
public class GenerateTrees {

    private static List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return generateTrees(1, n);
    }

    private static LinkedList<TreeNode> generateTrees(int start, int end) {
        LinkedList<TreeNode> allTreeList = new LinkedList<>();

        if (start > end) {
            allTreeList.add(null);
            return allTreeList;
        }

        for (int i = start; i <= end; i++) {
            // 递归计算 以当前 i 为根的左, 右子树
            LinkedList<TreeNode> leftTreeList = generateTrees(start, i - 1);
            LinkedList<TreeNode> rightTreeList = generateTrees(i + 1, end);

            for (TreeNode leftNode : leftTreeList) {
                for (TreeNode rightNode : rightTreeList) {
                    TreeNode root = new TreeNode(i);

                    root.left = leftNode;
                    root.right = rightNode;
                    allTreeList.add(root);
                }
            }
        }

        return allTreeList;
    }

    public static void main(String[] args) {

    }

}
