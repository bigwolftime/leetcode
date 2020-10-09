package lcci;

import utils.ListNode;

/**
 * 分割链表
 * https://leetcode-cn.com/problems/partition-list-lcci/
 *
 * 无需按照大小顺序插入
 *
 * @author liuxin
 * @time 2020/10/9 11:53
 */
public class Partition {

    private static ListNode partition(ListNode head, int x) {
        ListNode left = null, leftHead = null;
        ListNode right = null, rightHead = null;
        ListNode mid = null, midHead = null;
        ListNode cur = head;

        while (cur != null) {

            if (cur.val < x) {
                // 左边
                if (left == null) {
                    left = leftHead = cur;
                } else {
                    left.next = cur;
                    left = left.next;
                }
            } else if (cur.val > x){
                // 右边
                if (right == null) {
                    right = rightHead = cur;
                } else {
                    right.next = cur;
                    right = right.next;
                }
            } else {
                // 中间
                if (mid == null) {
                    mid = midHead = cur;
                } else {
                    mid.next = cur;
                    mid = mid.next;
                }
            }

            cur = cur.next;
        }
        if (right != null) {
            right.next = null;
        }

        if (midHead == null) {
            midHead = rightHead;
        } else {
            mid.next = rightHead;
        }

        if (leftHead == null) {
            leftHead = midHead;
        } else {
            left.next = midHead;
        }

        return leftHead;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(3);

        ListNode.genNodeList(head, new int[]{ 5,8,5,10,2,1, });

        partition(head, 5);
    }

}
