package leetcode;

import utils.ListNode;

/**
 * @Author Liuxin
 * @Date 2019/2/26 15:27
 *
 * 删除链表中的节点
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 */
public class DeleteNode {

    public static void deleteNode(ListNode node) {
        while (node.next.next != null){
            node.val = node.next.val;
            node = node.next;
        }

        node.val = node.next.val;
        node.next = null;
    }
}
