package leetcode;

import utils.ListNode;

import java.util.Stack;

/**
 * @Author Liuxin
 * @Date 2019/4/1 18:45
 *
 * 两数相加II
 * https://leetcode-cn.com/problems/add-two-numbers-ii/
 */
public class AddTwoNumbersII {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>(), stack2 = new Stack<>();

        while (l1 != null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            stack2.push(l2.val);
            l2 = l2.next;
        }

        boolean flag = false;
        int temp = 0, val = 0;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (!stack1.isEmpty() || !stack2.isEmpty()){
            if (flag){
                temp++;
                flag = false;
            }

            temp = temp + stack1.pop() + stack2.pop();

            if (temp < 10){
                val = temp;
                temp = 0;
            }else {
                val = temp % 10;
                flag = true;
                temp = 0;
            }

            ListNode next = new ListNode(val);
            cur.next = next;
            cur = cur.next;
        }

        return new ListNode(-1);
    }
}
