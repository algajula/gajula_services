package com.gajula.faqs.corejava;

public class SeperateAlphaNumeric {

	public static void main(String[] args) {
		String str = "hello capgemini, i am new to python, i was join at Jan'2021";
		String alphabets="";
		String numerics="";
		String specials="";
		for(int i=0;i<str.length();i++) {
			char c=str.charAt(i);
			if(Character.isAlphabetic(c)) {
				alphabets +=c;
			}else if(Character.isDigit(c)) {
				numerics += c;
			}else if(!Character.isSpaceChar(c)) {
				specials += c;
			}
		}
		System.out.println("Alphabets="+alphabets);
		System.out.println("Numerics="+numerics);
		System.out.println("Specials="+specials);

	}

}
