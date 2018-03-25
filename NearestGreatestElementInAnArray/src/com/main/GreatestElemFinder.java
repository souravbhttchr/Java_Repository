package com.main;

import java.util.ArrayList;
import java.util.List;

public class GreatestElemFinder {
	
	private static List<Integer> listOfGreatestElem = new ArrayList<>();
	
	public static void main(String[] args) {
		int[] arr = {12,5,8,1,3,6,11,9,7};
		
		GreatestElemFinder gef = new GreatestElemFinder();
		int startIndex = 0;
		gef.find(startIndex, arr);
		
		System.out.println(listOfGreatestElem);
	}

	private void find(int startIndex, int[] arr) {
		if(arr.length == 0){
			System.out.println("Blank Array...");
		} else if(startIndex < arr.length-1){
			int max = 0;
			int maxIndex = 0;
			for(int i=startIndex+1; i<arr.length; i++){
				if(arr[i] > max){
					max = arr[i];
					maxIndex = i;
				}
			}
			
			for(int i=startIndex; i<maxIndex; i++){
				listOfGreatestElem.add(arr[maxIndex]);
			}
			
			find(maxIndex, arr);
		} else if(startIndex == arr.length-1){
			listOfGreatestElem.add(arr[0] < listOfGreatestElem.get(0) ? listOfGreatestElem.get(0) : arr[0]);
		}
	}
}
