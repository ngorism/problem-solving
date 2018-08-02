/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        List<List<TreeLinkNode>> rows = new ArrayList<>();
        Queue<E> q = new LinkedList<>();
        List<TreeLinkNode> row = new ArrayList<>();
        row.add(root);
        
        rows.add(row);
        q.add(new E(root, 1));
        if (root == null) return;
        while (!q.isEmpty()) {
            E now = q.poll();
            if (now.depth >= rows.size()) {
                row = new ArrayList<>();
                rows.add(row);
            }
            List<TreeLinkNode> nextRow = rows.get(now.depth);
            if (now.node.left != null) {
                nextRow.add(now.node.left);
                q.add(new E(now.node.left, now.depth + 1));
            }
            if (now.node.right != null) {
                nextRow.add(now.node.right);
                q.add(new E(now.node.right, now.depth + 1));
            }
        }
        for (List<TreeLinkNode> r : rows) {
            for (int i = 0; i < r.size(); i++) {
                if (i < r.size() - 1) {
                    r.get(i).next = r.get(i + 1);
                }
            }
        }
    }
}

class E {
    TreeLinkNode node;
    int depth;
    public E(TreeLinkNode node, int depth) {
        this.node = node; this.depth = depth;
    }
}
