import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author Liuxin
 * @Date 2019/5/6 14:41
 */
public class PostorderTraversal {

    public static List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();


        return new ArrayList<>();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);

        root.right = a;
        a.left = b;

        postorderTraversal(root);
    }
}
