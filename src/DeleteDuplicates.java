import utils.ListNode;

/**
 * 删除排序链表中的重复元素
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/description/
 * @author bwt
 *
 *	思路：
 *	如果 head.val = head.next.val，那么 head.next = head.next.next，此时指针不移动，
 *例如：1 -> 1 -> 1，经过一次 while 后，第一个 1 指向第三个 1，但是明显与第一个 1 重复，所以指
 *针不移动；遇到不同的 val 后才会移动。
 */
public class DeleteDuplicates {

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;
		
		ListNode res = head;
		
		while(head != null && head.next != null) {
			if (head.val == head.next.val)
				head.next = head.next.next;
			else
				head = head.next;
		}
		
        return res;
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(1);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(3);
		
		head.next = a;
		a.next = b;
		//b.next =c;
		//c.next = d;
		
		ListNode res = deleteDuplicates(head);
		while(res != null) {
			System.err.println(res.val);
			res = res.next;
		}
	}
}
