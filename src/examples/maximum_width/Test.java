package examples.maximum_width;

import examples.maximum_width.MaximumWidth.Node;

public class Test {

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
//        System.out.println("result: " + result);
        int a = 3;
        while(a > 0) {
            a--;
            System.out.println(a);
        }
    }
    
}
