import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import utils.TreeNode;

/**
 * 二叉树的最小深度
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/description/
 * @author bwt
 *
 *	思路：
 *	一般可以使用递归解决问题，方法中注释的部分。
 *	循环的话就是二叉树的层次遍历，用一个 map 存储每一个节点的深度，当当前节点的左右孩子都
 *是空，那么返回 map.get(cur).
 */
public class MinDepth {

	public static int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		
		HashMap<TreeNode, Integer> map = new HashMap<>();
		int depth = 0;
		TreeNode cur = null;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		map.put(root, 1);
		
		while(!queue.isEmpty()) {
			cur = queue.poll();
			depth = map.get(cur);
			
			if (cur.left == null && cur.right == null)
				return depth;
			else {
				depth++;
				if (cur.left != null) {
					queue.add(cur.left);
					map.put(cur.left, depth);
				}
				if (cur.right != null) {
					queue.add(cur.right);
					map.put(cur.right, depth);
				}
			}
		}
		
        return 0;
        
        /**
        if (root == null) return 0;
		
		if (root.left == null && root.right == null) return 1;
		
		if (root.left == null) return minDepth(root.right)+1;

		if (root.right == null) return minDepth(root.left)+1;
		
		int lc = minDepth(root.left)+1;
		int rc = minDepth(root.right)+1;
		
		return lc <= rc ? lc :rc;
         */
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
		
		int res = minDepth(root);
		System.err.println(res);
	}
}
