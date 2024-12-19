package com.gajula.faqs.corejava;

public class SquoreRootorExponent {

	public static void main(String[] args) {
		int input = 2;
		int power=4;
		int result=1;
		if(power == 0) {
			System.out.println(input+" power "+power+"= "+0);
		}else if(power == 1) {
			System.out.println(input+" power "+power+"= "+input);
		}else {
			while(power!=0) {
				result = result*input;
				--power;
			}
			System.out.println(input+" power "+power+"= "+result);
		}

	}

}
