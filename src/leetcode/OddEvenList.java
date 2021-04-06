package leetcode;

import utils.ListNode;

/**
 * 奇偶链表
 * https://leetcode-cn.com/problems/odd-even-linked-list/
 *
 * 比较简单，维护两个链表头，最后首尾拼接即可
 */
public class OddEvenList {

    private static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode curOdd = head;
        ListNode evenHead = head.next, curEven = evenHead;

        if (evenHead == null) {
            return head;
        }

        ListNode cur = evenHead.next;
        boolean isOdd = true;
        while (cur != null) {

            if (isOdd) {
                curOdd.next = cur;
                curOdd = curOdd.next;
            } else {
                curEven.next = cur;
                curEven = curEven.next;
            }

            cur = cur.next;
            isOdd = !isOdd;
        }

        curOdd.next = null;
        curEven.next = null;

        curOdd.next = evenHead;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode.genNodeList(head, new int[]{ 2,3,4,5 });

        oddEvenList(head);

        while (head != null) {
            System.err.println(head.val);

            head = head.next;
        }
    }

}
