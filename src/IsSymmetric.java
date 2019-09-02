import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/
 * 思路：中序遍历
 * 中序遍历并不能解决问题
 *
 * @Author Liuxin
 * @Date 2019/2/26 16:55
 */
public class IsSymmetric {

    public static boolean isSymmetric(TreeNode root) {
        List<String> order = new ArrayList<>();
        inOrderRecursive(root, order);

        int p = 0, q = order.size() - 1;
        while (p <= q){
            if (!order.get(p).equals(order.get(q))){
                return false;
            }
            p++;
            q--;
        }

        return true;
    }

    private static void inOrderRecursive(TreeNode root, List<String> order){
        if (root == null){
            order.add("n");
            return;
        }

        inOrderRecursive(root.left, order);
        order.add(String.valueOf(root.val));
        inOrderRecursive(root.right, order);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(4);

        root.left = a;
        root.right = b;
        a.left = c;
        a.right = e;
        b.left = f;
        b.right = d;

        System.err.println(isSymmetric(root));;
    }

}
