package tree;

import java.util.Comparator;

public class Step{

	private Node dest;
	private int cost;
	
	public Step(Node n) {
		dest = n;
		cost = 1;
	}
	
	public Step(Node n, int cost) {
		this(n);
		this.cost = cost;
	}
	
	public Node getDest() {
		return dest;
	}
	
	public int getCost() {
		return cost;
	}
	
}
