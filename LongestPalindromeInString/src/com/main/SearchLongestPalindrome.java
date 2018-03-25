package com.main;

public class SearchLongestPalindrome {

	private static int maxLength = 0;
	
	public static void main(String[] args) {
		String testString = "aaaaaaaabababababa";
		int firstCharOfString = 0;
		
		SearchLongestPalindrome slp = new SearchLongestPalindrome();
		slp.search(testString, firstCharOfString);
		
		System.out.println("The length of the longest palindrome is : " + maxLength);
	}

	private void search(String testString, int firstCharOfString) {
		
		String testedString = "";
		
		for(int i=firstCharOfString; i<testString.length(); i++){
			if(i == firstCharOfString){
				testedString = testedString+testString.charAt(i);
			} else{
				if (testString.length() >= i + testedString.length()) {
					if ((reverseString(testedString+testString.charAt(i))).equals(testedString+testString.charAt(i))) {
						testedString = testedString + testString.charAt(i);
					}
				}
			}
		}
		if(maxLength < testedString.length()){
			maxLength = testedString.length();
		}
		
		if(firstCharOfString+1 <= testString.length()){
			search(testString, firstCharOfString+1);
		}
	}

	private String reverseString(String testedString) {
		String returnString = "";
		
		for(int i=testedString.length()-1; i>=0; i--){
			returnString = returnString + testedString.charAt(i);
		}
		return returnString;
	}
}
