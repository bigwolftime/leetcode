package leetcode;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树得序列化与反序列化
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 *
 * @author liuxin
 * @time 2020/6/16 11:20
 */
public class Codec {

    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder();

        TreeNode node;
        while (!queue.isEmpty()) {
            node = queue.poll();

            if (node != null) {
                sb.append(node.val);
                queue.add(node.left);
                queue.add(node.right);
            } else {
                sb.append("null");
            }

            sb.append(",");
        }

        int count = 1;
        while (sb.length() >= 5 * count) {
            if (sb.charAt(sb.length() - 5 * count) == 'n') {
                count++;
            } else {
                break;
            }
        }

        int subCount = (count - 1) * 5;
        return sb.length() >= subCount + 1 ? sb.substring(0, sb.length() - subCount - 1) : sb.substring(0, sb.length() - subCount);
    }

    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode curNode;
        int index = 0;

        String rootValStr = split[index++];
        if (rootValStr.length() == 0) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(rootValStr));
        queue.add(root);

        String leftValStr, rightValStr;
        while (!queue.isEmpty()) {
            curNode = queue.poll();

            if (index >= split.length) {
                break;
            }
            leftValStr = split[index++];
            if (!isNull(leftValStr)) {
                TreeNode node = new TreeNode(Integer.parseInt(leftValStr));
                curNode.left = node;
                queue.add(node);
            }

            if (index >= split.length) {
                break;
            }
            rightValStr = split[index++];
            if (!isNull(rightValStr)) {
                TreeNode node = new TreeNode(Integer.parseInt(rightValStr));
                curNode.right = node;
                queue.add(node);
            }
        }

        return root;
    }

    private static boolean isNull(String element) {
        return "null".equals(element);
    }

    public static void main(String[] args) {
        String data = "";
        Codec codec = new Codec();

        codec.deserialize(codec.serialize(null));
    }

}
