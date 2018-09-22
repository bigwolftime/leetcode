import java.util.Stack;

import utils.TreeNode;

/**
 * 二叉搜索树中的搜索
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/description/
 * @author bwt
 *
 *	比较简单，二叉树的遍历。随便挑一种
 */
public class SearchBST {
	
	public TreeNode searchBST(TreeNode root, int val) {
		if (root != null) {
			Stack<TreeNode> stack = new Stack<>();
			TreeNode cur = null;
			stack.push(root);
			
			while(!stack.isEmpty()) {
				cur = stack.pop();
				
				if (cur.val == val)
					return cur;
				
				if (cur.right != null)
					stack.push(cur.right);
				if (cur.left != null)
					stack.push(cur.left);
			}
		}
		
        return null;
    }
	
	public static void main(String[] args) {
		
	}
}
