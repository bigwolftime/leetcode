package leetcode;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 路径总和
 * https://leetcode-cn.com/problems/path-sum/
 *
 * @author liuxin
 * @date 2020/7/7 22:41
 */
public class HasPathSum {

    private static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();
        nodeQueue.add(root);
        sumQueue.add(root.val);

        TreeNode node;
        TreeNode leftChild, rightChild;
        int curSum;
        while (!nodeQueue.isEmpty()) {
            node = nodeQueue.poll();
            curSum = sumQueue.poll();

            leftChild = node.left;
            rightChild = node.right;

            if (curSum == sum && leftChild == null && rightChild == null) {
                return true;
            }

            if (leftChild != null) {
                nodeQueue.add(leftChild);
                sumQueue.add(curSum + leftChild.val);
            }
            if (rightChild != null) {
                nodeQueue.add(rightChild);
                sumQueue.add(curSum + rightChild.val);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        //TreeNode
    }

}
