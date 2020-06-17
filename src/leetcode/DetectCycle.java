package leetcode;

import utils.ListNode;

/**
 * @Author Liuxin
 * @Date 2019/5/10 14:25
 *
 * 环形链表II
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 *
 * 首先用快慢指针找到环，若有环则遍历寻找
 */
public class DetectCycle {

    public static ListNode detectCycle(ListNode head) {
        if (head == null){
            return null;
        }

        ListNode p = head, q = head;
        boolean hasCycle = false;

        while (p.next != null && p.next.next != null){
            p = p.next.next;
            q = q.next;

            if (p == q){
                hasCycle = true;
                break;
            }
        }

        if (hasCycle){
            q = head;
            while (p != q){
                p = p.next;
                q = q.next;
            }
            return q;
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(0);
        ListNode c = new ListNode(-4);
        head.next = a;
        a.next = b;
        b.next = c;
        c.next = a;

        System.err.println(detectCycle(null));
    }
}
