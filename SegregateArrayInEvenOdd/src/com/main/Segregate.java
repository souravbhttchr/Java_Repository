package com.main;

//Time complexity O(n^2)

public class Segregate {

	private static int[] arr = {10,5,3,12,15,18,20,27,32,25,11,48,52};
	
	public static void main(String[] args) {
		segregateEvenOdd();
		
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	private static void segregateEvenOdd() {
		int front = 0;
		int key = 0;
		
		for(int i = 0; i<arr.length; i++){
			if(arr[i]%2 == 0){
				front += 1;
				key = front;
			} else{
				while(key < arr.length-1){
					key += 1;
					if(arr[key]%2 == 0){
						exchange(front, key);
						front += 1;
						key = front;
						break;
					} else{
						continue;
					}
				}
				if(key == arr.length-1){
					break;
				}
			}
		}
	}

	private static void exchange(int front, int key) {
		int c = arr[front];
		arr[front] = arr[key];
		arr[key] = c;
	}
}
