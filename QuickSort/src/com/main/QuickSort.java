package com.main;

public class QuickSort {

	private static int[] arr = {6,2,8,4,5,9,12,21,1,3,18};
	
	public static void main(String[] args) {
		int start = 0;
		int end = arr.length-1;
		
		quickSort(start, end);
		
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
	
	public static void quickSort(int start, int end){
		if (start < end) {
			int q = partition(start, end);
			quickSort(start, q-1);
			quickSort(q+1, end);
		}
		
	}
	
	public static int partition(int start, int end){
		int x = arr[end];
		int i = start-1;
		for(int j=start; j<end; j++){
			if(arr[j] <= x){
				i += 1;
				exchange(i, j);
			}
		}
		exchange(i+1, end);
		
		return i+1;
	}

	private static void exchange(int i, int j) {
		int c = arr[i];
		arr[i] = arr[j];
		arr[j] = c;
	}
}
