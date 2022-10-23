package leetcode;

import utils.TreeNode;

import java.util.Stack;

/**
 * 计算布尔二叉树的值
 * https://leetcode.cn/problems/evaluate-boolean-binary-tree/
 *
 * @author liuxin
 * @date 2022/7/11 8:10 PM
 */
public class EvaluateTree {

    private static final int OP_OR = 2;
    private static final int OP_AND = 3;


    private static boolean evaluateTree(TreeNode root) {
        Stack<Integer> stack = new Stack<>();

        postOrder(root, stack);

        return stack.pop() == 1;
    }

    private static void postOrder(TreeNode node, Stack<Integer> stack) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            postOrder(node.left, stack);
        }
        if (node.right != null) {
            postOrder(node.right, stack);
        }

        int val = node.val;
        if (val == OP_AND || val == OP_OR) {
            boolean param1 = stack.pop() == 1;
            boolean param2 = stack.pop() == 1;
            boolean result = val == OP_AND ? (param1 && param2) : (param1 || param2);
            stack.push(result ? 1 : 0);
        } else {
            stack.push(val);
        }
    }


    public static void main(String[] args) {

    }

}
