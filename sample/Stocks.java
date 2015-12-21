package sample;
/*
 * Sample program to determine when is the appropriate time to buy or sell a stock to get max profit
 * 
 * Author : Aamin Lakhani
 */
public class Stocks {
	
	public static void calculateProfit(int [] prices) {
		
		int profit = 0;
		int numberofTransactions = 0;
		int i = 0;
		int buyPrice;
		int n = prices.length;
		
		while (i < n - 1) {
			
			//find the localMinima
			while (i < n-1 && prices[i+1] <= prices[i]) {
				i++;
			}
			
			if(i == n-1)
				break;
			
			buyPrice = i++;
			System.out.println("Buy at "+ prices[buyPrice]);
			
			//find the local minima
			while (i < n && prices[i] >= prices[i-1]) {
				i++;
			}
			
			System.out.println("Sell at " + prices[i-1]);
			
			profit += prices[i-1] - buyPrice;
			numberofTransactions ++;
		}
		
		System.out.println("total profit " + profit);
		System.out.println("No of transactions "+ numberofTransactions);
	}

	public static void main(String args[]) {
		
		int [] prices  = {100, 180, 260, 310, 40, 535, 695 };
		calculateProfit(prices);
	
	}
}
