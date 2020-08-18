package leetcode;

import utils.ListNode;
import utils.TreeNode;

/**
 * 有序链表转换二叉搜索树
 * https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
 *
 * @author liuxin
 * @time 2020/8/18 17:19
 */
public class SortedListToBST {

    private static TreeNode sortedListToBST(ListNode head) {
        return convert(head, null);
    }

    private static TreeNode convert(ListNode startNode, ListNode endNode) {
        if (startNode == null || startNode == endNode) {
            return null;
        }

        ListNode fast = startNode, slow = startNode;
        while (slow.next != null && slow.next != endNode && fast.next != null && fast.next != endNode && fast.next.next != null && fast.next.next != endNode) {
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode node = new TreeNode(slow.val);

        if (startNode != slow) {
            node.left = convert(startNode, slow);
        }
        node.right = convert(slow.next, endNode);

        return node;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        ListNode.genNodeList(head, new int[]{ -3, 0, 5, 9 });

        TreeNode root = sortedListToBST(head);
        System.err.println("");
    }

}
