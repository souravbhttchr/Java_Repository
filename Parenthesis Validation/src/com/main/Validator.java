package com.main;

import java.util.Scanner;

public class Validator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter the Parenthesis Combination....");
		String parenthesis = sc.next();
		
		Validator validator = new Validator();
		validator.validate(parenthesis);
	}

	private void validate(String parenthesis) {

		char[] parenthesisChar = parenthesis.toCharArray();
		int validateFlag = 0;
		
		StackImpl stack = new StackImpl();
		
		for (char c : parenthesisChar) {
			if(c == '(' || c == '{' || c== '['){
				stack.push(c);
			} else{
				char poppedElem = stack.pop();
				if(poppedElem == '\n' || c != poppedElem){
					validateFlag++;
				}
			}
		}
		
		if(validateFlag == 0){
			System.out.println("Parenthesis combination is valid....");
		} else{
			System.out.println("Parenthesis combination is not valid....");
		}
	}
}
