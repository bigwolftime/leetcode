package leetcode;

import utils.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 分隔链表
 * https://leetcode-cn.com/problems/partition-list/
 *
 * 两种办法:
 * 1. 使用两个 list 存储然后合并;
 * 2. 双指针
 *
 * @author liuxin
 * @date 2021/1/3 9:46
 */
public class Partition {

    private static ListNode partition(ListNode head, int x) {
        ListNode p = null, q = null;
        ListNode curP = null, curQ = null;

        while (head != null) {
            int curVal = head.val;

            if (curVal < x) {

                if (p == null) {
                    p = head;
                    curP = p;
                } else {
                    curP.next = head;
                    curP = curP.next;
                }

            } else {

                if (q == null) {
                    q = head;
                    curQ = q;
                } else {
                    curQ.next = head;
                    curQ = curQ.next;
                }

            }

            head = head.next;
        }

        if (p == null) {
            return q;
        }

        curP.next = q;

        if (curQ != null) {
            curQ.next = null;
        }

        return p;


        /*if (head == null) {
            return null;
        }

        List<ListNode> list1 = new ArrayList<>(), list2 = new ArrayList<>();

        while (head != null) {
            int val = head.val;

            if (val < x) {
                list1.add(head);
            } else {
                list2.add(head);
            }

            head = head.next;
        }

        head = list1.isEmpty() ? list2.get(0) : list1.get(0);
        ListNode cur = head;
        if (!list1.isEmpty()) {
            for (int i = 1; i < list1.size(); i++) {
                cur.next = list1.get(i);
                cur = cur.next;
            }
        }

        int i = 0;
        if (list1.isEmpty()) {
            i = 1;
        }
        for (; i < list2.size(); i++) {
            cur.next = list2.get(i);
            cur = cur.next;
        }

        cur.next = null;
        return head;*/
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode.genNodeList(head, new int[]{ 4,3,2,5,2 });

        partition(head, 3);
    }

}
