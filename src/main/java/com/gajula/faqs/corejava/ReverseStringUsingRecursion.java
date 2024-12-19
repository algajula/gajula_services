package com.gajula.faqs.corejava;

public class ReverseStringUsingRecursion {

	public static void main(String[] args) {
		String input = "Bakash";
		String result = reverseString(input);
		System.out.println("result===="+result);
	}
	
	public static String reverseString(String str) {
		//System.out.println("input string "+str);
		if(str.length()<=0) {
			return str;
		}else {
			System.out.println(str.charAt(0)+"=="+str.substring(1));
			return reverseString(str.substring(1)) + str.charAt(0);
		}
	}
}
