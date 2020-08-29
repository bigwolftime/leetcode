package leetcode;

import utils.Node;

import java.util.List;

/**
 * N叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 *
 * @author liuxin
 * @date 2020/8/29 9:38
 */
public class MaxDepthN {

    private static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        return maxDepth(root.children, 1);
    }

    private static int maxDepth(List<Node> nodeList, int depth) {
        if (nodeList == null) {
            return depth;
        }

        int maxDepth = depth;
        for (Node subNode : nodeList) {
            maxDepth = Math.max(maxDepth(subNode.children, depth + 1), maxDepth);
        }

        return maxDepth;
    }

    public static void main(String[] args) {

    }

}
