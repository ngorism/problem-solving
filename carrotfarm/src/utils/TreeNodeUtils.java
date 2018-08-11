package utils;


import java.util.Stack;

public class TreeNodeUtils {

	public class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
		TreeNode(int x) { val = x; }

	}

	public TreeNode makeTreeNode(Integer[] input) {
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

	public static void dfsRecur(TreeNode root){
		if(root == null){
			return;
		}
		System.out.println(root.val);

		if (root.left!=null) {
			dfsRecur(root.left);
		}
		if (root.right!=null) {
			dfsRecur(root.right);
		}
	}
	public static void dfsStack(TreeNode root){
		if(root == null){
			return;
		}
		Stack<TreeNode> nodeStack = new Stack<TreeNode>();
		nodeStack.push(root);

		while (!nodeStack.isEmpty()) {
			TreeNode node = nodeStack.pop();
			System.out.println(node.val);

			if (node.right!=null) {
				nodeStack.push(node.right);
			}
			if (node.left!=null) {
				nodeStack.push(node.left);
			}
		}
	}
}
