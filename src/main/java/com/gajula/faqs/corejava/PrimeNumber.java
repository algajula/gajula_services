package com.gajula.faqs.corejava;

public class PrimeNumber {
	public static void main(String[] args) {
		try {
			System.out.println("Prime Number");
			String primes="";
			for(int j=1;j<=100;j++) {
				int counter=0;
				for(int i=1; i<=j; i++) {
					if(j%i == 0) {
						counter = counter+1;
						
					}
				}
				if(counter == 2) {
					primes = primes +j+", ";
					System.out.println("Counter=="+counter+" number "+j);
				}
			}
			
			
			System.out.println("Primes are===="+primes);
		}catch (ArithmeticException e) {
			System.out.println("Arithmatic Error"+e);
		}
	}
}
