package com.others;

public class Calculate {

	int val = 0;
	
	public int findKthLargestNumber(int[] arr, int firstElem, int lastElem, int k) {
		
		if(!(lastElem > firstElem)){
			val = arr[lastElem];
		}
		
		else{
			int index = partition(arr, firstElem, lastElem);
			
			if(index == k-1){
				val = arr[index];
			}
			
			if(index < k-1){
				findKthLargestNumber(arr, index+1, lastElem, k);
			}
			
			if(index > k-1){
				findKthLargestNumber(arr, 0, index-1, k);
			}
		}
		
		return val;
	}
	
	private int partition(int[] arr, int firstElem,int lastElem){
		int pivot = arr[lastElem];
		int i=firstElem-1;
		
			for(int j=firstElem; j<lastElem; j++){
				if(arr[j] > pivot){
					i += 1;
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			
			int temp2 = arr[i+1];
			arr[i+1] = pivot;
			arr[lastElem] = temp2;
		
		return i+1;
	}

}
