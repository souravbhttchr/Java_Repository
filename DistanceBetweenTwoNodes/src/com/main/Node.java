package com.main;

public class Node {

	Node left;
	Node right;
	private int data;
	Node root;
	
	public Node(int data, Node root) {
		this.data = data;
		this.root = root;
		this.left = null;
		this.right = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
}
