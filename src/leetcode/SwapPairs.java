package leetcode;

import utils.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 两两交换链表中的节点
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 *
 * @author liuxin
 * @time 2020/10/22 19:32
 */
public class SwapPairs {

    private static ListNode swapPairs(ListNode head) {
        List<ListNode> list = new ArrayList<>();

        while (head != null) {
            list.add(head);
            head = head.next;
        }

        if (list.isEmpty()) {
            return null;
        }
        if (list.size() == 1) {
            return list.get(0);
        }

        ListNode newHead = new ListNode(0);
        head = newHead;

        for (int i = 0; i < list.size(); i += 2) {
            if (i + 1 < list.size()) {
                head.next = list.get(i + 1);
                list.get(i + 1).next = list.get(i);
                head = list.get(i);
            } else {
                head.next = list.get(i);
                head = head.next;
            }
        }

        head.next = null;
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode a =new ListNode(2);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(4);

        head.next = a;
        a.next = b;
        b.next = c;

        swapPairs(head);
    }

}
