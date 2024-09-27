package leetcode;

import utils.ListNode;

/**
 * 两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/description/
 * @author bwt
 *
 *	思路：
 *	要注意考虑进位
 */
public class AddTwoNumbers {

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		int firstSum = l1.val + l2.val;
		boolean flag = firstSum > 9;
		if (flag) {
			firstSum %= 10;
		}

		ListNode newHead = new ListNode(firstSum);

		ListNode pre = newHead;

		l1 = l1.next;
		l2 = l2.next;

		while (l1 != null && l2 != null) {
			int curSum = l1.val + l2.val;
			if (flag) {
				curSum++;
			}

			flag = curSum >= 10;
			if (flag) {
				curSum %= 10;
			}

			ListNode newNode = new ListNode(curSum);

			pre.next = newNode;
			pre = newNode;

			l1 = l1.next;
			l2 = l2.next;
		}

		while (l1 != null) {
			int curSum = l1.val + (flag ? 1 : 0);
			flag = curSum >= 10;
			if (flag) {
				curSum %= 10;
			}

			ListNode newNode = new ListNode(curSum);
			pre.next = newNode;
			pre = newNode;

			l1 = l1.next;
		}
		while (l2 != null) {
			int curSum = l2.val + (flag ? 1 : 0);
			flag = curSum >= 10;
			if (flag) {
				curSum %= 10;
			}

			ListNode newNode = new ListNode(curSum);
			pre.next = newNode;
			pre = newNode;

			l2 = l2.next;
		}

		if (flag) {
			ListNode newNode = new ListNode(1);
			pre.next = newNode;
		}

		return newHead;
    }
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(5);
		//ListNode a = new ListNode(8);
		//ListNode b = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		//ListNode c = new ListNode(6);
		//ListNode d = new ListNode(4);
		
		//l1.next = a;
		//a.next = b;
		
		//l2.next = c;
		//c.next = d;
		
		ListNode res = addTwoNumbers(l1, l2);
		while(res != null) {
			System.err.println(res.val);
			res = res.next;
		}
	}
}

