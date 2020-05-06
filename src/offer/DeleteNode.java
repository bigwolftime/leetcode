package offer;

import utils.ListNode;

/**
 * 删除链表的节点
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 */
public class DeleteNode {

    private static ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        // 删除头节点
        if (head.val == val) {
            return head.next;
        }

        ListNode cur = head.next;
        ListNode pre = head;

        while (cur != null) {
            if (cur.val == val) {
                if (cur.next != null) {
                    pre.next = cur.next;
                } else {
                    pre.next = null;
                }
                break;
            }

            cur = cur.next;
            pre = pre.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode listNode = deleteNode(head, 0);

        while (listNode != null) {
            System.err.println(listNode.val);
            listNode = listNode.next;
        }
    }

}
