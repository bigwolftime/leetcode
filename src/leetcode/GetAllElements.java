package leetcode;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 两棵二叉搜索树中的所有元素
 * https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees/
 *
 * 中序遍历，然后外部排序
 *
 */
public class GetAllElements {

    private static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        inOrder(root1, list1);
        inOrder(root2, list2);

        List<Integer> list = new ArrayList<>(list1.size() + list2.size());
        merge(list, list1, list2);

        return list;
    }

    private static void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }

    private static void merge(List<Integer> list, List<Integer> list1, List<Integer> list2) {
        int p = 0, q = 0;
        int val1, val2;

        while (p < list1.size() && q < list2.size()) {
            val1 = list1.get(p);
            val2 = list2.get(q);

            if (val1 < val2) {
                list.add(val1);
                p++;
            } else if (val1 > val2) {
                list.add(val2);
                q++;
            } else {
                list.add(val1);
                list.add(val2);
                p++;
                q++;
            }
        }

        while (p < list1.size()) {
            list.add(list1.get(p++));
        }
        while (q < list2.size()) {
            list.add(list2.get(q++));
        }
    }

    public static void main(String[] args) {

    }

}
