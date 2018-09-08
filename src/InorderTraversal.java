import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import utils.TreeNode;

/**
 * 二叉树的中序遍历
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/description/
 * @author bwt
 *
 */
public class InorderTraversal {

	public static List<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		
		if (root == null)
			return list;
		
		Stack<TreeNode> stack = new Stack<>();
		while (!stack.empty() || root != null) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			}else {
				root = stack.pop();
				list.add(root.val);
				root = root.right;
			}
		}
		
        return list;
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode a = new TreeNode(9);
		TreeNode b = new TreeNode(20);
		TreeNode c = new TreeNode(15);
		TreeNode d = new TreeNode(7);
		
		root.left = a;
		root.right = b;
		b.left = c;
		b.right = d;
		
		System.err.println(inorderTraversal(root));
	}
}
