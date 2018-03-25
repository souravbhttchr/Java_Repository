package com.main;

public class FindMaxConsecutiveChar {

	public static void main(String[] args) {
		String str = "aaaaabbbbbbbbbbcccccccddeeee";
		
		char temp = str.charAt(0);
		char maxConsecutive = str.charAt(0);
		int tempLength = 1;
		int maxLength = 1;
		
		for(int i=1; i<str.length(); i++){
			if(str.charAt(i) == temp){
				tempLength++;
			} else if(tempLength > maxLength){
				maxLength = tempLength;
				maxConsecutive = temp;
				temp = str.charAt(i);
				tempLength = 1;
			} else{
				temp = str.charAt(i);
				tempLength = 1;
			}
		}
		
		System.out.println(maxConsecutive);
	}

}
