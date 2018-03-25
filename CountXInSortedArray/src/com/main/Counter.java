package com.main;

public class Counter {

	int[] arr = {1,2,2,3};
	int x = 2;
	int left = -1;
	int right = -1;

	public static void main(String[] args) {

		Counter c = new Counter();

		if (c.arr.length == 0) {
			System.out.println("Error!! Array is blank.....");
		} else if (c.arr.length == 1) {
			if (c.arr[0] == c.x) {
				System.out.println(1);
			} else {
				System.out.println(c.x + " is not present in the array.....");
			}
		} else {
				int countVal = c.count(c.arr, 0, c.arr.length - 1);
				
				if(c.right >= 0 && c.left >= 0){
					System.out.println(countVal);
				}
			else{
				System.out.println(0);
			}
		}
	}

	private int count(int[] arr, int start, int end) {

		if (end >= start) {

			int mid = (start + end) / 2;

			if (arr[mid] > x) {
				count(arr, start, mid - 1);
			}
			if (arr[mid] < x) {
				count(arr, mid + 1, end);
			}
			if (arr[mid] == x) {
				if (arr[mid - 1] < x) {
					left = mid;
				} else if (left < 0) {
					count(arr, start, mid - 1);
				}

				if (arr[mid + 1] > x) {
					right = mid;
				} else if (right < 0) {
					count(arr, mid + 1, end);
				}
			}
		}
		return right - left + 1;
	}
}
