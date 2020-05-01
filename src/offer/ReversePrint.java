package offer;

import utils.ListNode;

/**
 * @author liuxin
 * @date 2020/5/1 9:40
 *
 * 从尾到头打印链表
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class ReversePrint {

    private static int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        if (head.next == null) {
            return new int[]{ head.val };
        }

        int count = 1;
        ListNode node = head;
        ListNode cur = head.next;
        ListNode next;

        while (cur != null) {
            count++;
            next = cur.next;

            cur.next = node;

            node = cur;
            cur = next;
        }

        head.next = null;

        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = node.val;
            node = node.next;
        }

        return arr;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode.genNodeList(head, new int[]{1});
        reversePrint(head);
    }

}
