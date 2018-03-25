package com.main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {

	public static void main(String[] args) {
		String str = "abcd";
		
		Pattern p = Pattern.compile("^+[a-z]$");
		Matcher matcher = p.matcher(str);
		
		boolean validChar = matcher.find();
		
		if(validChar){
			System.out.println("Regex matches...");
		} else{
			System.out.println("Doesn't match....");
		}
		
	}

}
