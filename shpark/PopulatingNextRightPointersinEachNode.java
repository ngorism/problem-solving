import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode {
    public void connectBFS(TreeLinkNode root) {
        int cnt = 1, cur = cnt;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            cur--;
            TreeLinkNode node = queue.poll();
            if (node != null) {
                if (cur == 0) {
                    cnt *= 2;
                    cur = cnt;
                } else {
                    node.next = queue.peek();
                }

                queue.add(node.left);
                queue.add(node.right);
            }
        }
    }

    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode node = root, next = null;
        while (node.left != null) {
            next = node.left;
            while (node != null) {
                next.next = node.left;
                node.left.next = node.right;
                next = node.right;
                node = node.next;
            }
            node = root.left;
            root = root.left;
        }
    }
}
