package com.gajula.faqs.corejava;

public class VowelsAndConsonents {

	public static void main(String[] args) {
		char input='I';
		boolean isUpper=false;
		boolean isLower=false;
		if(input == 'a' || input == 'e' || input == 'i' || input == 'o' || input == 'u') {
			isLower=true;
		}
		if(input == 'A' || input == 'E' || input == 'I' || input == 'O' || input == 'U') {
			isUpper=true;
		}

		if(isLower || isUpper) {
			System.out.println("Given charector is Vowel");
		}else {
			System.out.println("Given charector is Consonents");
		}
	}

}
