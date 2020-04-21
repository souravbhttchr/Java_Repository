package com.main;

public class Node {

	private int val;
	private Node next;
	
	private Node() {
	}
	
	public Node(int val) {
		this.val = val;
		this.next = null;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
}
