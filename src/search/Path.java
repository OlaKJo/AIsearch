package search;
import java.util.ArrayList;
import java.util.List;
import tree.Node;

public class Path {
	//private int totCost;
	private List<Node> thePath;
	
	public Path() {
		//totCost = 0;
		thePath = new ArrayList<Node>();
	}
	public void addNode(Node newNode) {
		thePath.add(newNode);
	}
	
	public void addToCost(int add) {
		//totCost += add;
	}
	
	public void printPath() {
		if (thePath.size() == 0) {
			System.out.println("no path found");
		}
		for (Node n : thePath) {
			System.out.println("|");
			System.out.println(n.getState().getName());
		}
		//System.out.println("total cost for path is: " + totCost);
	}
}
