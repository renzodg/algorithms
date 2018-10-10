package examples.maximum_width;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidth {
	
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(8);
        root.right.right.left = new Node(6);
        root.right.right.right = new Node(7);
        
//        int result = MaximumWidth.getMaximumWidth(root);
        int result = MaximumWidth.getMaximumWidthUsingQueue(root);
        System.out.println("result: " + result);
    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static int getMaximumWidth(Node node) {
        int maxWidth = 0;
        int width;
        int height = getheight(node);
        int i;

        /*
         * Get width of each level and compare the width with maximum width so far
         */
        for (i = 1; i <= height; i++) {
            width = getWidth(node, i);
            maxWidth = Math.max(maxWidth, width);
        }

        return maxWidth;
    }

    /* Get width of a given level */
    private static int getWidth(Node node, int level) {
        if (node == null)
            return 0;

        if (level == 1) {
            return 1;
        } else if (level > 1) {
            return getWidth(node.left, level - 1) + getWidth(node.right, level - 1);
        }

        return 0;
    }

    private static int getheight(Node node) {
        if (node == null)
            return 0;
        else {
            /* compute the height of each subtree */
            int lHeight = getheight(node.left);
            int rHeight = getheight(node.right);

            /* use the larger one */
            return (lHeight > rHeight) ? (lHeight + 1) : (rHeight + 1);
        }
    }

    // Function to find the maximum width of
    // the tree using level order traversal
    public static int getMaximumWidthUsingQueue(Node root) {
        // Base case
        if (root == null)
            return 0;

        // Initialize result
        int maxWidth = 0;

        // Do Level order traversal keeping
        // track of number of nodes at every level
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            // Get the size of queue when the level order
            // traversal for one level finishes
            int count = q.size();

            // Update the maximum node count value
            maxWidth = Math.max(maxWidth, count);

            // Iterate for all the nodes in
            // the queue currently
            
            while (count-- > 0) {
                // Dequeue an node from queue
                Node temp = q.remove();
                // Enqueue left and right children
                // of dequeued node
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
        return maxWidth;
    }
}
