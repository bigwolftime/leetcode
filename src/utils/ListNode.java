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

/**
 *  需要重写 AddTwoNumbersII.java
 *  需要重写 FirstBadVersion.java
 *  需要重写 LevelOrderBottom.java
 *  需要重写 MinSubArrayLen.java
 *  需要重写 MoveZeroes.java
 *  需要重写 PostorderTraversal.java
 *  需要重写 RemoveNthFromEnd.java
 *  需要重写 ReverseBits.java
 *  需要重写 SingleNumber.java
 *  需要重写 ToHex.java
 *  需要重写 Trie.java
 *  需要重写 isSymmetric.java
 */
