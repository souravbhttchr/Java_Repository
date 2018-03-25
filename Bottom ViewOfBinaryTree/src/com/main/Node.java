package com.main;

public class Node {

	Node left;
	Node right;
	private int data;
	Node root;
	private int column;
	private int level;
	private boolean isVisited;

	public Node(int data, Node root) {
		this.data = data;
		this.root = root;
		this.left = null;
		this.right = null;
	}
	public boolean isVisited() {
		return isVisited;
	}
	
	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}
	
	public int getColumn() {
		return column;
	}

	public int getLevel() {
		return level;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
}
