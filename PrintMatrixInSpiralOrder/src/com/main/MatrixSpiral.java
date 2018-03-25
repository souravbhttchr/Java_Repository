package com.main;

public class MatrixSpiral {

	private static int startingRowIndex = 0;
	private static int startingColumnIndex = 0;
	
	public static void main(String[] args) {

		int[][] matrix = {{1,2,3,4,5},
						  {6,7,8,9,10},
						  {11,12,13,14,15},
						  {16,17,18,19,20},
						  {21,22,23,24,25}};
		
		int rows = matrix.length;
		int columns = matrix[0].length;
		
		int i = 0;
		int j = 0;
		
		MatrixSpiral ms = new MatrixSpiral();
		
		ms.printSpiral(i, j, rows, columns, matrix);
	}

	private void printSpiral(int i, int j, int rows, int columns, int[][] matrix) {
		if(i == startingRowIndex+1 && j == startingColumnIndex){
			System.out.print(" "+matrix[i][j]);
			
			startingRowIndex = startingRowIndex+1;
			startingColumnIndex = startingColumnIndex+1;
			
			rows = rows-1;
			columns = columns-1;
			
			printSpiral(startingRowIndex, startingColumnIndex, rows, columns, matrix);
		}
		
		System.out.print(" "+matrix[i][j]);
		
		if (i < j) {
			if (j < columns - 1) {
				printSpiral(i, j + 1, rows, columns, matrix);
			} else {
				if (i <= rows - 1) {
					printSpiral(i + 1, j, rows, columns, matrix);
				}
			}
		} else if(i > j){
			if (j > startingColumnIndex) {
				printSpiral(i, j - 1, rows, columns, matrix);
			} else {
				if (i > startingRowIndex - 1) {
					printSpiral(i - 1, j, rows, columns, matrix);
				}
			}
		} else if(i == j && i == startingRowIndex && j == startingColumnIndex){
			printSpiral(i, j+1, rows, columns, matrix);
		} else{
			printSpiral(i, j-1, rows, columns, matrix);
		}
		
	}

}
