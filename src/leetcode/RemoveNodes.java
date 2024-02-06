package leetcode;

import utils.ListNode;

import java.util.Stack;

/**
 * 从链表中移除节点
 * https://leetcode.cn/problems/remove-nodes-from-linked-list
 *
 * @author liuxin
 * @date 2024/2/6 10:28
 */
public class RemoveNodes {

    private static ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        stack.add(head);

        ListNode cur = head.next;
        while (cur != null) {

            while (!stack.isEmpty() && cur.val > stack.peek().val) {
                stack.remove(stack.size() - 1);
            }

            stack.push(cur);
            cur = cur.next;
        }

        head = stack.get(0);
        cur = head;
        for (int i = 1; i < stack.size(); i++) {
            cur.next = stack.get(i);
            cur = cur.next;
        }

        return head;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        ListNode.genNodeList(head, new int[]{2,13,3,8});

        removeNodes(head);
    }

}
