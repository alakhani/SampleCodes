package sample;

/*
 * Find the prime numbers using sieve of eratosthenes method
 * 
 * Author : Aamin Lakhani
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeSieve {

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Input number");
		int n = Integer.parseInt(br.readLine());
		
		boolean[] isPrime = new boolean[n+1];
		
		//initialize all to true
		for (int i = 2; i <= n; i++) {
			isPrime[i] = true;
		}
		
		for (int i = 2; i*i <= n; i ++) {
			if (isPrime[i]) {
				for (int j = i; j*i <=n; j++) {
					isPrime[i*j] = false;
				}
			}
		}
		
		for (int k = 2 ; k <= n; k++) {
			System.out.print(isPrime[k] ? k+ " ":"");
		}
		
	}
}
