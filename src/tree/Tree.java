package tree;

public class Tree {
	Node root;
	
	public Tree(Node root) {
		this.root = root;
	}
	
	public void printTree() {
		root.printNode(0);
	}
	
	public Node getRoot() {
		return root;
	}
}
