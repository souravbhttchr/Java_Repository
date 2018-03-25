package com.main;

import java.util.HashMap;
import java.util.Map;

public class BottomViewPrinter {

	private static Map<Integer, Node> listOfBottomNodes = new HashMap<>();
	
	public static void main(String[] args) {
		Node root = new Node(5, null);
		root.left = new Node(7, root);
		root.left.left = new Node(6, root.left);
		root.left.right = new Node(8, root.left);
		root.left.right.left = new Node(22, root.left.right);
		root.left.right.left.left = new Node(25, root.left.right.left);
		root.left.right.right = new Node(14, root.left.right);
		root.left.right.right.left = new Node(17, root.left.right);
		root.left.right.right.right = new Node(19, root.left.right.right);
		root.right = new Node(9, root);
		root.right.left = new Node(11, root.right);
		root.right.right = new Node(15, root.right);
		root.right.right.left = new Node(18, root.right.right);
		root.right.right.right = new Node(24, root.right.right);
		root.right.right.right.left = new Node(27, root.right.right.right);
		
		BottomViewPrinter bvp = new BottomViewPrinter();
		root.setColumn(0);
		root.setLevel(0);
		root.setVisited(true);
		listOfBottomNodes.put(0, root);
		bvp.findBottomNodes(root);
		
		for (Node node : listOfBottomNodes.values()) {
			System.out.println(node.getData());
		} 
	}

	private void findBottomNodes(Node node) {
		if(node != null){
			if(node.isVisited()){
				tagLeftCordinate(node.left);
				tagRightCordinate(node.right);
				findBottomNodes(node.left);
				findBottomNodes(node.right);
			}
		}
	}

	private void tagLeftCordinate(Node leftNode) {
		if(leftNode != null){
			leftNode.setColumn(leftNode.root.getColumn()-1);
			leftNode.setLevel(leftNode.root.getLevel()+1);
			leftNode.setVisited(true);
			
			if(!listOfBottomNodes.containsKey(leftNode.getColumn())){
				listOfBottomNodes.put(leftNode.getColumn(), leftNode);
			} else{
				if(listOfBottomNodes.get(leftNode.getColumn()).getLevel() < leftNode.getLevel()){
					listOfBottomNodes.put(leftNode.getColumn(), leftNode);
				}
			}
		}
	}
	
	private void tagRightCordinate(Node rightNode) {
		if(rightNode != null){
			rightNode.setColumn(rightNode.root.getColumn()+1);
			rightNode.setLevel(rightNode.root.getLevel()+1);
			rightNode.setVisited(true);
			
			if(!listOfBottomNodes.containsKey(rightNode.getColumn())){
				listOfBottomNodes.put(rightNode.getColumn(), rightNode);
			} else{
				if(listOfBottomNodes.get(rightNode.getColumn()).getLevel() < rightNode.getLevel()){
					listOfBottomNodes.put(rightNode.getColumn(), rightNode);
				}
			}
		}
	}
}
