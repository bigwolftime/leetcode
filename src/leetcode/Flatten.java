package leetcode;

import utils.TreeNode;

import java.util.Stack;

/**
 * 二叉树展开为链表
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 *
 * @author liuxin
 * @date 2020/8/2 12:18
 */
public class Flatten {

    private static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> tempStack = new Stack<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curNode, tempNode;
        TreeNode nextNode;
        stack.push(root);
        while (!stack.isEmpty()) {
            curNode = stack.pop();
            if (curNode == null) {
                break;
            }

            if (curNode.left != null) {
                tempStack.push(curNode.left);
            }

            nextNode = curNode.right;
            if (nextNode != null) {
                stack.push(nextNode);
            }

            curNode.left = null;

            if (!tempStack.isEmpty()) {
                while (!tempStack.isEmpty()) {
                    tempNode = tempStack.pop();

                    if (tempNode.right != null) {
                        tempStack.push(tempNode.right);
                    }
                    if (tempNode.left != null) {
                        tempStack.push(tempNode.left);
                    }

                    curNode.right = tempNode;
                    tempNode.left = null;
                    curNode = tempNode;
                }

                curNode.right = nextNode;
            }
        }
    }

    public static void main(String[] args) {
        /*TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(6);

        root.left = a;
        root.right = d;
        a.left = b;
        a.right = c;
        d.right = e;

        flatten(root);*/

        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);

        root.right = a;
        a.left = b;

        flatten(root);
    }

}
