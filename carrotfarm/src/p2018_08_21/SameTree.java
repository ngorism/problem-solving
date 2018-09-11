package p2018_08_21;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

import utils.TreeNodeUtils;
import utils.TreeNodeUtils.TreeNode;

public class SameTree {

	public boolean isSameTree(TreeNode p, TreeNode q) {

		if (p==null && q==null) {
			return true;
		}
		if ((p==null && q!=null) || (p!=null && q==null)) {
			return false;
		}

		Queue<TreeNode> leftQueue = new <TreeNode>LinkedList();
		Queue<TreeNode> rightQueue = new <TreeNode>LinkedList();
		leftQueue.offer(p);
		rightQueue.offer(q);

		while(!leftQueue.isEmpty()) {

			TreeNode leftNode = leftQueue.poll();
			TreeNode rightNode = rightQueue.poll();

			if (leftNode==null && rightNode==null) {
				continue;
			}
			if ((leftNode==null && rightNode!=null) || (leftNode!=null && rightNode==null)) {
				return false;
			}

			if (leftNode.val != rightNode.val) {
				return false;
			}
//			System.out.println(leftNode.val + " - " + rightNode.val);

			leftQueue.offer(leftNode.left);
			leftQueue.offer(leftNode.right);

			rightQueue.offer(rightNode.left);
			rightQueue.offer(rightNode.right);

		}
		if (!rightQueue.isEmpty()) {
			return false;
		}
		return true;
	};


	@Test
	public void test() {
		TreeNodeUtils utils = new TreeNodeUtils();

		TreeNode left = utils.makeTreeNode(new Integer[]{1, 4, 5, 4, 4, null, 5});
		TreeNode right = utils.makeTreeNode(new Integer[]{1, 4, 5, 4, 4, null, 5});
		assertEquals(isSameTree(left, right), true);

		left = utils.makeTreeNode(new Integer[]{2, null, 4});
		right = utils.makeTreeNode(new Integer[]{2, 3, 4});
		assertEquals(isSameTree(left, right), false);

	}
}
