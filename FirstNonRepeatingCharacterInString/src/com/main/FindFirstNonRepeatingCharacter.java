package com.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FindFirstNonRepeatingCharacter {

	public static void main(String[] args) {
		String str = "zacacacaacbjbjypjkytyoptpqtqrrqrwq";
		Map<Character, Integer> mapChar = new HashMap<>();

		for(int i=0; i<str.length(); i++){
			if(!mapChar.containsKey(str.charAt(i))){
				mapChar.put(str.charAt(i), i+119);
			} else{
				int num = mapChar.get(str.charAt(i));
				mapChar.put(str.charAt(i), num+119);
			}
		}
		
		Set<Character> charsInMap = mapChar.keySet();
		//boolean isFound = false;
		int index = Integer.MAX_VALUE;
		char charFound = 'x';
		
		for (char ch : charsInMap) {
			if(mapChar.get(ch) / 119 == 1){
				if(index > mapChar.get(ch) % 119){
					index = mapChar.get(ch);
					charFound = ch;
				}
			}
		}
		System.out.println(charFound);
		
		/*if(!isFound){
			System.out.println("No Such Character...");
		}*/
	}

}
