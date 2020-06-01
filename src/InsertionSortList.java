import utils.ListNode;

/**
 * @author liuxin
 * @time 2020/5/27 17:14
 */
public class InsertionSortList {

    private static ListNode insertionSortList(ListNode head) {
        // 增加头节点, 防止特殊情况
        ListNode rootPoint = new ListNode(0);
        rootPoint.next = head;

        ListNode pre = rootPoint;
        ListNode cur = head;
        ListNode after = head.next;

        while (after != null) {
            while (cur.val > pre.next.val) {
                pre = pre.next;
            }



            cur = after;
            after = after.next;
            pre = rootPoint;
        }



        return null;
    }

    public static void main(String[] args) {

    }

}
