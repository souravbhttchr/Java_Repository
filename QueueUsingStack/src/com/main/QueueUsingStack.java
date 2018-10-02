package com.main;

import java.util.Stack;

public class QueueUsingStack {

	static class Queue{
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
	}

	public void enQueue(Queue q, int x){
		
		while(!q.stack2.isEmpty()){
			int val = q.stack2.pop();
			q.stack1.push(val);
		} 
			q.stack1.push(x);
	}
	
	public synchronized Integer deQueue(Queue q){
		if(q.stack1.isEmpty() && q.stack2.isEmpty()){
			return null;
		} else {
			while(!q.stack1.isEmpty()){
				int val = q.stack1.pop();
				q.stack2.push(val);
			}
			
			return q.stack2.pop();
		}
	}
	
	public static void main(String[] args) {
		
		QueueUsingStack qus = new QueueUsingStack();
		
		Queue q = new Queue();
		
		qus.enQueue(q, 5);
		qus.enQueue(q, 8);
		qus.enQueue(q, 3);
		qus.enQueue(q, 1);
		qus.enQueue(q, 9);
		qus.enQueue(q, 33);
		qus.enQueue(q, 98);
		
		for(int i=0; i<3; i++){
			try{
			int k = qus.deQueue(q);
			System.out.println(k);
			} catch (Exception e){
				if(e.getClass() == NullPointerException.class){
					System.out.println("Queue is empty...");
					break;
				}
			}
			
		}
	}
}
