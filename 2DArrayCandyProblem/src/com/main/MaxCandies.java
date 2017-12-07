package com.main;

public class MaxCandies {

	private static int totalSum = 0;
	
	public static void main(String[] args) {
		int matrix[][] = {{2,4,1,100},
				  		  {8,6,5,1},
				  		  {3,1,8,4},
				  		  {5,2,7,9}};
		
		int rows = matrix.length,column = matrix[0].length;
		
		
		System.out.println("rows : "+rows );
		System.out.println("columns : "+column);
		
		int sum=0;

		FindTheTotalSum(0,0,sum,rows,column,matrix);

		System.out.println(totalSum);
		
		}

	private static void FindTheTotalSum(int i, int j, int sum, int rows, int column, int[][] arr) {

		if ((i == column - 1) && (j == rows - 1)) {
			System.out.println(sum + " sum of the path");
			if(sum > totalSum){
				totalSum = sum;
			}
		}
		sum = sum + arr[j][i];
		if (i < column - 1) {
			FindTheTotalSum(i + 1, j, sum, rows, column, arr);
		}
		if (j < rows - 1) {
			FindTheTotalSum(i, j + 1, sum, rows, column, arr);
		}

	}

}
