package sample;

import java.util.Random;
/*
 * Sample program to determine live and dead neighbours based on certain rules
 * Author : Aamin Lakhani
 */
public class LiveNeighbours {


	public static int[][] generateMatrix (int noOfRows, int noOfCols) {

		int matrix[][] =  new int [noOfRows][noOfCols];
		Random rand =  new Random();
		for (int i = 0; i < noOfRows; i++) {
			for (int j =0; j < noOfCols; j++) {
				matrix[i][j] = rand.nextInt(2);
			}
		}

		return matrix;
	}

	public static int [][] live (int [][] matrix, int noOfIterations) {

		int [][] temp = new int[matrix.length][matrix[0].length];

		for (int k = 0; k < noOfIterations; k++) {
			for ( int  i = 0; i < matrix.length; i++) {
				for (int j = 0 ; j < matrix[0].length; j++) {
					temp[i][j] = newValue(liveNeighboursCount(matrix, i, j),matrix[i][j]);
				}
			}
		}
		return temp;
	}

	public static int liveNeighboursCount(int[][] matrix, int i, int j){
		int count = 0;

		//check top
		if (i-1 > 0 && matrix[i-1][j] == 1) {
			count ++;
		}
		//check left
		if (j-1 > 0 && matrix[i][j-1] == 1) {
			count ++;
		}
		//check right
		if (j+1 < matrix[0].length && matrix[i][j+1] == 1) {
			count ++;
		}
		//check bottom 
		if (i+1 < matrix.length && matrix[i+1][j] == 1) {
			count ++;
		}
		//check topleft
		if (i-1 > 0 && j-1 > 0 && matrix[i-1][j-1] == 1) {
			count ++;
		}
		//check topright
		if (i-1 > 0 && j+1 < matrix[0].length && matrix[i-1][j+1] == 1) {
			count ++;
		}
		
		//check bottom left
		if (i + 1 < matrix.length && j-1 > 0 && matrix[i+1][j-1] == 1) {
			count ++;
		}
		
		//check bottom right
		if (i + 1 < matrix.length && j+1 < matrix[0].length && matrix[i+1][j+1] == 1) {
			count ++;
		}
		
		return count;
	}
	
	public static int newValue (int liveCellCount, int currentValue) {
		
		if (currentValue == 1 && (liveCellCount < 2 || liveCellCount > 3)) {
			return 0;
		}
		if (currentValue == 0 && liveCellCount ==3) {
			return 1;
		}
		
		return currentValue;
	}
	
	public static void printMatrix(int [][] matrix) {
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static void main (String args[]) {

		int noOfRows = 4;
		int noOfCols = 4;
		
		int[][] orignalMatrix = generateMatrix(noOfRows, noOfCols);
		System.out.println("Orignal matrix");
		printMatrix(orignalMatrix);
		int[][] finalMatrix = live(orignalMatrix, 5);
		System.out.println("Final matrix");
		printMatrix(finalMatrix);

	}
}
