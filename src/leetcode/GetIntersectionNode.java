package leetcode;

import utils.ListNode;

/**
 * 相交链表
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * @Author bwt
 * @Date 2019/1/22 15:14
 *
 * 通过双指针，遍历链表，消除掉两链表的长度差值。
 */
public class GetIntersectionNode {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }

        ListNode p = headA, q = headB;
        while (p != q){
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }

        return p;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(8);

        ListNode b1 = new ListNode(2);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(4);

        ListNode c1 = new ListNode(5);
        ListNode c2 = new ListNode(6);
        ListNode c3 = new ListNode(7);

        a1.next = c1;

        b1.next = b2;
        b2.next = b3;
        b3.next = c1;

        c1.next = c2;
        c2.next = c3;

        getIntersectionNode(a1, b1);
    }
}
