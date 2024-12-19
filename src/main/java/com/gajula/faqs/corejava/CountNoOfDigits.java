package com.gajula.faqs.corejava;

public class CountNoOfDigits {

	public static void main(String[] args) {
		int input = 12345;

		int count=0;
		while(input!=0) {
			input = input/10;
			count = count+1;
		}
		System.out.println("No of digits count===="+count);
	}

}
