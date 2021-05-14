package newcode;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 是否完全二叉树
 *
 * 思路：层序遍历二叉树
 *
 * 如果一个结点，左右孩子都不为空，则pop该节点，将其左右孩子入队列
 *
 * 如果一个结点，左孩子为空，右孩子不为空，则该树一定不是完全二叉树
 *
 * 如果一个结点，左孩子不为空，右孩子为空；或者左右孩子都为空：：：：：则该节点之后的队列中的结点都为叶子节点；该树才是完全二叉树，否则返回false。
 *
 * @author liuxin
 * @date 2021/5/14 15:30
 */
public class IsFullBinaryTree {

    private static boolean judge(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean isLeaf = false;
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();

            if (isLeaf && (curNode.left != null || curNode.right != null)) {
                // 前面已出现过叶子节点, 那么后面也要叶子节点
                return false;
            }
            if (curNode.left == null && curNode.right != null) {
                // 左孩子空 && 右孩子非空
                return false;
            }

            if (curNode.left != null) {
                queue.add(curNode.left);
            }

            if (curNode.right != null) {
                queue.add(curNode.right);
            } else {
                isLeaf = true;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
    }

}
