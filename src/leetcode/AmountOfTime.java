package leetcode;

import utils.TreeNode;

import java.util.*;

/**
 * 感染二叉树需要的总时间
 * <a href="https://leetcode.cn/problems/amount-of-time-for-binary-tree-to-be-infected">...</a>
 * <br/>
 * 需要将树结构转成无向图
 *
 * @author liuxin
 * @date 2024/4/24 21:42
 */
public class AmountOfTime {


    private static int amountOfTime(TreeNode root, int start) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        dfs(root, map);

        List<Integer> startList = new ArrayList<>();
        startList.add(start);

        int cnt = 0;

        while (!map.isEmpty()) {
            cnt++;

            List<Integer> newStartList = new ArrayList<>();

            for (Integer infection : startList) {
                Set<Integer> set = map.get(infection);
                if (set == null) {
                    continue;
                }

                newStartList.addAll(set);

                map.remove(infection);
            }

            startList = newStartList;
        }

        return cnt - 1;
    }

    private static void dfs(TreeNode node, Map<Integer, Set<Integer>> map) {
        if (node == null) {
            return;
        }

        Set<Integer> nearby = map.computeIfAbsent(node.val, k -> new HashSet<>());

        if (node.left != null) {
            nearby.add(node.left.val);

            Set<Integer> set = map.computeIfAbsent(node.left.val, k -> new HashSet<>());
            set.add(node.val);


            dfs(node.left, map);
        }
        if (node.right != null) {
            nearby.add(node.right.val);

            Set<Integer> set = map.computeIfAbsent(node.right.val, k -> new HashSet<>());
            set.add(node.val);

            dfs(node.right, map);
        }
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(9);
        TreeNode d = new TreeNode(2);

        root.left = a;
        a.right = b;
        b.left = c;
        b.right = d;

        TreeNode e = new TreeNode(3);
        TreeNode f = new TreeNode(10);
        TreeNode g = new TreeNode(6);

        root.right = e;
        e.left = f;
        e.right = g;

        int i = amountOfTime(root, 3);
        System.err.println(i);
    }


}
