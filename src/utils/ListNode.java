package utils;

public class ListNode {
	public int val;
	public ListNode next;
	
	public ListNode(int x) { 
		val = x; 
	}

	public ListNode set(ListNode head, int[] nums){
		ListNode cur = head;
		for (int i : nums){
			ListNode listNode = new ListNode(i);
			cur.next = listNode;
			cur = cur.next;
		}
		return head;
	}
}
