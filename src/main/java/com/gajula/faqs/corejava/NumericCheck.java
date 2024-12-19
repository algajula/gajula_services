package com.gajula.faqs.corejava;

public class NumericCheck {

	public static void main(String[] args) {
		String str="a";
		boolean isNumber=false;
		try {
			Double d = Double.parseDouble(str);
			isNumber = true;
		}catch(NumberFormatException e) {
			isNumber = false;
		}

		if(isNumber) {
			System.out.println("Geven string is numeric");
		}else {
			System.out.println("Geven string is not numeric");
		}
	}
}
