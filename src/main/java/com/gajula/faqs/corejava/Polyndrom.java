package com.gajula.faqs.corejava;

public class Polyndrom {

	public static void main(String[] args) {
		try {
			int value=100011;
			int original=value;
			int reverse=0;
			int reminder;
			while(value!=0) {
				reminder = value%10;
				reverse = (reverse*10)+reminder;
				value = value/10;
			}
			System.out.println(original+"===="+reverse);
			if(original == reverse) {
				System.out.println("given number is a polyndrome");
			}else {
				System.out.println("given number is not a polyndrome");
			}
			
			String original1="ABCDCBA";
			String reverse1="";
			int length = original1.length();
			int position=0;
			for( int i=length-1; i>=0; i--){
				reverse1 = reverse1+original1.charAt(i);
				//System.out.println("reverse1==="+reverse1);
			}
			System.out.println(original1+"===="+reverse1);
			if(original1.equals(reverse1)) {
				System.out.println("given string is a polyndrome");
			}else {
				System.out.println("given number is not a polyndrome");
			}
			
		}catch (Exception e) {
			System.out.println("Error "+e.getMessage());
		}
	}
	
}
