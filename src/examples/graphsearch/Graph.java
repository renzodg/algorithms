package examples.graphsearch;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Graph {

	private HashMap<Integer, Node> nodeLookup = new HashMap<Integer, Node>();
	
	
	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(3, 6);
		graph.addEdge(6, 5);
		graph.addEdge(6, 8);
		graph.addEdge(8, 7);
		
//		graph.hasPathDFS(1, 4);
		graph.hasPathBFS(1, 4);
	}
	
	public static class Node {
		private int id;
		LinkedList<Node> adjacent = new LinkedList<Node>();
		private Node(int id) {
			this.id = id;
		}
	}
	
	private Node getNode(int id) {
		if(nodeLookup.containsKey(id)) {
			return nodeLookup.get(id);
		}
		
	    Node node = new Node(id);
	    nodeLookup.put(id, node);
	    return node;
	}
	
	public void addEdge(int source, int destination) {
		Node s = getNode(source);
		Node d = getNode(destination);
		s.adjacent.add(d);
	}
	
	public boolean hasPathDFS(int source, int destination) {
		Node s = getNode(source);
		Node d = getNode(destination);
		HashSet<Integer> visited = new HashSet<Integer>();
		return hasPathDFS(s, d, visited);
	}
	
	private boolean hasPathDFS(Node source, Node destination, HashSet<Integer> visited) {
		if (visited.contains(source.id)) {
			return false;
		}
		
		visited.add(source.id);
		
		if (source == destination) {
			return true;
		}
		
		for (Node child : source.adjacent) {
			if (hasPathDFS(child, destination, visited)) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean hasPathBFS(int source, int destination) {
		Node s = getNode(source);
		Node d = getNode(destination);
		return hasPathBFS(s, d);
	}
	
	private boolean hasPathBFS(Node source, Node destination) {
		LinkedList<Node> nextToVisit = new LinkedList<Node>();
		HashSet<Integer> visited = new HashSet<Integer>();
		nextToVisit.add(source);
		
		while(!nextToVisit.isEmpty()) {
			Node node = nextToVisit.remove();
			
			if (node == destination) {
				return true;
			}
			
			if (visited.contains(node.id)) {
				continue;
			}
			
			visited.add(node.id);
			
			for (Node child : node.adjacent) {
				nextToVisit.add(child);
			}
		}
		
		return false;
	}
	
}
