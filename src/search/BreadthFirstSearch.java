package search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import tree.Node;
import tree.Tree;

public class BreadthFirstSearch implements Search {

	private Path thePath = null;
	private Queue<Node> frontier;
	private Set<Node> explored;
	private boolean goalFound = false;
	private Node goalNode;

	public BreadthFirstSearch() {
		frontier = new LinkedList<Node>();
		explored = new HashSet<Node>();
		thePath = new Path();
	}

	@Override
	public Path search(Tree t, String goal) {
		Node currNode;
		frontier.offer(t.getRoot());

		while (frontier.peek() != null && goalFound == false) {
			currNode = frontier.poll();
			explored.add(currNode);
			if (currNode.getState().getName().equals(goal)) {
				goalFound = true;
				goalNode = currNode;
			}
			for (Node n : currNode.getChildren()) {
				if (!explored.contains(n)) {
					n.setParent(currNode);
					frontier.offer(n);
				}
			}
		}
		if (goalNode == null)
			return thePath;
		
		Node temp = goalNode;
		
		while(temp != null) {
			thePath.addNode(temp);
			temp = temp.getParent();
		}
		
		return thePath;
		
	}
}
