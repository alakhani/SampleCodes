package sample;

import java.util.Arrays;

/*
 * Sample program to reverse a sentence in java
 * 
 * Author : Aamin Lakhani
 */
public class ReverseSentence {

	public static String reverseWord(String word) {
		
		char temp[] = word.toCharArray();
		for (int i = 0; i < temp.length/2; i++) {
			char tempChar = temp[i];
			temp[i] = temp [temp.length - 1 - i];
			temp [temp.length - 1 - i] = tempChar;
		}
		
		return new String(temp);
	}
	
	public static String reverseSentence(String sentence) {
		String[] individualWords = sentence.split(" ");
		String[] reversedSentence = new String [individualWords.length];
		for (int i = 0; i < individualWords.length; i++) {
			reversedSentence[i] = reverseWord(individualWords[i]);
		}
		return Arrays.toString(reversedSentence);
	}
	
	public static void main (String args[]) {
		String temp = reverseWord("I am happy");
		System.out.println(reverseSentence(temp));
	}
}
