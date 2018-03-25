package com.main;

public class CalculateBSTs {

	int[] arr = {1,2,3,4};
	
	public static void main(String[] args) {
		
		CalculateBSTs cal = new CalculateBSTs();
		
		System.out.println(cal.calculate(cal.arr, 0, cal.arr.length-1));
	}
	
	public int calculate(int[] arr, int start, int end){
		
		int left = 0;
		int right = 0;
		int sum = 0;
		
		if(end - start <= 0){
			return 1;
		}
		else if(end - start == 1){
			return 2;
		}
		
		for (int i = start; i <= end; i++) {
			left = calculate(arr, start, i-1);
			right = calculate(arr, i+1, end);
			
			sum += left*right;
			left = right = 0;
		}
		
		return sum;
	}
	
}
