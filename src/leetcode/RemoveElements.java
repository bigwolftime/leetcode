package leetcode;

import utils.ListNode;

/**
 * 删除链表中的节点
 * https://leetcode-cn.com/problems/remove-linked-list-elements/description/
 * @author bwt
 *
 *	思路：
 *	两个指针 cur 和 curNext，初始 cur.next = curNext，
 *一旦 curNext.val = val，那么 while 循环向后移动，直到为 null 或者 curNext.val != val；
 *	考虑特殊情况：当 head.val = val，那么head 将 while 向后移动，直到为 null 或者 head.val != val。
 */
public class RemoveElements {

	public static ListNode removeElements(ListNode head, int val) {
		while(head != null && head.val == val) {
			head = head.next;
		}
		
		if (head == null)
			return null;
		
		ListNode cur = head, curNext = head.next;
		
		while(cur != null && curNext != null) {
			if (curNext.val == val) {
				while(curNext != null && curNext.val == val) {
					curNext = curNext.next;
				}
				cur.next = curNext;
			}
			
			if (curNext != null)
				curNext = curNext.next;
			
			cur = cur.next;
		}
		
        return head;
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(6);
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(6);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		ListNode f = new ListNode(6);
		
		head.next = a;
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		
		removeElements(head, 6);
	}
}
