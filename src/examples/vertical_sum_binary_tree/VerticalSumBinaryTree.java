package examples.vertical_sum_binary_tree;

import java.util.HashMap;
import java.util.Map;

public class VerticalSumBinaryTree {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    static class LLNode {
        int data;
        LLNode prev, next;

        public LLNode(int d) {
            data = d;
        }
    }

    static class Tree {
        private Node root;

        public Tree(Node root) {
            this.root = root;
        }

        public Map<Integer, Integer> getVerticalSumUsingHashMap() {
            Map<Integer, Integer> verticalSumsMap = new HashMap<>();

            fillVerticalSumsMap(this.root, 0, verticalSumsMap);

            return verticalSumsMap;
        }

        private void fillVerticalSumsMap(Node node, int horizontalDistance, Map<Integer, Integer> verticalSumsMap) {
            if (node == null) {
                return;
            }

            fillVerticalSumsMap(node.left, horizontalDistance - 1, verticalSumsMap);

            int prevSum = (verticalSumsMap.get(horizontalDistance) == null) ? 0
                    : verticalSumsMap.get(horizontalDistance);
            verticalSumsMap.put(horizontalDistance, prevSum + node.data);

            fillVerticalSumsMap(node.right, horizontalDistance + 1, verticalSumsMap);

        }

        public LLNode getVerticalSumUsingDLL() {
            LLNode llNode = new LLNode(0);
            
            fillVerticalSumsDLL(this.root, llNode);

            while (llNode.prev != null) {
                llNode = llNode.prev;
            }

            return llNode;
        }

        private void fillVerticalSumsDLL(Node node, LLNode llNode) {
            llNode.data += node.data;
            // Recursively process left subtree
            if (node.left != null) {
                if (llNode.prev == null) {
                    llNode.prev = new LLNode(0);
                    llNode.prev.next = llNode;
                }
                fillVerticalSumsDLL(node.left, llNode.prev);
            }

            // Process right subtree
            if (node.right != null) {
                if (llNode.next == null) {
                    llNode.next = new LLNode(0);
                    llNode.next.prev = llNode;
                }
                fillVerticalSumsDLL(node.right, llNode.next);
            }
        }
    }
}
