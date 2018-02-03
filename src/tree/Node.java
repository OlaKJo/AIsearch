package tree;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private List<Step> children;
	private Node parent;
	private State state;
	private boolean printed;
	
	public Node(State state) {
		this.state = state;
		children = new ArrayList<Step>();
		parent = null;
	}
	
	public void addChild(Node n) {
		children.add(new Step(n));
		n.children.add(new Step(this));
	}
	
	public void addChild(Node n, int c) {
		children.add(new Step(n, c));
		n.children.add(new Step(this, c));

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
		if(printed) {
			return;
		}
		System.out.println("Level: " + level + ", State: " + state.getName());
		printed = true;
		for(Step s : children) {
			s.getDest().printNode(level + 1);
		}
	}

	public List<Step> getChildren() {
		List<Step> copy = new ArrayList<Step>();
		for(Step s : children)
			copy.add(s);
		return copy;
	}
}
