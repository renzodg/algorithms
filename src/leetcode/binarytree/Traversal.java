package leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Traversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> result = inorderTraversal(root);

        System.out.println(result);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();

        if (root == null)
            return result;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            result.add(currentNode.val);

            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
        }

        return result;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (root == null)
            return result;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        // define a pointer to track nodes
        TreeNode p = root;

        while (!stack.empty() || p != null) {
            // if it is not null, push to stack
            // and go down the tree to left
            if (p != null) {
                stack.push(p);
                p = p.left;

                // if no left child
                // pop stack, process the node
                // then let p point to the right
            } else {
                TreeNode node = stack.pop();
                result.add(node.val);
                p = node.right;
            }
        }

        return result;
    }
}
