package leetcode;

import utils.ListNode;

/**
 * 连表的中间结点
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * @author bwt
 *
 *	思路：双指针，即快慢指针
 */
public class MiddleNode {

	public static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        
        while(fast.next != null && fast.next.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        }
        if (fast.next != null)
        	slow = slow.next;
		
		return slow;
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		
		head.next = a;
		a.next = b;
		b.next = c;
		
		ListNode res = middleNode(head);
		while(res != null) {
			System.err.println(res.val);
			res = res.next;
		}
	}
}
