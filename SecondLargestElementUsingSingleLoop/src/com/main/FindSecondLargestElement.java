package com.main;

public class FindSecondLargestElement {

	public static void main(String[] args) {
		int[] arr = {16,5,1,10,8,13,11,12,-17,9,15};
		
		int largest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;
		
		for (int i : arr) {
			if(i > largest){
				secondLargest = largest;
				largest = i;
			}
			if(i > secondLargest && i < largest){
				secondLargest = i;
			}
		}
		
		System.out.println(secondLargest);
	}
}
