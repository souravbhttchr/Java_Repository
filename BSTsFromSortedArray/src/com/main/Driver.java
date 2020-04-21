package com.main;

public class Driver {

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4};
		
		int num = findNumOfBSTs(arr.length);
		
		System.out.println(num);
	}

	private static int findNumOfBSTs(int length) {

		int combination = 0;
		
		if(length <= 1) {
			return 1;
		} else if(length == 2) {
			return 2;
		} else if(length == 3) {
			return 5;
		} else if(length > 3) {
			for(int i=0; i<length; i++) {
				
				int left = findNumOfBSTs(i);
				int right = findNumOfBSTs(length - i - 1);
				
				combination += left*right;
			}
			
		}
		return combination;
	}
}
