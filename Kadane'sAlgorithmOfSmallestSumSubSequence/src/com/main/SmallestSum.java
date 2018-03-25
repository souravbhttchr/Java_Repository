package com.main;

public class SmallestSum {

	public static void main(String[] args) {

		int[] arr = {-5,8,3,-4,12,15,-25,20};
		
		int smallestSum = smallestSumCalculator(arr, arr.length);
		
		System.out.println(smallestSum);
	}

	private static int smallestSumCalculator(int[] arr, int num) {

		int sum = 0, result = 0;
		
		for(int i=0; i<num; i++){
			if(sum+arr[i] < 0){
				sum += arr[i];
			}
			else{
				sum = 0;
			}
			
			if(sum < result){
				result = sum;
			}
		}
		
		return result;
	}
}
