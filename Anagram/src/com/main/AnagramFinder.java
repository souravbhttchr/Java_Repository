package com.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AnagramFinder {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter two strings : "  );
		
		String str1 = sc.next();
		String str2 = sc.next();
		
		AnagramFinder af = new AnagramFinder();
		
		if(str1.length() != str2.length()){
			System.out.println("The Strings are not anagrams.");
		} else if(str1.length() > 0){
			int i = af.checkForAnagram(str1, str2);
			
			System.out.println(i == -1 ? "The strings are not anagrams." : "The Strings are anagrams.");
		}
	}

	private int checkForAnagram(String str1, String str2) {
		Map<Character, Integer> str1Map = new HashMap<>();
		Map<Character, Integer> str2Map = new HashMap<>();
		
		int indicator = 0;
				
		for(int i=0; i<str1.length(); i++){
			if(!str1Map.containsKey(str1.charAt(i))){
				str1Map.put(str1.charAt(i), 1);
			} else{
				str1Map.put(str1.charAt(i), str1Map.get(str1.charAt(i))+1);
			}
		}
		
		for(int i=0; i<str2.length(); i++){
			if(!str2Map.containsKey(str2.charAt(i))){
				str2Map.put(str2.charAt(i), 1);
			} else{
				str2Map.put(str2.charAt(i), str2Map.get(str2.charAt(i))+1);
			}
		}
		
		for (Map.Entry<Character, Integer> entry : str1Map.entrySet()) {
			if(entry.getValue() != str2Map.get(entry.getKey())){
				indicator = -1;
			}
		}
		
		if(indicator != -1){
			return 1;
		} else{
			return indicator;
		}
	}
}
