package com.main;

import java.util.Scanner;

public class FindMinSequence {

	public static void main(String[] args) {
		System.out.println("Enter sequence of M and N :");
		
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		char[] inputChar = input.toCharArray();
		
		FindMinSequence fms = new FindMinSequence();
		fms.find(inputChar);
	}

	private void find(char[] inputChar) {
		
		int[] arrOfElem = new int[inputChar.length+1];
		
		for (int i = 1; i <= inputChar.length+1; i++) {
			arrOfElem[i-1] = i;
		}
		
		for(int i = 0; i<inputChar.length; i++){
			if(inputChar[i] == 'M'){
				if(i == 0){
					int temp = arrOfElem[i];
					arrOfElem[i] = arrOfElem[i+1];
					arrOfElem[i+1] = temp;
				} else{
					int j = i-1;
					while(!(j < 0) && inputChar[j] != 'N'){
						j--;
					}
					for(int k = i; k > j; k--){
						int temp2 = arrOfElem[k];
						arrOfElem[k] = arrOfElem[k+1];
						arrOfElem[k+1] = temp2;
					}
				}
			}
		}
		
		System.out.print("The smallest Number is : ");
		for (int i : arrOfElem) {
			System.out.print(i);
		}
	}
}
