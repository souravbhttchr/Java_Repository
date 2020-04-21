package com.main;

public class Node {
	private int val;
	private Node leftChild;
	private Node rightChild;
	
	private Node() {
	}

	public Node(int val) {
		this.val = val;
		this.leftChild = null;
		this.rightChild = null;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}
}
