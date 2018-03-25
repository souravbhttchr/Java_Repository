package com.main;

public class StackImpl {

	private int top = -1;
	private char[] stack = new char[100];
	
	public void push(char c){
		if(top == 99){
			System.out.println("Stack full");
		} else{
			stack[++top] = c;
		}
	}
	
	public char pop(){
		if(top == -1){
			System.out.println("Stack is empty");
			return '\n';
		} else{
			char poppedElem = stack[top--];
			return poppedElem;
		}
	}
}
