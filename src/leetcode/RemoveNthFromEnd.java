package leetcode;

import utils.ListNode;

/**
 * @Author Liuxin
 * @Date 2019/3/14 18:18
 */
public class RemoveNthFromEnd {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pioneer = head, cur = head;

        while (n-- > 0){
            pioneer = pioneer.next;
        }
        while (pioneer != null && pioneer.next != null){
            pioneer = pioneer.next;
            cur = cur.next;
        }

        if (cur == head){
            return head.next;
        }

        ListNode next = cur.next.next;
        cur.next = next;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(4);
        ListNode d = new ListNode(5);

        //head.next = a;
        //a.next = b;
        //b.next = c;
        //c.next = d;

        ListNode res = removeNthFromEnd(head, 1);
        while (res != null){
            System.err.println(res.val);
            res = res.next;
        }
    }
}
