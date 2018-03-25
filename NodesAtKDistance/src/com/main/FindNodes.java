package com.main;

import java.util.HashSet;
import java.util.Set;

public class FindNodes {

	private static Node root = new Node(5, null);
	private static Node targetNode = null;
	private static Set<Integer> setOfNodes = new HashSet<>();
	
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
		
		targetNode = root.left;
		targetNode.setVisited(true);
		
		FindNodes find = new FindNodes();
		
		find.findNodeVal(targetNode, 3);
		
		System.out.println(setOfNodes);
	}

	private void findNodeVal(Node target, int k) {
		
		lowerNodes(target, k);
		upperNodes(target, k);
	}

	private void lowerNodes(Node target, int k) {
		
		if(k == 0 && target.isVisited == false){
			setOfNodes.add(target.getData());
			target.setVisited(true);
		}
		else if(k > 0){
			if(target.left == null && target.right == null){
				return;
			} else {
				if(target.left != null){
					if(k-1 != 0){
						target.left.setVisited(true);
						lowerNodes(target.left, k-1);
					} else{
						lowerNodes(target.left, k-1);
					}
				}
				if(target.right != null){
					if(k-1 != 0){
						target.right.setVisited(true);
						lowerNodes(target.right, k-1);
					} else{
						lowerNodes(target.right, k-1);
					}
				}
			}
		}
	}
	
	private void upperNodes(Node target, int k) {
		if(k == 0 && target.isVisited == false){
			setOfNodes.add(target.getData());
			target.setVisited(true);
		} else{
			if(target.root != null){
				if(k-1 != 0){
					target.root.setVisited(true);
					lowerNodes(target.root, k-1);
					upperNodes(target.root, k-1);
				} else{
					upperNodes(target.root, k-1);
				}
			}
		}
	}
}
