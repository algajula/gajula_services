package com.gajula.faqs.corejava;

public class LargeSmallNumber {

	public static void main(String[] args) {
		int numbers[] = {10,2,3,511,15,16,17,65,3,245,321};
		int small = numbers[0];
		int large = numbers[0];
		
		int i=1;
		while(i< numbers.length) {
			if(numbers[i]> large) {
				large = numbers[i];
			}else if(numbers[i] < small) {
				small = numbers[i];
			} 
			i++;
		}
		
		System.out.println("Small="+small+" Large="+large);
	}

}
