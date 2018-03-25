package com.main;

public class MirrorCheck {

	public static void main(String[] args) {
		
		MirrorCheck mc = new MirrorCheck();
		
		Node root1 = new Node(1);
		Node root2 = new Node(1);
		
		root1.left = new Node(3);
		root1.right = new Node(2);
		root1.right.left = new Node(5);
		root1.right.right = new Node(4);
		
		root2.left = new Node(2);
		root2.right = new Node(3);
		root2.left.left = new Node(4);
		root2.left.right = new Node(6);
		
		System.out.println(mc.mirrorChecker(root1, root2));
		
	}

	private boolean mirrorChecker(Node root1, Node root2) {
		
		if(root1 == null && root2 == null){
			return true;
		}else if(root1.getData() != root2.getData()){
			return false;
		}else {
			Node left1 = root1.left;
			Node right1 = root1.right;
			
			root1.left = right1;
			root1.right = left1;
		}
		
		return mirrorChecker(root1.left, root2.left)&& mirrorChecker(root1.right, root2.right);
	}
	
}
