package com.main;

public class FindMaxPower {

	private static int maxPower = 0;
	
	public static void main(String[] args) {
		
		double num = 0.0009765625;
		
		int maxPow = findMax(num);
		
		System.out.println(maxPow);
		
	}

	private static int findMax(double num) {
		
		if(num > 2 || num < -2) {
			double newNum = 0;
			
			if(num < 0) {
				newNum = num * -1;
			} else {
				newNum = num;
			}
			
			double sqrt =  Math.sqrt(newNum);
			for(int i=2; i <= sqrt; i++) {
				int j = 0;
				while(Math.pow(i, j) <= newNum) {
					double pow =  Math.pow(i, j);
					if(pow == newNum) {
						if(num > 0) {
							if (maxPower < j) {
								maxPower = j;
							}
						} else {
							if (maxPower > j) {
								maxPower = j;
							}
						}
						break;
					} else {
						j++;
					}
				}
			}
		} else if(num < 1 && num > 0) {
			double newNum = 1/num;
			maxPower = Integer.MAX_VALUE;
			int maxPow = findMax(newNum * -1);
			maxPower = maxPow * -1;
		} else if(num == 2 || num == -2) {
			maxPower = 1;
		}
		
		return maxPower;
	}

}
