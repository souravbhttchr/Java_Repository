package com.main;

public class Node {

	int data;
	Node left, right, root;
	boolean isVisited;
	
	public Node(int val, Node root){
		this.data = val;
		this.root = root;
		this.left = this.right = null;
	}

	public int getData() {
		return data;
	}

	public Node getLeft() {
		return left;
	}

	public Node getRight() {
		return right;
	}

	public Node getRoot() {
		return root;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}
}
