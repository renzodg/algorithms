package examples.linkedlist_cycles;

public class Solution {

    public static void main(String[] args) {
    	Node head = new Node(1);
    	head.next = new Node(2);
    	head.next.next = new Node(3);
    	head.next.next.next = new Node(4);
    	head.next.next.next.next = new Node(5);
    	head.next.next.next.next.next = new Node(6);
    	boolean result = hasCycle(head);
    	System.out.println(result);
    }
    
    static class Node {
    	int data;
    	Node next;
    	
    	public Node(int data) {
    		this.data = data;
    	}
    }
    
    public static boolean hasCycle(Node head) {
    	if (head == null) return false;
    	
    	Node fast = head.next;
    	Node slow = head;
    	
    	while(fast != null && fast.next != null && slow != null) {
    		if (slow == fast) {
    			return true;
    		}
    		
    		slow = slow.next;
			fast = fast.next.next;
    	}
    	
    	return false;
    }

    
}
