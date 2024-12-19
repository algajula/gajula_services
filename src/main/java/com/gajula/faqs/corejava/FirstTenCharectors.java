package com.gajula.faqs.corejava;

public class FirstTenCharectors {

	public static void main(String[] args) {
		String str = "Hai Capgemini, i am new to python";
		for(int i=0;i<str.length();i++) {
			if(i<10) {
				System.out.print(""+str.charAt(i));
			}
		}

	}

}
