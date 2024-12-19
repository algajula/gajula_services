package com.gajula.faqs.corejava;

public class Pyramids {

	public static void main(String[] args) {
		char c = '*';
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(c);
			}
			System.out.print("\n");
		}
		
		
		System.out.println("Traingle pyramid");
		char c1 = '*';
		int rows=5;
		for(int i=0;i<rows;i++) {
			for (int j=rows-i; j>1; j--) { 
				System.out.print(" ");
			}
			for (int k=0; k<=i; k++ ) {
				System.out.print(c+" ");
			}
			System.out.print("\n");
		}
		
		System.out.println("Traingle pyramid");
		char c2 = '1';
		int rows2=5;
		for(int i=0;i<rows2;i++) {
			for (int j=rows2-i; j>1; j--) { 
				System.out.print(" ");
			}
			int number=1;
			for (int k=0; k<=i; k++ ) {
				System.out.print(number+" ");
				number++;
			}
			System.out.print("\n");
		}

	}

}
