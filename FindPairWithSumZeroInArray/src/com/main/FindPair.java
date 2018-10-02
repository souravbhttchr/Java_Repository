package com.main;

import java.util.HashMap;
import java.util.Map;

public class FindPair {

	public static void main(String[] args) {

		int[] arr = {2,4,8,6,7,3,-3,-4,-6,-2,-8,-7};
		
		Map<Integer, String> mapOfInt = new HashMap<>();
		
		for (int i : arr) {
			mapOfInt.put(i, null);
		}
		
		for (int i : arr) {
			if(mapOfInt.containsKey(-1*i) && mapOfInt.get(-1*i) == null){
				mapOfInt.replace(i, null, "computed");
				mapOfInt.replace(-1*i, null, "computed");

				System.out.println(i + "," + -1*i);
			}
		}
		
	}

}
