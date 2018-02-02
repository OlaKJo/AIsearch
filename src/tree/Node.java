package tree;

import java.util.LinkedList;
import java.util.List;

public class Node {
	private Node parent;
	private List<Node> children;
	private State state;
	private int totCost;
	private int pathCost;
	
	public Node(State state) {
		this.state = state;
		children = new LinkedList<Node>();
		totCost = 0;
		pathCost = 0;
	}
	
	public void setParent(Node parent, int cost) {
		this.parent = parent;
		pathCost = cost;
		totCost = parent.getPathCost() + pathCost;
	}
	
	public void addChild(Node child) {
		children.add(child);
	}
	
	public Node getParent() {
		return parent;
	}
	
	public List<Node> getChildren() {
		return children;
	}
	
	public State getState() {
		return state;
	}
	
	public int getPathCost() {
		return totCost;
	}

	public void printNode() {
		
	}
}
