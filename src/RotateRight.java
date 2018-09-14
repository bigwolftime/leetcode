import utils.ListNode;

/**
 * 旋转链表
 * https://leetcode-cn.com/problems/rotate-list/description/
 * @author bwt
 *
 *	思路：
 *	可以遍历链表，首尾连接形成环，向右移动步数 k = 向左移动步数 step，
 */
public class RotateRight {

	public static ListNode rotateRight(ListNode head, int k) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;
		
		int len = 1;	//链表长度
		ListNode tail = head;
        while (tail.next != null) {
        	len++;
        	tail = tail.next;
        }	//找到 tail 节点
        
        tail.next = head;	//形成环
        
        int step = len - (k % len);
        while(step != 0) {
        	tail = head;
        	head = head.next;
        	step--;
        }
        tail.next = null;
        
		return head;
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(3);
		ListNode c = new ListNode(4);
		ListNode d = new ListNode(5);
		
		head.next = a;
		a.next = b;
		b.next = c;
		c.next = d;
		
		rotateRight(null, 0);
	}
}
