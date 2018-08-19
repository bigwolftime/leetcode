import java.util.Stack;

import utils.TreeNode;

/**
 * 翻转二叉树
 * https://leetcode-cn.com/problems/invert-binary-tree/description/
 * @author bwt
 *
 *	思路：
 *	利用辅助空间栈，先序遍历的顺序入栈然后进行翻转
 */
public class InvertTree {

	public static TreeNode invertTree(TreeNode root) {
		if (root == null)
			return null;
		
		TreeNode cur = null, tmp = null;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		
		while(!stack.empty()) {
			cur = stack.pop();
			
			if (cur.right != null)
				stack.push(cur.right);
			if (cur.left != null)
				stack.push(cur.left);
			
			tmp = cur.left;
			cur.left = cur.right;
			cur.right = tmp;
		}
		
        return root;
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(7);
		TreeNode c = new TreeNode(1);
		TreeNode d = new TreeNode(3);
		TreeNode e = new TreeNode(6);
		TreeNode f = new TreeNode(9);
		
		root.left = a;
		root.right = b;
		a.left = c;
		a.right = d;
		b.left = e;
		b.right = f;
		
		invertTree(root);
	}
}
