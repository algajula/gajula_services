package com.gajula.faqs.features;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

interface Inf1{
	public void methodOne();
}
interface Inf2{
	public void methodTwo(int a);
}
interface Inf3{
	public void methodThree(int a, int b);
}
interface Inf4{
	public int methodFour(int a);
}
interface Inf5{
	public int methodFive(int a, int b);
}
public class LambdaExpression {

	public static void main(String[] args) {
		LambdaExpression obj = new LambdaExpression();
		obj.methodOne();
		obj.methodTwo(2);
		obj.methodThree(2, 5);
		System.out.println("methodFour"+obj.methodFour(3));
		System.out.println("methodFive"+obj.methodFive(3, 6));
		obj.methodSixForEach();
		obj.methodSevenSort();
		obj.methodEightFilter();
		
		Inf1 m1 = ()->{ 
			System.out.println("method One");
		};
		
		Inf2 m2 = (int a)->{ 
			System.out.println("method Two "+a);
		};

		Inf3 m3 = (int a, int b)->{ 
			System.out.println("method Three "+(a+b));
		};
		
		Inf4 m4 = (int a)->{ 
			return a;
		};
		
		Inf5 m5 = (int a, int b)->{ 
			return a+b;
		};
		m1.methodOne();
		m2.methodTwo(2);
		m3.methodThree(4, 6);
		System.out.println("method Four "+m4.methodFour(7));
		System.out.println("method Five "+m5.methodFive(1, 9));
		
	}
	
	public void methodOne() {
		System.out.println("methodOne");
	}
	
	public void methodTwo(int a) {
		System.out.println("methodTwo");
	}
	
	public void methodThree(int a, int b) {
		System.out.println("methodThree");
	}
	
	public int methodFour(int a) {
		return a;
	}
	
	public int methodFive(int a, int b) {
		return a+b;
	}
	
	public void methodSixForEach() {
		List<String> list=new ArrayList<String>();  
        list.add("ankit");  
        list.add("mayank");  
        list.add("irfan");  
        list.add("jai");
        System.out.println("--- FOR EACH -----");
        list.forEach((str) ->{
        	System.out.println("value "+str);
        });
        System.out.println("--- FOR EACH -----");
	}
	
	public void methodSevenSort() {
		List<Product> list=new ArrayList<Product>();  
        list.add(new Product(1,"HP Laptop",25000f, 2));
        list.add(new Product(3,"Keyboard",300f, 2));
        list.add(new Product(2,"Dell Mouse",150f, 3));
        Collections.sort(list,(p1,p2)->{  
            return p1.name.compareTo(p2.name);  
            });
        System.out.println("---SORT ------");
        for(Product p:list){  
                System.out.println(p.id+" "+p.name+" "+p.price);  
        }
        System.out.println("---SORT ------");
	}
	
	public void methodEightFilter() {
		List<Product> list=new ArrayList<Product>();
		list.add(new Product(1, "Samsung A5", 17000f, 2));
		list.add(new Product(3, "Iphone 6S", 65000f, 3));
		list.add(new Product(2, "Sony Xperia", 25000f, 1));
		list.add(new Product(4, "Nokia Lumia", 15000f, 1));
		list.add(new Product(5, "Redmi4 ", 26000f, 4));
		list.add(new Product(6, "Lenevo Vibe", 19000f, 3));
        Collections.sort(list,(p1,p2)->{  
            return p1.name.compareTo(p2.name);  
            });
        Stream<Product> filtered_data = list.stream().filter(p -> p.price > 25000); 
        System.out.println("---FILTER ------");
        filtered_data.forEach(p -> {  
                System.out.println(p.id+" "+p.name+" "+p.price);  
        });
        System.out.println("---FILTER ------");
	}
}
