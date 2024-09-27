package leetcode;

import utils.ListNode;

/**
 * 合并两个有序链表
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * @author bwt
 *
 * 新建元素的方法，不推荐
 */
public class MergeTwoLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;

        ListNode head = new ListNode(-1);
        ListNode cur = head;

        while (p != null && q != null) {
            int val1 = p.val;
            int val2 = q.val;

            if (val1 <= val2) {
                cur.next = p;
                cur = p;
                p = p.next;
            } else {
                cur.next = q;
                cur = q;
                q = q.next;
            }
        }

        while (p != null) {
            cur.next = p;
            cur = p;
            p = p.next;
        }
        while (q != null) {
            cur.next = q;
            cur = q;
            q = q.next;
        }

        return head.next;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(4);
        l1.next = a;
        a.next = b;

        ListNode l2 = new ListNode(1);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        l2.next = c;
        c.next = d;

        mergeTwoLists(l1, l2);
    }
}
