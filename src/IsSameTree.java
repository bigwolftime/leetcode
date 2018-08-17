import java.util.Stack;

import utils.TreeNode;

/**
 * 相同的树
 * https://leetcode-cn.com/problems/same-tree/description/
 * @author bwt
 *
 *	思路：
 *	使用循环，使用辅助栈，前序遍历二叉树。
 */
public class IsSameTree {

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		Stack<TreeNode> pStack = new Stack<>();
		Stack<TreeNode> qStack = new Stack<>();
		
		pStack.push(p);
		qStack.push(q);
		
		TreeNode curP = null, curQ = null;
		while(!pStack.empty() && !qStack.empty()) {
			curP = pStack.pop();
			curQ = qStack.pop();
			
			if (curQ == null || curP == null) {
				if (curQ == null && curP != null)
					return false;
				else if (curP == null && curQ != null)
					return false;
			}else {
				if (curP.val != curQ.val)
					return false;
				
				pStack.push(curP.right);
				pStack.push(curP.left);
				qStack.push(curQ.right);
				qStack.push(curQ.left);
			}
		}
		
        return true;
    }
	
	public static void main(String[] args) {
		TreeNode p = new TreeNode(1);
		TreeNode a = new TreeNode(2);
		//TreeNode b = new TreeNode(1);
		//p.left = a;
		//p.right = b;
		
		TreeNode q = new TreeNode(1);
		TreeNode c = new TreeNode(1);
		TreeNode d = new TreeNode(2);
		q.left = c;
		//q.right = d;
		
		System.err.println(isSameTree(p, q));
	}
}
