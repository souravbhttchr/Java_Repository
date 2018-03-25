package com.main;

import java.util.HashMap;
import java.util.Map;

public class FindMajorityElem {

	private static int majorElem = 0;
	private static int maxCount = 0;
	
	public static void main(String[] args) {
		int[] arr = {3, 3, 4, 2, 4, 4, 2, 4, 4};
		FindMajorityElem fme = new FindMajorityElem();
		fme.find(arr);
		
		System.out.println(maxCount > arr.length/2 ? majorElem : "NONE");
	}

	private void find(int[] arr) {
		Map<Integer, Integer> mapOfElem = new HashMap<>();
		
		for(int i=0; i<arr.length; i++){
			if(!mapOfElem.containsKey(arr[i])){
				mapOfElem.put(arr[i], 1);
				if(maxCount < 1){
					majorElem = arr[i];
					maxCount = 1;
				}
			} else {
				mapOfElem.put(arr[i], mapOfElem.get(arr[i])+1);
				int val = mapOfElem.get(arr[i]);
				if(maxCount < val){
					maxCount = val;
					majorElem = arr[i];
				}
			}
		}
	}
}
