import utils.ListNode;

/**
 * 回文链表
 * https://leetcode-cn.com/problems/palindrome-linked-list/description/
 * @author bwt
 *
 *	大致思路：首先找到数组的中间节点，然后中间节点之后的链表翻转，翻转结束后两端同时开始比较。
 *	找到中间节点：两个指针 slow 和 fast，fast 每次走两步，slow 每次走一步，当 fast 的
 *下步为空，即：fast.next = null || fast.next.next = null 时结束，此时 slow 
 *的指向则为中间节点。
 */
public class IsPalindrome1 {

	public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
        	return true;
        
        ListNode slow = head, fast = head;
        
        while(fast.next != null && fast.next.next != null) {
        	fast = fast.next.next;
        	slow = slow.next;
        }	//找到中间节点 slow
        
        ListNode pre = slow, cur = slow.next;
        ListNode temp;
        while(cur != null) {
        	temp = cur.next;
        	cur.next = pre;
        	
        	pre = cur;
        	cur = temp;
        }
        slow.next = null;	//中间节点之后的链表翻转，中间节点指针域置为 null
        
        while(head != null && pre != null) {
        	if (head.val != pre.val)
        		return false;
        	
        	head = head.next;
        	pre = pre.next;
        }	//双指针逐个比较值
		
		return true;
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode a = new ListNode(1);
		//ListNode b = new ListNode(2);
		//ListNode c = new ListNode(1);
		
		head.next = a;
		//a.next = c;
		
		//a.next = b;
		//b.next = c;
		
		System.err.println(isPalindrome(head));
	}
}
