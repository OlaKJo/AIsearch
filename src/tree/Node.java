package tree;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private List<Node> children;
	private Node parent;
	private State state;
	
	public Node(State state) {
		this.state = state;
		children = new ArrayList<Node>();
		parent = null;
	}
	
	public void addChild(Node n) {
		children.add(n);
	}
	
	public State getState() {
		return state;
	}
	
	public void setParent(Node p) {
		parent = p;
	}
	
	public Node getParent() {
		return parent;
	}

	public void printNode(int level) {
		System.out.println("Level: " + level + ", State: " + state.getName());
		for(Node n : children) {
			n.printNode(level + 1);
		}
	}

	public List<Node> getChildren() {
		List<Node> copy = new ArrayList<Node>();
		for(Node n : children)
			copy.add(n);
		return copy;
	}
}
