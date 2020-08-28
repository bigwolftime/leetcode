package lcci;

import utils.ListNode;

/**
 * 返回倒数第 k 个节点
 * https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci/
 *
 * 使用类似于快慢指针的办法. tag简单
 *
 * @author liuxin
 * @date 2020/8/29 7:47
 */
public class KthToLast {

    private static int kthToLast(ListNode head, int k) {
        ListNode pioneer = head;
        ListNode res = head;

        while (--k > 0 && pioneer.next != null) {
            pioneer = pioneer.next;
        }

        while (pioneer.next != null) {
            pioneer = pioneer.next;
            res = res.next;
        }

        return res.val;
    }

    public static void main(String[] args) {

    }

}
