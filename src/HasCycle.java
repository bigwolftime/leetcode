import java.util.HashSet;

import utils.ListNode;

/**
 * 环形链表
 * https://leetcode-cn.com/problems/linked-list-cycle/description/
 * @author bwt
 *
 */
public class HasCycle {

	public static boolean hasCycle(ListNode head) {
		HashSet<ListNode> set = new HashSet<>();
		while(head != null) {
			if (set.contains(head))
				return true;
			else
				set.add(head);
			
			head = head.next;
		}
		
		return false;
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(3);
		ListNode c = new ListNode(4);
		
		head.next = a;
		a.next = b;
		b.next = c;
		c.next = b;
		
		System.err.println(hasCycle(head));
	}
}
