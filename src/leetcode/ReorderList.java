package leetcode;

import utils.ListNode;

/**
 * 重排链表
 * https://leetcode-cn.com/problems/reorder-list/
 *
 * @author Liuxin
 * @since 2019/8/29 17:37
 */
public class ReorderList {

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null){
            return;
        }

        ListNode p = head, q = head;
        while (q.next != null && q.next.next != null){
            p = p.next;
            q = q.next.next;
        }

        //快慢指针找到中间节点
        ListNode mid = p;

        //中间节点之后反转
        ListNode temp;
        if (p.next != null && p.next.next != null){
            temp = p.next.next;
        }





    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(4);
        ListNode d = new ListNode(5);

        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;

        reorderList(head);
    }

}
