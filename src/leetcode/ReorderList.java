package leetcode;

import utils.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 重排链表
 * https://leetcode-cn.com/problems/reorder-list/
 *
 * 这里使用了 O(n) 的 list 存储 ListNode
 *
 * @author Liuxin
 * @since 2019/8/29 17:37
 */
public class ReorderList {

    public static void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }

        if (list.size() == 1) {
            return;
        }

        int p = 0, q = list.size() - 1;
        ListNode newHead = null;
        while (p < q) {
            if (newHead == null) {
                newHead = list.get(p);
                newHead.next = list.get(q);
            } else {
                list.get(q + 1).next = list.get(p);
                list.get(p).next = list.get(q);
            }

            p++;
            q--;
        }

        if ((list.size() & 1) == 0) {
            list.get(q + 1).next = null;
        } else {
            list.get(q + 1).next = list.get(p);
            list.get(p).next = null;
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
