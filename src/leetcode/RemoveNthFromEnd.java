package leetcode;

import utils.ListNode;

/**
 * 删除链表的倒数第 N 个节点
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *
 * @Author Liuxin
 * @Date 2019/3/14 18:18
 */
public class RemoveNthFromEnd {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pioneer = head, cur = head;

        while (--n > 0){
            pioneer = pioneer.next;
        }

        ListNode pre = null;
        while (pioneer != null && pioneer.next != null){
            if (pre == null) {
                pre = cur;
            } else {
                pre = pre.next;
            }

            pioneer = pioneer.next;
            cur = cur.next;
        }

        if (pre != null) {
            if (cur == pioneer) {
                pre.next = null;
            } else {
                pre.next = cur.next;
            }
        } else {
            if (head == null) {
                return null;
            }

            head = head.next;
        }

        return head;
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

        ListNode res = removeNthFromEnd(head, 2);
    }
}
