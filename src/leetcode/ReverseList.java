package leetcode;

import utils.ListNode;

/**
 * 反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/description/
 * @author bwt
 *
 */
public class ReverseList {

	public static ListNode reverseList(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;
		
		ListNode pre = head, cur = head.next;
		ListNode temp = null;
		
		while(cur != null) {
			temp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = temp;
		}
		head.next = null;
		
        return pre;
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
		
		ListNode res = reverseList(head);
		while(res != null) {
			System.err.println(res.val);
			res = res.next;
		}
	}
}
