package com.main;

import com.others.Calculate;

public class MainClass {

	public static void main(String[] args) {

		int[] arr = {4, 8, 2, 5, 1, 6, 3, 7};
		int firstElem = 0;
		int lastElem = arr.length-1;
		int k = 3;
		
		Calculate cal = new Calculate();
		
		int val = cal.findKthLargestNumber(arr, firstElem, lastElem, k);
		
		System.out.println(val);
	}

}
