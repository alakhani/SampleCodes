package sample;
/*
 * Sample program to print a tree like structure
 * 
 *  #
   ##
  ###
 ####
#####

Author : Aamin Lakhani
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintTreeStructure {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.println("Enter the number of lines");
			String n = br.readLine();
			
			if (n.equals("EXIT")) {
				break;
			}
			int num = Integer.parseInt(n);
			for (int i = 1; i <= num; i++) {
				int nos = num - i;
				for (int j = 1; j <= num; j++) {
					if (j <= nos) {
						System.out.print(" ");
					} else {
						System.out.print("#");
					}
				}

				System.out.println();
			}
		}

	}
}
