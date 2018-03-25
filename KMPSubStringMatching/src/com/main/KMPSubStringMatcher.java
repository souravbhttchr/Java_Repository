package com.main;

public class KMPSubStringMatcher {

	public static void main(String[] args) {
		String text = "AABAACAADAABABCAABAABAABAABAC";
		String pattern = "AABABCAAB";
		
		int[] prefixArray = prefixArrayBuilder(pattern);
		
		int position = subStringFinder(text, pattern, prefixArray);
		
		System.out.println(position == -1 ? "Pattern not found in the text."  : "Pattern found in the text. The position is : " + position);
	}

	private static int subStringFinder(String text, String pattern, int[] prefixArray) {
		int textIndex = 0;
		int patternIndex = 0;
		boolean isTextFindComplete = false;
		int returnVal = 0;
		
		while(!isTextFindComplete){
			if(text.charAt(textIndex) == pattern.charAt(patternIndex)){
				textIndex++;
				patternIndex++;
			} else if(patternIndex != 0 && text.charAt(textIndex) != pattern.charAt(patternIndex)){
				if(prefixArray[patternIndex] != patternIndex){
					patternIndex = prefixArray[patternIndex];
				} else{
					patternIndex = 0;
				}
			} else if(patternIndex == 0 && text.charAt(textIndex) != pattern.charAt(patternIndex)){
				textIndex++;
			}
			
			if(patternIndex == prefixArray.length){
				isTextFindComplete = true;
				returnVal = textIndex-prefixArray.length;
			}
			
			if(textIndex == text.length() && isTextFindComplete == false){
				break;
			}
		}
		return (isTextFindComplete ? returnVal : -1);
	}

	private static int[] prefixArrayBuilder(String pattern) {
		int[] prefixArr = new int[pattern.length()];
		int j = 0;
		int i = 1;
		prefixArr[j] = 0;
		boolean isPrefixArrayPopulationComplete = false;
		
		while(!isPrefixArrayPopulationComplete){
			if(j == 0 && pattern.charAt(j) != pattern.charAt(i)){
				prefixArr[i] = j;
				i++;
			} else if(j != 0 && pattern.charAt(j) != pattern.charAt(i)){
				j = prefixArr[j-1];
			} else if(pattern.charAt(j) == pattern.charAt(i)){
					prefixArr[i] = j + 1;
					j++;
					i++;
			}
			if(i == prefixArr.length){
				isPrefixArrayPopulationComplete = true;
			}
		}
		return prefixArr;
	}
}
