package examples.lowest_common_ancestor;

import java.util.Stack;

public class Solution {
	
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(6);
        root.left.right.left = new Node(5);
        
        int result = LCA(root, 6, 5);
        System.out.println(result);
    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
    
    public static int LCA(Node root, int child1, int child2) {
        
        Stack<Integer> pathToChild1 = pathToX(root, child1);
        Stack<Integer> pathToChild2 = pathToX(root, child2);
        
        int LCAtoReturn = -1;
        
        while(!pathToChild1.isEmpty() && !pathToChild2.isEmpty()) {
            int ancestor1 = pathToChild1.pop();
            int ancestor2 = pathToChild2.pop();
            
            if (ancestor1 != ancestor2)
                break;
            
            LCAtoReturn = ancestor1;
        }
        
        return LCAtoReturn;
    }

    private static Stack<Integer> pathToX(Node node, int x) {
        if (node == null) return null;
        
        Stack<Integer> path = new Stack<>();
        
        if (node.data == x) {
            Stack<Integer> stackX = new Stack<>();
            stackX.push(x);
            return stackX;
        }
        
        path = pathToX(node.left, x);
        
        if (path != null) {
            path.add(node.data);
            return path;
        }
        
        path = pathToX(node.right, x);
        
        if (path != null) {
            path.add(node.data);
            return path;
        }
        
        
        return null;
    }

}
