import utils.TreeNode;

/**
 * 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 *
 * 1. 递归判断大小, 需要注意判断: [10,5,15,null,null,6,20] 情况
 * 2. 中序遍历
 */
public class IsValidBST {

    private static boolean isValidBST(TreeNode root) {
        return recursiveValid(root, null, null);
    }

    private static boolean recursiveValid(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }

        if (lower != null && node.val <= lower) {
            return false;
        }
        if (upper != null && node.val >= upper) {
            return false;
        }

        return recursiveValid(node.left, lower, node.val) && recursiveValid(node.right, node.val, upper);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(15);
        TreeNode c = new TreeNode(6);
        TreeNode d = new TreeNode(20);

        root.left = a;
        root.right = b;
        b.left = c;
        b.right = d;

        System.err.println(isValidBST(root));
    }

}
