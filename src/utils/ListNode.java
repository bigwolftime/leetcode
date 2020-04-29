package utils;

public class ListNode {
	public int val;
	public ListNode next;
	
	public ListNode(int x) { 
		val = x; 
	}

	public static void genNodeList(ListNode head, int[] nums){
		ListNode cur = head;
		for (int i : nums){
			cur.next = new ListNode(i);
			cur = cur.next;
		}
	}
}
