package p2018_08_01;

import java.util.LinkedList;
import java.util.List;


public class PopulatingNextRightPointers {

	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) { val = x; }
	}

	class TreeLinkNodeDepth {
		int depth;
		TreeLinkNode node;
		TreeLinkNodeDepth(TreeLinkNode node, int depth) {
			this.node = node;
			this.depth = depth;
		}
	}

	public void connect(TreeLinkNode root) {

		int preDepth = 0;
		TreeLinkNode preNode = null;

		List<TreeLinkNodeDepth> queue = new LinkedList<TreeLinkNodeDepth>();
		if (root!=null) {
			queue.add(new TreeLinkNodeDepth(root, preDepth));
		}

		while (!queue.isEmpty()) {

			TreeLinkNodeDepth nodeDepth = queue.remove(0);

			TreeLinkNode node = nodeDepth.node;
			int depth = nodeDepth.depth;

			if (preNode != null && preDepth == depth ) {
				preNode.next = node;
			}

			if(node.left != null) {
				queue.add(new TreeLinkNodeDepth(node.left, depth + 1));
			}
			if(node.right != null) {
				queue.add(new TreeLinkNodeDepth(node.right, depth + 1));
			}
			preNode = node;
			preDepth = depth;
		}
	}
}


