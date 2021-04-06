package leetcode;

import utils.ListNode;

/**
 * 删除排序链表中的重复元素II
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 *
 * 先确定头部，再处理后面元素
 * 写的太烂 自己都看不懂
 */
public class DeleteDuplicatesII {

    private static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode newHead = findNewHead(head);

        if (newHead == null) {
            return null;
        }

        ListNode cur = newHead;
        ListNode traverseNode = newHead;

        while (traverseNode != null) {
            traverseNode = traverseNode.next;

            traverseNode = findNewHead(traverseNode);
            cur.next = traverseNode;

            cur = traverseNode;
        }

        return newHead;
    }

    /**
     * 寻找新的head(去重后)
     *
     * @param cur
     * @return
     */
    private static ListNode findNewHead(ListNode cur) {
        if (cur == null) {
            return null;
        }

        int curVal = cur.val;
        ListNode next = cur.next;

        while (next != null) {
            if (cur == null) {
                return null;
            }

            next = cur.next;

            if (next == null) {
                return cur;
            }

            if (next.val != curVal) {
                break;
            }

            while (next != null) {
                if (next.val != curVal) {
                    break;
                }

                next = next.next;
            }
            cur = findNewHead(next);

        }

        return cur;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode.genNodeList(head, new int[]{ 1,1,2 });

        head = deleteDuplicates(head);
        while (head != null) {
            System.err.println(head.val);

            head = head.next;
        }
    }

}
