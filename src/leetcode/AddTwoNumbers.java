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
		boolean flag = false;	//借位标志
		
		ListNode res = new ListNode(-1);
		ListNode test = res;
		int num = 0;
		while(l1 != null || l2 != null || flag) {
			if (l1 != null) {
				num += l1.val;
				l1 = l1.next;
			}
				
			if (l2 != null) {
				num += l2.val;
				l2 = l2.next;
			}
			
			if (flag)
				num++;
			
			if (num >= 10)
				flag = true;	//需要借位
			else
				flag = false;
			
			ListNode tmp = new ListNode(num % 10);
			num = 0;
			
			test.next = tmp;
			test = test.next;
		}
		
		return res.next;
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

