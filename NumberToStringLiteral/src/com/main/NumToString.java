package com.main;

public class NumToString {

	private static String number = "15236";
	private static String stringLiteral = "";
	
	public static void main(String[] args) {
		
		int start = 1;
		int end = 10;
		
		char[] numberToCharArr = number.toCharArray();
		
		int lengthOfNumber = numberToCharArr.length;
		
		NumToString nts = new NumToString();
		
		nts.num2String(lengthOfNumber);
		
		System.out.println(stringLiteral);
	}

	private void num2String(int lengthOfNumber) {
		
		String[] single_digit_num = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		String[] double_digit_num = {"ten","eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", 
				"seventeen", "eighteen", "nineteen"};
		String[] decimal_num = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
		String[] units = {"hundred", "thousand", "lakh", "million", "billion"};
		
		for(int i=1; i<=lengthOfNumber; i++){
			int remainder = Integer.parseInt(number) % (int)Math.pow(10, i);
			
			if(i == 2){
				int secondDigit = remainder/10;
				if(secondDigit == 0){
					stringLiteral = single_digit_num[remainder%10 - 1] + " " + stringLiteral;
				} else if(secondDigit == 1){
					int first_digit = remainder%10;
					stringLiteral = double_digit_num[first_digit] + " " + stringLiteral;
				} else{
					int first_digit = remainder%10;
					if(first_digit != 0){
						stringLiteral = single_digit_num[first_digit - 1] + " " + stringLiteral;
						stringLiteral = decimal_num[secondDigit - 2] + " " + stringLiteral;
					}
				}
					
			}
			
			if(i == 3){
				int thirdDigit = remainder/100;
				if(thirdDigit != 0){
					stringLiteral = single_digit_num[thirdDigit - 1] + " " + units[0] + " " + stringLiteral;
				}
			}
			
			if(i == 5){
				int fifthDigit = remainder/10000;
				if(fifthDigit == 0){
					stringLiteral = single_digit_num[remainder%10000 - 1] + " " + units[1] + " " + stringLiteral;
				} else if(fifthDigit == 1){
					int fourth_digit = (remainder/1000)%10;
					stringLiteral = double_digit_num[fourth_digit] + " " + units[1] + " " + stringLiteral;
				} else{
					int fourth_digit = (remainder/1000)%10;
					if(fourth_digit != 0){
						stringLiteral = single_digit_num[fourth_digit - 1] + " " + units[1] + " " + stringLiteral;
						stringLiteral = decimal_num[fifthDigit - 2] + " " + stringLiteral;
					}
				}
			}
			
		}
	}

}
