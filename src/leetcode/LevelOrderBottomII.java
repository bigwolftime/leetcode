package leetcode;

import utils.TreeNode;

import java.util.*;

/**
 * 二叉树的层次遍历II
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 *
 * @author Liuxin
 * @since 2019/8/23 18:32
 */
public class LevelOrderBottomII {

    private static final int XOR_VAL = 1;

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }

        Queue<TreeNode>[] queueArr = new Queue[]{ new LinkedList<TreeNode>(), new LinkedList<TreeNode>() };
        Queue<TreeNode> tempQueue;

        int curIndex = 1, newIndex;
        curIndex ^= XOR_VAL;
        queueArr[curIndex].add(root);

        TreeNode node;
        while (true) {
            List<Integer> list = new ArrayList<>();

            newIndex = curIndex ^ XOR_VAL;
            queueArr[newIndex].clear();

            tempQueue = queueArr[curIndex];
            while (!tempQueue.isEmpty()) {
                node = tempQueue.poll();
                list.add(node.val);


                if (node.left != null) {
                    queueArr[newIndex].add(node.left);
                }
                if (node.right != null) {
                    queueArr[newIndex].add(node.right);
                }
            }

            resList.add(list);

            if (queueArr[newIndex].isEmpty()) {
                break;
            }

            curIndex = newIndex;
        }

        Collections.reverse(resList);

        return resList;
    }

    public static void main(String[] args) {
        //TreeNode root = new TreeNode();
        //levelOrderBottom();
    }
}
