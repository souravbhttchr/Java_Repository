package com.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintLeftView {

	private static Map<Integer, Boolean> levelVisited = new HashMap<>();
	
	private static List<Node> leftViewList = new ArrayList<>();
	
	private static int level = 0;
	
	public static void main(String[] args) {
		
		Node root = new Node(1);
		root.setLeftChild(new Node(2));
		root.getLeftChild().setLeftChild(new Node(3));
		root.getLeftChild().setRightChild(new Node(4));
		root.getLeftChild().getRightChild().setLeftChild(new Node(5));
		root.getLeftChild().getRightChild().setRightChild(new Node(6));
		root.getLeftChild().getRightChild().getRightChild().setLeftChild(new Node(7));
		root.setRightChild(new Node(8));
		root.getRightChild().setRightChild(new Node(9));
		root.getRightChild().getRightChild().setRightChild(new Node(10));
		root.getRightChild().getRightChild().getRightChild().setRightChild(new Node(11));
		root.getRightChild().getRightChild().getRightChild().getRightChild().setRightChild(new Node(12));
		
		getLeftView(root, level);
		
		for (Node node : leftViewList) {
			System.out.println(node.getVal());
		}
	}

	private static void getLeftView(Node root, int level) {
		if(root == null) {
			return;
		} else {
			if(!levelVisited.containsKey(level)) {
				levelVisited.put(level, true);
				leftViewList.add(root);
			} 			
			getLeftView(root.getLeftChild(), level+1);
			getLeftView(root.getRightChild(), level+1);
		}
	}

}
