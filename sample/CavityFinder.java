package sample;
/*
 * Sample Cavity Finder program
 * Author : Aamin Lakhani
 */
public class CavityFinder {

	private static void markCavities(char[][] inputDepths) {
		
		//cavities cannot be on the border and the adjacent elements in all four directions are less than the current element
		for (int i = 1; i < inputDepths.length - 1; i++) {
			for (int j = 1; j < inputDepths[0].length - 1; j++) {
				
				//check top, bottom, left and right
				if (inputDepths[i-1][j] < inputDepths[i][j] &&
					inputDepths[i+1][j] < inputDepths[i][j]	&&
					inputDepths[i][j-1] < inputDepths[i][j] &&
					inputDepths[i][j+1] < inputDepths[i][j]) {
					inputDepths[i][j] = 'X';
				}
			}
		}
		
		for (int i =0; i < inputDepths.length; i++) {
			for (int j = 0; j < inputDepths[0].length; j++) {
				System.out.print(inputDepths[i][j]+ " ");
			}
			System.out.println();
		}
	}
	
	public static void main (String args[]) {
		char[][] inputDepths = { {'1', '1', '1', '2'},
								{'1', '9', '1', '2'},
								{'1', '8', '9', '2'},
								{'1', '2', '3', '4'}
		                      };
		
		markCavities(inputDepths);
	}
}
