package com.main;

import java.util.HashSet;
import java.util.Set;

public class CharDuplicateFinder {

	private char[] arr = {'g','o','o','g','l','e'};
	
	public static void main(String[] args) {
		CharDuplicateFinder cdf = new CharDuplicateFinder();
		System.out.println(cdf.findCharDuplicate(cdf.arr));
	}

	private int findCharDuplicate(char[] arr) {
		Set<Character> setOfChars = new HashSet<>();
		int lengthOfArr = arr.length;
		int indexOfDuplicate = -5;
		
		for(int i=0; i<lengthOfArr; i++){
			if(!setOfChars.contains(arr[i])){
				setOfChars.add(arr[i]);
			}
			else{
				indexOfDuplicate = i;
				break;
			}
		}
		
		return indexOfDuplicate+1;
	}

}
