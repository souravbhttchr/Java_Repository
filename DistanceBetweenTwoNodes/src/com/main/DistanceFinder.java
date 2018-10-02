package com.main;

import java.util.ArrayList;
import java.util.List;

public class DistanceFinder {

	private static DistanceFinder df = new DistanceFinder();
	private List<Node> listOfRoots = new ArrayList<>();
	
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
		
		Node targetNode1 = root.left.right;
		Node targetNode2 = root.right.right.right.left;
		
		df.findDistnace(targetNode1, targetNode2);
	}

	private void findDistnace(Node targetNode1, Node targetNode2) {
		
		List<Node> distanceToRootForTrgt1 = new ArrayList<>();
		distanceToRootForTrgt1.addAll(df.distanceToRoot(targetNode1));
		listOfRoots.removeAll(listOfRoots);
		List<Node> distanceToRootForTrgt2 = new ArrayList<>();
		distanceToRootForTrgt2.addAll(df.distanceToRoot(targetNode2));
		listOfRoots.removeAll(listOfRoots);
		
		int index1 = 0;
		int index2 = 0;
		
		for (Node node : distanceToRootForTrgt1) {
			if(distanceToRootForTrgt2.contains(node)){
				index1 = distanceToRootForTrgt1.indexOf(node);
				index2 = distanceToRootForTrgt2.indexOf(node);
				break;
			}
		}
		
		System.out.println("Distance is : " + (index1+index2));
		
	}

	private List<Node> distanceToRoot(Node targetNode) {
		 if(targetNode != null){
			 listOfRoots.add(targetNode);
			 distanceToRoot(targetNode.root);
		 }
		return listOfRoots;
	}

}
