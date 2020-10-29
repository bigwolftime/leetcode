package leetcode;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 求根到叶子节点数字之和
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 *
 * @author liuxin
 * @time 2020/10/29 9:43
 */
public class SumNumbers {

    private static List<List<Integer>> lists;

    private static int sumNumbers(TreeNode root) {
        lists = new ArrayList<>();

        dfs(root, new ArrayList<>());

        int sum = 0;
        for (List<Integer> list : lists) {
            int num = 0;

            for (int i = 0; i < list.size(); i++) {
                num += (list.get(i) * Math.pow(10, i));
            }

            sum += num;
        }

        return sum;
    }

    private static void dfs(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        list.add(0, node.val);

        if (node.left == null && node.right == null) {
            // leaf
            lists.add(list);
            return;
        }

        List<Integer> originList = new ArrayList<>(list);
        dfs(node.left, list);
        dfs(node.right, originList);
    }

    public static void main(String[] args) {

    }

}
