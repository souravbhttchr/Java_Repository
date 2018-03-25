package com.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DateWithoutLibrary {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a date in dd/mm/yyyy or dd/MMM/yyyy format : ");
		String date = sc.next();
		
		String[] dayMonthYear = date.split("/");
		
		String day = dayMonthYear[0];
		String month = dayMonthYear[1];
		
		Map<String, Integer> monthCount = new HashMap<>();
		monthCount.put("JAN", 1);
		monthCount.put("FEB", 2);
		monthCount.put("MAR", 3);
		monthCount.put("APR", 4);
		monthCount.put("MAY", 5);
		monthCount.put("JUN", 6);
		monthCount.put("JUL", 7);
		monthCount.put("AUG", 8);
		monthCount.put("SEP", 9);
		monthCount.put("OCT", 10);
		monthCount.put("NOV", 11);
		monthCount.put("DEC", 12);
		
		int dayInt = Integer.parseInt(day);
		int monthInt = 0;
		
		try{
			monthInt = Integer.parseInt(month);
		}
		catch(Exception e){
		}
		
		if(monthInt != 0){
			if(dayInt == monthInt){
				System.out.println("TRUE");
			}
			else{
				System.out.println("FALSE");
			}
		} else{
			if(monthCount.get(month) == dayInt){
				System.out.println("TRUE");
			}
			else{
				System.out.println("FALSE");
			}
		}
	}
}
