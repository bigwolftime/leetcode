import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import utils.Node;

/**
 * N 叉树的前序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/
 * @author bwt
 *
 */
public class Preorder {

	public static List<Integer> preorder(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        
		if (root != null) {
			Stack<Node> stack = new Stack<>();
			Node cur = null;
			List<Node> tempList = null;
			
			stack.push(root);
			while(!stack.isEmpty()) {
				cur = stack.pop();
				res.add(cur.val);
				
				tempList = cur.children;
				if (tempList != null) {
					for (int i = tempList.size() - 1; i >= 0; i--) {
						stack.push(tempList.get(i));
					}
				}
			}
		}
        
		return res;
    }
	
	public static void main(String[] args) {
		Node root = new Node(1);
		Node a = new Node(3);
		Node b = new Node(2);
		Node c = new Node(4);
		Node d = new Node(5);
		Node e = new Node(6);
		
		List<Node> rootList = new ArrayList<>();
		rootList.add(a);
		rootList.add(b);
		rootList.add(c);
		root.children = rootList;
		
		List<Node> aList = new ArrayList<>();
		aList.add(d);
		aList.add(e);
		a.children = aList;
		
		preorder(root);
	}
}
