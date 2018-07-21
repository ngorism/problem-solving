/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSame(root.left, root.right);
    }
    
    public boolean isSame(TreeNode a, TreeNode b) {
        if ((a != null && b != null && a.val == b.val)) {
            return isSame(a.left, b.right) && isSame(a.right, b.left);
        }
        if (a == null && b == null) return true;
        return false;
    }
}
