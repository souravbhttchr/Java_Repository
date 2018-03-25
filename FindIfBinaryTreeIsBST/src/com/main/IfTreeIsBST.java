package com.main;

public class IfTreeIsBST {

	private static Node root = new Node(5, null);
	private static String BSTFlag = "Initialized";
	
	public static void main(String[] args) {
		
		root.left = new Node(3, root);
		root.right = new Node(7, root);
		
		CheckBST(root);
		
		if(BSTFlag.equalsIgnoreCase("True")){
			System.out.println("Tree is BST");
		} else if(BSTFlag.equalsIgnoreCase("False")){
			System.out.println("Tree is not BST");
		}
		
	}

	private static void CheckBST(Node root) {

		if(root == null){
			System.out.println("Tree is Empty....");
		} else{
			if(root.getLeft() != null && root.getRight() != null){
				if(root.getLeft().getData() < root.getData() && root.getRight().getData() > root.getData()){
					BSTFlag = "True";
				}
				else{
					BSTFlag = "False";
				}
			}
		}
		
		if(root.getLeft() != null){
			CheckBST(root.getLeft());
		}
		if(root.getRight() != null){
			CheckBST(root.getRight());
		}
	}
}
