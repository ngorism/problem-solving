package p2018_07_18;

import java.util.LinkedList;
import java.util.List;

/**
 * Created on 2018. 7. 21..
 */
public class SymmetricTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public static void main(String[] args) {

		// left 가 되는 index 는 1, 3, 7, ..

//		Integer[] input = {1, 2,2, 3,4,4,3};
		Integer[] input = {1,2,2,null,3,null,3};

		SymmetricTree symmetricTree = new SymmetricTree();
		TreeNode root = symmetricTree.makeTreeNode(input);

		boolean result = symmetricTree.isSymmetric(root);
		System.out.println(result);
	}


	public boolean isSymmetric(TreeNode root) {
		boolean result = true;

		if (root==null) {
			return true;
		}
		List<Integer> leftValQueue = printBFS(root.left, true);
		List<Integer> rightValQueue = printBFS(root.right, false);

		if (leftValQueue.size()!=rightValQueue.size()) {
			return false;
		}
		for (int i=0;i<leftValQueue.size();i++) {
//			System.out.println(leftValQueue.get(i) +"\t"+rightValQueue.get(i));
			if (leftValQueue.get(i).intValue() != rightValQueue.get(i).intValue()) {
				return false;
			}
		}
		return result;
	}

	// breadth First Search
	// https://stackoverflow.com/questions/5262308/how-do-implement-a-breadth-first-traversal
	private List<Integer> printBFS(TreeNode root, boolean isLeft) {

		List<Integer> valQueue = new LinkedList<Integer>();
		List<TreeNode> nodeQueue = new LinkedList<TreeNode>();

		nodeQueue.add(root);
		while (!nodeQueue.isEmpty()) {

			TreeNode n = nodeQueue.remove(0);
			if (n==null) {
				valQueue.add(Integer.MIN_VALUE);
				continue;
			}
			valQueue.add(n.val);

			TreeNode firstNode = isLeft?n.left:n.right;
			TreeNode secondNode = isLeft?n.right:n.left;

			nodeQueue.add(firstNode);
			nodeQueue.add(secondNode);
		}
		return valQueue;
	}

	private TreeNode makeTreeNode(Integer[] input) {
		TreeNode root = createTreeNode(input,1);
		return root;
	}

	// int[] 를 binaryTree 로 만드는 법
	// https://stackoverflow.com/questions/26891747/convert-integer-array-into-a-binary-tree
	private TreeNode createTreeNode(Integer[] input, int index){
		if(index<=input.length){
			Integer value = input[index-1];
			if(value!=null){
				TreeNode t = new TreeNode(value);
				t.left = createTreeNode(input, index*2);
				t.right = createTreeNode(input, index*2+1);
				return t;
			}
		}
		return null;
	}



	// 참고용으로 남겨둠
	private boolean isValid(List<Integer> valQueue) {

//      power of two 인 경우만 비교
//		https://codereview.stackexchange.com/questions/172849/checking-if-a-number-is-power-of-2-or-not;
//		100000000 // number
//		& 011111111 // number - 1
//		-----------
//		000000000
		if (valQueue.size()> 1 && ((valQueue.size() & (valQueue.size() - 1)) == 0)) {

			// 0-7, 1-6, 2-5, 3-4 를 비교하는 방식
			for (int i=0;i<valQueue.size()/2;i++) {
				if (valQueue.get(i) != valQueue.get(valQueue.size()-1-i)) {
					return false;
				}
			}
			valQueue.clear();
		}
		return true;
	}
}


