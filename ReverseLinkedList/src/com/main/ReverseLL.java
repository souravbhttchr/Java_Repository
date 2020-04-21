package com.main;

public class ReverseLL {

	public static void main(String[] args) {
		
		Node ll = new Node(1);
		ll.setNext(new Node(2));
		ll.getNext().setNext(new Node(3));
		ll.getNext().getNext().setNext(new Node(4));
		ll.getNext().getNext().getNext().setNext(new Node(5));
		
		System.out.println("Before reversing....");
		printLL(ll);
		
		if(ll != null) {
			ll = reverse(ll);
		}
		
		System.out.println("After reversing....");
		printLL(ll);
	}

	private static void printLL(Node ll) {
		while(ll != null) {
			System.out.println(ll.getVal());
			ll = ll.getNext();
		}
	}

	private static Node reverse(Node ll) {

		Node currentNode = ll;
		Node nextNode = currentNode.getNext();
		Node nextToNextNode = nextNode.getNext();
		
		while(nextNode != null) {
			if(currentNode == ll) {
				currentNode.setNext(null);
			}
			
			if(nextToNextNode == null) {
				ll = nextNode;
				nextNode.setNext(currentNode);
				break;
			}
			
			nextNode.setNext(currentNode);
			currentNode = nextNode;
			nextNode = nextToNextNode;
			nextToNextNode = nextToNextNode.getNext();
		}
		return ll;
	}
}
