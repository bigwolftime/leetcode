import java.util.Stack;

import utils.TreeNode;

/**
 * 左叶子之和
 * https://leetcode-cn.com/problems/sum-of-left-leaves/description/
 * @author bwt
 *
 *	思路：
 *	题目要求是计算 左叶子节点之和，而不是指左节点。我的思路是按照二叉树的先序遍历，如果当前节点
 *的左节点不是空，并且是叶子节点，那么计算 res
 */
public class SumOfLeftLeaves {

	public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
        	return 0;
		
        int res = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = null;
        
        stack.push(root);
        while(!stack.isEmpty()) {
        	cur = stack.pop();
        	
        	if (cur.right != null)
        		stack.push(cur.right);
        	if (cur.left != null) {
        		stack.push(cur.left);
        		
        		if (cur.left.left == null && cur.left.right == null)
        			res += cur.left.val;
        	}
        }
		
		return res;
    }
	
	public static void main(String[] args) {
		/*TreeNode root = new TreeNode(3);
		TreeNode a = new TreeNode(9);
		TreeNode b = new TreeNode(20);
		TreeNode c = new TreeNode(15);
		TreeNode d = new TreeNode(7);
		
		root.left = a;
		root.right = b;
		b.left = c;
		b.right = d;*/
		
		TreeNode root = new TreeNode(1);
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(3);
		TreeNode c = new TreeNode(4);
		TreeNode d = new TreeNode(5);
		
		root.left = a;
		root.right = b;
		a.left = c;
		a.right = d;
		
		System.err.println(sumOfLeftLeaves(root));
	}
}
