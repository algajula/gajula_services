package com.gajula.faqs.corejava;

public class FibonacciSeries {

	public static void main(String[] args) {
		FibonacciSeries series=new FibonacciSeries();
		series.printFibonacciSeries();
		System.out.println("\n printFibonacciRecursion ");
		printFibonacciRecursion(10);
	}
	
	public void printFibonacciSeries() {
		int maxNumber = 10; 
		int previousNumber = 0;
		int nextNumber = 1;
		System.out.print("Fibonacci Series of "+maxNumber+" numbers:");
		for (int i = 1; i <= maxNumber; ++i){
            System.out.print(previousNumber+" ");
            int sum = previousNumber + nextNumber;
            previousNumber = nextNumber;
            nextNumber = sum;
        }   
	}
	
	 static int n1=0,n2=1,n3=0;    
	 static void printFibonacciRecursion(int count){    
	    if(count>0){    
	         n3 = n1 + n2;    
	         n1 = n2;    
	         n2 = n3;    
	         System.out.print(" "+n3);   
	         printFibonacciRecursion(count-1);    
	     }    
	 }    
	 

}
