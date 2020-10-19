package leetcode;

import utils.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 排序链表
 * https://leetcode-cn.com/problems/sort-list/
 *
 * @author liuxin
 * @time 2020/10/19 14:38
 */
public class SortList {

    private static ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }

        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }

        list.sort(Comparator.comparingInt(o -> o.val));
        for (int i = 1; i < list.size(); i++) {
            list.get(i - 1).next = list.get(i);
        }
        list.get(list.size() - 1).next = null;

        return list.get(0);
    }

    public static void main(String[] args) {

    }

}
