package com.main;

public class FindLeaves {

	private static Node root = new Node(5, null);
	
	public static void main(String[] args) {
		root.left = new Node(7, root);
		root.left.left = new Node(6, root.left);
		root.left.right = new Node(8, root.left);
		root.left.right.left = new Node(22, root.left.right);
		root.left.right.left.left = new Node(25, root.left.right.left);
		root.left.right.right = new Node(14, root.left.right);
		root.left.right.right.left = new Node(17, root.left.right.right);
		root.left.right.right.right = new Node(19, root.left.right.right);
		
		root.right = new Node(9, root);
		root.right.left = new Node(11, root.right);
		root.right.right = new Node(15, root.right);
		root.right.right.left = new Node(18, root.right.right);
		root.right.right.right = new Node(24, root.right.right);
		root.right.right.right.left = new Node(27, root.right.right.right);
		
		printLeaves(root);
	}

	private static void printLeaves(Node root) {
		if(root == null){
			System.out.println("Tree is empty....");
		} else if(root.getLeft() == null && root.getRight() == null){
			System.out.println(root.getData());
		} else {
			if (root.getLeft() != null) {
				printLeaves(root.getLeft());
			}
			if (root.getRight() != null) {
				printLeaves(root.getRight());
			}
		}
	}
}
