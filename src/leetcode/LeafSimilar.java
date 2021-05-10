package leetcode;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 叶子相似的树
 * https://leetcode-cn.com/problems/leaf-similar-trees/
 */
public class LeafSimilar {

    private static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafNodeList1 = new ArrayList<>(), leafNodeList2 = new ArrayList<>();

        preOrder(root1, leafNodeList1);
        preOrder(root2, leafNodeList2);

        return leafSimilar(leafNodeList1, leafNodeList2);
    }

    private static void preOrder(TreeNode node, List<Integer> leafNodeList) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            leafNodeList.add(node.val);
        }

        preOrder(node.left, leafNodeList);
        preOrder(node.right, leafNodeList);
    }

    private static boolean leafSimilar(List<Integer> leafNodeList1, List<Integer> leafNodeList2) {
        if (leafNodeList1.size() != leafNodeList2.size()) {
            return false;
        }

        for (int i = 0; i < leafNodeList1.size(); i++) {
            if (!leafNodeList1.get(i).equals(leafNodeList2.get(i))) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {

    }

}
