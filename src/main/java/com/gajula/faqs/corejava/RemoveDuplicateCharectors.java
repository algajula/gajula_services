package com.gajula.faqs.corejava;

public class RemoveDuplicateCharectors {

	public static void main(String[] args) {

		String str = "hello capgemini, i am new to python";
		String result="";
		for(int i=0;i<str.length();i++) {
			char c=str.charAt(i);
			if(result.indexOf(c)<=0) {
				result = result+c;
			}
		}
		System.out.println("Result is="+result);
	}

}
