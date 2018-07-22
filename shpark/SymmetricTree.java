
public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		return compare(root,root);
	}

	private boolean compare(TreeNode left, TreeNode right) {
		if(left==null && right==null)return true;
		else if(left==null||right==null||left.val!=right.val) return false;
			
		if(!compare(left.left,right.right))return false;
		if(!compare(left.right,right.left))return false;
		return true;
	}
}
	
	
