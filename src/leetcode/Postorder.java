package leetcode;

import utils.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * N 叉树的后序遍历<br/>
 * <a href="https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal">...</a>
 *
 * @author liuxin
 * @date 2024/2/19 09:59
 */
public class Postorder {

    private static List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        postorder(root, list);

        return list;
    }

    private static void postorder(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }

        List<Node> children = node.children;
        for (Node child : children) {
            postorder(child, list);
        }

        list.add(node.val);
    }


    public static void main(String[] args) {

    }

}
