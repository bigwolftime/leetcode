package offer;

import utils.ListNode;

/**
 * 反转链表
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 *
 * @author liuxin
 * @date 2021/5/14 14:38
 */
public class ReverseList {

    private static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode preNode = head;
        ListNode curNode = head.next;
        ListNode nextNode = curNode.next;

        if (nextNode == null) {
            curNode.next = preNode;
            preNode.next = null;
            return curNode;
        }

        ListNode tempNode;

        while (nextNode != null) {
            tempNode = nextNode.next;

            curNode.next = preNode;
            nextNode.next = curNode;

            preNode = curNode;
            curNode = nextNode;
            nextNode = tempNode;
        }

        head.next = null;

        return curNode;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode.genNodeList(head, new int[]{ 1,2 });

        reverseList(head);
    }

}
