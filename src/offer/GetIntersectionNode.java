package offer;

import utils.ListNode;

/**
 * 两个链表的第一个公共节点
 * https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 *
 * like: https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */
public class GetIntersectionNode {

    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode p = headA, q = headB;
        while (p != q) {
            p = p != null ? p.next : headB;
            q = q != null ? q.next : headA;
        }

        return p;
    }

    public static void main(String[] args) {

    }

}
