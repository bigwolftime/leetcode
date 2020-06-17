package leetcode;

import utils.ListNode;

/**
 * 合并两个有序链表
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * @author bwt
 *
 * 新建元素的方法，不推荐
 */
public class MergeTwoLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode current = res;
        ListNode temp = null;

        while(l1 != null && l2 != null){
            if (l1.val < l2.val){
                temp = new ListNode(l1.val);
                l1 = l1.next;
            }else {
                temp = new ListNode(l2.val);
                l2 = l2.next;
            }

            current.next = temp;
            current = temp;
        }

        //处理长度不一致的情况
        if (l1 != null){
            leftListNode(current, l1);
        }else if (l2 != null){
            leftListNode(current, l2);
        }

        return res.next;
    }

    public static void leftListNode(ListNode current, ListNode leftListNode){
        ListNode temp = null;

        while(leftListNode != null){
            temp = new ListNode(leftListNode.val);

            current.next = temp;
            current = temp;

            leftListNode = leftListNode.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(4);
        l1.next = a;
        a.next = b;

        ListNode l2 = new ListNode(1);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        l2.next = c;
        c.next = d;

        mergeTwoLists(l1, l2);
    }
}
