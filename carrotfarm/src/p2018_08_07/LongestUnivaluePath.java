package p2018_08_07;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import utils.TreeNodeUtils;
import utils.TreeNodeUtils.TreeNode;

public class LongestUnivaluePath {

	// NOT ACCEPTED
	public int longestUnivaluePath(TreeNode root) {

		List<Integer> result = new ArrayList<>();

		if (root!=null) {
			dfsRecur(root, 0, result);
		}

		int max = 0;
		for (int i=0;i<result.size();i++) {
			if (result.get(i)>max) {
				max = result.get(i);
			}
		}
		return max;
	}

	private void dfsRecur(TreeNode root, int sum, List<Integer> result){

		int add = 0;
		if (root.left!=null && root.val==root.left.val) {
			add += 1;
		}
		if (root.right!=null && root.val==root.right.val) {
			add += 1;
		}
		if (add == 0) {
			result.add(sum);
		}
		if (root.left!=null) {
			dfsRecur(root.left, root.val==root.left.val?(sum+add):0, result);
		}
		if (root.right!=null) {
			dfsRecur(root.right, root.val==root.right.val?(sum+add):0, result);
		}
	}


	@Test
	public void test() {
		TreeNodeUtils utils = new TreeNodeUtils();
//		TreeNode root = utils.makeTreeNode(new Integer[]{5,4,5,1,1,null,5});
//		TreeNode root = utils.makeTreeNode(new Integer[]{1, 4, 5, 4, 4, null, 5});

//		utils.dfsRecur(root);
//		utils.dfsStack(root);

		assertEquals(longestUnivaluePath(utils.makeTreeNode(new Integer[]{5,4,5,1,1,null,5})), 2);
		assertEquals(longestUnivaluePath(utils.makeTreeNode(new Integer[]{1, 4, 5, 4, 4, null, 5})), 2);

		assertEquals(longestUnivaluePath(utils.makeTreeNode(new Integer[]{1, 1, 2, 1, 2, 3, 4, 1, 1, 2, 2, 3, 3, 4, 4})), 4);

		assertEquals(longestUnivaluePath(utils.makeTreeNode(new Integer[]{4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2})), 1);

	}
}
