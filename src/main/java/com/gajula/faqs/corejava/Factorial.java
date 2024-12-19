package com.gajula.faqs.corejava;

public class Factorial {

	public static void main(String[] args) {
		int input=5;
		int fact=1;
		String msg = "";
		for(int i=1; i<=input;i++) {
			fact = fact*i;
			msg += i+"*";
		}
		System.out.println("Factorial value of "+input+" is "+ msg+"="+fact);

	}

}
