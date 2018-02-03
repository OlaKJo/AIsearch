package tree;

import java.util.ArrayList;
import java.util.List;

import search.BreadthFirstSearch;
import search.Path;
import search.Search;

public class Runner {

	public static void main(String[] args) {
		
		List<Node> theNodes = new ArrayList<Node>();
		for(int i = 0; i < 7; i++) {
			Node n = new Node(new State("state_" + i));
			theNodes.add(n);
		}
		theNodes.get(0).addChild(theNodes.get(1));
		theNodes.get(0).addChild(theNodes.get(2));
		theNodes.get(1).addChild(theNodes.get(3));
		theNodes.get(1).addChild(theNodes.get(4));
		theNodes.get(2).addChild(theNodes.get(5));
		theNodes.get(2).addChild(theNodes.get(6));


		Tree theTree = new Tree(theNodes.get(0));
		theTree.printTree();
		System.out.println("done");
		
		Search b = new BreadthFirstSearch();
		Path p = b.search(theTree, "state_6");
		p.printPath();
	}
}
