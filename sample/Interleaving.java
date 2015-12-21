package sample;

/*
 * Check if one string is the interleaving of the other
 * 
 * Author : Aamin Lakhani
 */
public class Interleaving {
	
	public static boolean isInterLeaved(String a, String b, String c) {
		
		char[] firstString = a.toCharArray();
		char[] secondString = b.toCharArray();
		char[] finalString = c.toCharArray();
		
		boolean[][] IL = new boolean[a.length() + 1][b.length() + 1];
		
		if (a.length() + b.length() != c.length()) {
			return false;
		}
		
		for (int i = 0; i <= a.length(); i++) {
			for (int j = 0; j <= b.length(); j++) {
				
				if (i == 0 && j== 0) {
					IL[i][j] = true;
				}
				else if (i == 0 && secondString[j-1] == finalString[j-1]) {
					IL[i][j] = IL[i][j-1]; 
				}
				else if (j == 0 && firstString[i-1] == finalString[i-1]) {
					IL[i][j] = IL[i-1][j]; 
				}
				else if ( i != 0 && j != 0) {
					if (firstString[i-1] == finalString[i+j-1] && secondString[j-1] != finalString[i+j-1]) {
						IL[i][j] = IL[i-1][j];
					}
					else if (firstString[i-1] != finalString[i+j-1] && secondString[j-1] == finalString[i+j-1]) {
						IL[i][j] = IL[i][j-1];
					}
					else if (firstString[i-1] == finalString[i+j-1] && secondString[j-1] == finalString[i+j-1]) {
						IL[i][j] = IL[i][j-1] || IL[i-1][j];
					}
				}
				
			}
		}
		return IL[a.length()][b.length()];
	}
	

	public static void main(String args[]) {
		System.out.println(isInterLeaved("XBZ", "ABC", "XBZABC"));
	}
}
