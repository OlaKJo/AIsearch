package search;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import tree.Node;
import tree.Step;
import tree.Tree;

public class UniformCostSearch implements Search {

	private Path thePath = null;
	private Queue<Step> frontier;
	private Set<Node> explored;
	private boolean goalFound = false;
	private Node goalNode;

	public UniformCostSearch() {
		Comparator<Step> comparator = new StepComparator<Step>();
		frontier = new PriorityQueue<Step>(10, comparator);
		explored = new HashSet<Node>();
		thePath = new Path();
	}

	@Override
	public Path search(Tree t, String goal) {
		Node currNode;
		frontier.offer(new Step(t.getRoot()));

		while (frontier.peek() != null && goalFound == false) {
			currNode = frontier.poll().getDest();
			explored.add(currNode);
			if (currNode.getState().getName().equals(goal)) {
				goalFound = true;
				goalNode = currNode;
			}
			for (Step s : currNode.getChildren()) {
				Node n = s.getDest();
				if (!explored.contains(n) && !frontier.contains(n)) {
					n.setParent(currNode);
					frontier.offer(s);
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
