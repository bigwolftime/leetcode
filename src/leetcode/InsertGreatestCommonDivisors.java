package leetcode;

import utils.ListNode;

/**
 * 在链表中插入最大公约数<br/>
 * <a href="https://leetcode.cn/problems/insert-greatest-common-divisors-in-linked-list">...</a>
 *
 * @author liuxin
 * @date 2024/2/19 10:22
 */
public class InsertGreatestCommonDivisors {

    private static ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        ListNode next = cur.next;

        while (next != null) {
            int gcd = calcGreatestCommonDivisor(cur.val, next.val);

            ListNode newNode = new ListNode(gcd);

            cur.next = newNode;
            newNode.next = next;

            cur = next;
            next = cur.next;
        }

        return head;
    }

    private static int calcGreatestCommonDivisor(int a, int b) {
        int mod = a % b;
        while (mod != 0) {
            a = b;
            b = mod;
            mod = a % b;
        }
        return b;
    }


    public static void main(String[] args) {

    }

}
