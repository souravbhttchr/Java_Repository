package com;

import java.util.Scanner;

public class MinimumDays {

	public static void main(String[] args) {

		Scanner sc =new Scanner(System.in);
		
		int A = sc.nextInt();
		int K = sc.nextInt();
		int P = sc.nextInt();
		
		int asha = P;
		int kelly = 0;
		
		MinimumDays md = new MinimumDays();
		
		int minDays = md.findMinDays(asha, kelly, A, K);
		
		System.out.println(minDays);
		
	}

	protected int findMinDays(int asha, int kelly, int a, int k) {

		int days = 1;
		
		if(asha == kelly && a == k) {
			return -1;
		} else if(asha > kelly && a > k) {
			return -1;
		} else {
			while(asha + a >= kelly + k) {
				days ++;
				asha = asha + a;
				kelly = kelly + k;
				if(asha == kelly) {
					break;
				}
			}
			
			return days;
		}
	}

}
