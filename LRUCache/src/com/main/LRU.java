package com.main;

import java.util.HashMap;

public class LRU {
	private int maxCapacity;
	private int currentCapacity;
	private Node MRUEnd;
	private Node LRUEnd;
	private HashMap<Integer, Node> searchMap;
	
	public LRU(int maxCapacity) {
		this.maxCapacity = maxCapacity;
		this.currentCapacity = 0;
		this.MRUEnd = null;
		this.LRUEnd = null;
		this.searchMap = new HashMap<>();
	}
	
	public boolean put(int val) {
		
		boolean returnVal = false;
		
		if (maxCapacity > 0) {

			if (getCurrentCapacity() == 0) {
				Node newNode = new Node(null, null, val);
				setCurrentCapacity(1);
				MRUEnd = newNode;
				LRUEnd = newNode;
				searchMap.put(val, newNode);
				returnVal = true;
			} else if (getCurrentCapacity() != 0 && getCurrentCapacity() < getMaxCapacity()) {
				if (searchMap.containsKey(val)) {
					switchPositionOfExistingNode(val);
					returnVal = true;
				} else {
					Node newNode = new Node(MRUEnd, null, val);
					MRUEnd.setNext(newNode);
					MRUEnd = newNode;
					searchMap.put(val, newNode);
					setCurrentCapacity(getCurrentCapacity() + 1);
					returnVal = true;
				}
			} else if (getCurrentCapacity() == getMaxCapacity()) {
				if (searchMap.containsKey(val)) {
					switchPositionOfExistingNode(val);
					returnVal = true;
				} else {
					removeLRUNode();
					Node newNode = new Node(MRUEnd, null, val);
					MRUEnd.setNext(newNode);
					MRUEnd = newNode;
					searchMap.put(val, newNode);
					returnVal = true;
				}
			}
		} 
		
		return returnVal;
	}

	private void switchPositionOfExistingNode(int val) {
		Node existingNode = searchMap.get(val);
		if(existingNode.getPrevious() != null) {
			existingNode.getPrevious().setNext(existingNode.getNext());
			switchExistingNodeToMRUEnd(existingNode);
		} else if(existingNode.getNext() != null){
			existingNode.getNext().setPrevious(null);
			LRUEnd = existingNode.getNext();
			switchExistingNodeToMRUEnd(existingNode);
		} 
	}

	private void switchExistingNodeToMRUEnd(Node existingNode) {
		MRUEnd.setNext(existingNode);
		existingNode.setPrevious(MRUEnd);
		existingNode.setNext(null);
		MRUEnd = existingNode;
	}

	private void removeLRUNode() {
		LRUEnd.getNext().setPrevious(null);
		Node temp = LRUEnd;
		LRUEnd = LRUEnd.getNext();
		searchMap.remove(temp.getVal());
		temp.setNext(null);
	}
	
	public void printCache() {
		
		if (maxCapacity > 0) {
			Node currentNode = LRUEnd;

			while (currentNode != MRUEnd) {
				System.out.println(currentNode.getVal());
				currentNode = currentNode.getNext();
			}

			System.out.println(currentNode.getVal());
		} else {
			System.out.println("Cache size is set as 0.");
		}
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public int getCurrentCapacity() {
		return currentCapacity;
	}

	public void setCurrentCapacity(int currentCapacity) {
		this.currentCapacity = currentCapacity;
	}

	public Node getMRUEnd() {
		return MRUEnd;
	}

	public void setMRUEnd(Node mRUEnd) {
		MRUEnd = mRUEnd;
	}

	public Node getLRUEnd() {
		return LRUEnd;
	}

	public void setLRUEnd(Node lRUEnd) {
		LRUEnd = lRUEnd;
	}

	public HashMap<Integer, Node> getSearchMap() {
		return searchMap;
	}

	public void setSearchMap(HashMap<Integer, Node> searchMap) {
		this.searchMap = searchMap;
	}
}

class Node {
	private Node previous;
	private Node next;
	private int val;
	
	public Node(Node previous, Node next, int val) {
		this.previous = previous;
		this.next = next;
		this.val = val;
	}

	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}
}
