package leetcode;

import java.util.*;

/**
 * 克隆图
 * https://leetcode-cn.com/problems/clone-graph/
 */
public class CloneGraph {

	private static Node cloneGraph(Node node) {
		if (node == null) {
			return null;
		}

		HashSet<Integer> finishSet = new HashSet<>();
		HashMap<Integer, Node> map = new HashMap<>();
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);

		Node newNode = new Node(node.val);
		map.put(node.val, newNode);

		Node curNode, newCurNode, tempNewNode;
		List<Node> curNodeList, newCurNodeList;
		while (!queue.isEmpty()) {
			curNode = queue.poll();

			if (finishSet.contains(curNode.val)) {
				continue;
			}

			newCurNode = map.get(curNode.val);

			if (newCurNode == null) {
				newCurNode = new Node(curNode.val);
				map.put(curNode.val, newCurNode);
			}

			curNodeList = curNode.neighbors;
			newCurNodeList = newCurNode.neighbors;

			if (curNodeList != null && curNodeList.size() > 0) {
				for (Node tempNode : curNodeList) {

					tempNewNode = map.get(tempNode.val);
					if (tempNewNode == null) {
						tempNewNode = new Node(tempNode.val);
						map.put(tempNode.val, tempNewNode);
					}
					newCurNodeList.add(tempNewNode);

					queue.add(tempNode);
				}
			}

			finishSet.add(curNode.val);
		}

		return newNode;
	}

	public static void main (String[] args) {
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);

		a.neighbors.add(b);
		a.neighbors.add(d);

		b.neighbors.add(a);
		b.neighbors.add(c);

		c.neighbors.add(b);
		c.neighbors.add(d);

		d.neighbors.add(a);
		d.neighbors.add(c);

		cloneGraph(a);
	}

	private static class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
			val = 0;
			neighbors = new ArrayList<>();
		}

		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<>();
		}

		public Node(int _val, ArrayList<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}

}
