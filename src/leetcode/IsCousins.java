package leetcode;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的堂兄弟节点
 * https://leetcode-cn.com/problems/cousins-in-binary-tree/
 *
 * 1. 层序遍历
 * 2. 空节点使用 null 代替
 * 3. 不在同一层 -> false
 * 4. 在同一层
 *      索引距离 > 1  -> true
 *      索引距离 == 1 -> xIdx 需为奇数
 */
public class IsCousins {

    private static final int XOR = 1;


    private static boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }

        List<TreeNode>[] lists = new ArrayList[]{
                new ArrayList<>(),
                new ArrayList<>()
        };
        int curIdx = 0;

        lists[curIdx].add(root);
        while (!lists[curIdx].isEmpty()) {
            if (allElementNull(lists[curIdx])) {
                break;
            }

            if (isCousins(lists[curIdx], x, y) || isCousins(lists[curIdx], y, x)) {
                return true;
            }

            int nextIdx = curIdx ^ XOR;

            for (TreeNode curNode : lists[curIdx]) {
                if (curNode == null) {
                    lists[nextIdx].add(null);
                    lists[nextIdx].add(null);
                    continue;
                }

                lists[nextIdx].add(curNode.left);
                lists[nextIdx].add(curNode.right);
            }

            lists[curIdx] = new ArrayList<>();
            curIdx = nextIdx;
        }

        return false;
    }

    private static boolean allElementNull(List<TreeNode> list) {
        if (list == null) {
            return true;
        }

        for (TreeNode node : list) {
            if (node != null) {
                return false;
            }
        }

        return true;
    }

    private static boolean isCousins(List<TreeNode> list, int x, int y) {
        int xIdx = -1;
        for (int i = 0; i < list.size(); i++) {
            TreeNode curNode = list.get(i);

            if (curNode == null) {
                continue;
            }

            if (curNode.val == x && xIdx == -1) {
                xIdx = i;
            } else if (xIdx != -1 && curNode.val == y) {
                if (i - xIdx > 1) {
                    // 距离 > 1，可直接认定
                    return true;
                } else if (xIdx % 2 != 0) {
                    // 10,1,2,3,4,5,6 的情况
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);

        root.left = a;
        root.right = b;

        a.right = new TreeNode(4);
        b.right = new TreeNode(5);

        isCousins(root, 5, 4);
    }

}
