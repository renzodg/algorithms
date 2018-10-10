package examples.vertical_sum_binary_tree;

import examples.vertical_sum_binary_tree.VerticalSumBinaryTree.LLNode;
import examples.vertical_sum_binary_tree.VerticalSumBinaryTree.Node;
import examples.vertical_sum_binary_tree.VerticalSumBinaryTree.Tree;

public class Test {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        
        Tree tree = new Tree(root);
        
//        Map<Integer, Integer> verticalSumsMap = tree.getVerticalSumUsingHashMap();
//        System.out.println(verticalSumsMap);
        
        LLNode llNode = tree.getVerticalSumUsingDLL();
        while (llNode != null) {
            System.out.print(llNode.data + " ");
            llNode = llNode.next;
        }
    }
    
}
