package sample;

/*
 * Author : Aamin Lakhani
 */
//Frequently occurring number without the use of arrays or map
public class FrequentlyOccurringNumber {

	public static int calculatefrequency(int num, int val){
		int count = 0;
		while (num > 0) {
			int digit = num % 10;
			if (digit == val) {
				count ++;
			}
			num = num /10;
		}
		
		return count;
	}
	
	public static void main(String args[]) {
		
		int maxNumber = Integer.MIN_VALUE;
		int maxCount = Integer.MIN_VALUE;
		for (int i = 0; i < 10; i++) {
			int currentCount = calculatefrequency(121212, i);
			if ((currentCount > maxCount) || (currentCount == maxCount && i > maxNumber)) {
				maxCount =  currentCount;
				maxNumber = i;
			}
		}		
		System.out.println(maxNumber + " with a frequency of "+maxCount);
	}
}
