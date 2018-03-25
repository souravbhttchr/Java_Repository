package com.main;

public class RightViewPrinter {

	static int MAX_LEVEL = 0;
	
	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();
		
		tree.root = new Node(10);
		tree.root.left = new Node(15);
		tree.root.right = new Node(18);
		tree.root.left.left = new Node(20);
		tree.root.left.right = new Node(22);
		tree.root.right.left = new Node(25);
		tree.root.right.right = new Node(30);
		
		RightViewPrinter rvp = new RightViewPrinter();
		
		rvp.rightView(tree);
	}

	private void rightView(BinaryTree tree) {
		rightViewUtil(tree.root, 1);
	}

	private void rightViewUtil(Node node, int level) {

		if(node == null){
			return;
		} else if(MAX_LEVEL < level){
			System.out.print(" " + node.data);
			MAX_LEVEL = level;
		}
		
		rightViewUtil(node.right, level+1);
		rightViewUtil(node.left, level+1);
	}

}
