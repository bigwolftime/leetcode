package lcci;

import utils.ListNode;

import java.util.HashSet;

/**
 * 移除重复节点
 * https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
 *
 * @author liuxin
 * @date 2020/6/26 19:36
 */
public class RemoveDuplicateNodes {

    private static ListNode removeDuplicateNodes(ListNode head) {
        HashSet<Integer> set = new HashSet<>();

        // 头节点
        ListNode newHead = new ListNode(0);
        ListNode cur = newHead;

        int curVal;
        while (head != null) {
            curVal = head.val;

            if (!set.contains(curVal)) {
                set.add(head.val);
                ListNode newNode = new ListNode(curVal);
                cur.next = newNode;
                cur = cur.next;
            }

            head = head.next;
        }

        return newHead.next;
    }

    public static void main(String[] args) {

    }

}
