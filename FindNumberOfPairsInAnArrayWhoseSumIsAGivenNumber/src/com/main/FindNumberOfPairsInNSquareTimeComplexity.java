package com.main;

public class FindNumberOfPairsInNSquareTimeComplexity {

	private static int[] arr = {2,0,5,3,6,7,11,1,4,15,8,23};
	private static int sum = 9;
	
	public static void main(String[] args) {
		FindNumberOfPairsInNSquareTimeComplexity fnp = new FindNumberOfPairsInNSquareTimeComplexity();
		
		int num = fnp.findNumber(arr);
		System.out.println(num);
	} 

	private int findNumber(int[] arr) {
		int result = 0;
		for(int i=0; i<arr.length; i++){
			int remainder = sum;
			if(arr[i] < sum){
				remainder -= arr[i];
				boolean isFound = searchRemainder(remainder, i+1, arr.length-1);
				if(isFound){
					result ++;
				}
			}
		}
		return result;
	}

	private boolean searchRemainder(int remainder, int i, int j) {
		boolean result = false;
		for(int index=i; index<=j; index++){
			if(arr[index] == remainder){
				result = true;
				break;
			}
		}
		return result;
	}
}
