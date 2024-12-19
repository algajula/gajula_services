package com.gajula.faqs.features;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

@FunctionalInterface
interface Inf6 {
	List<Product> getProductListStatic();
}

@FunctionalInterface
interface Inf7 {
	List<Product> getProductListInstance();
}

@FunctionalInterface
interface Messageable{  
	MethodReferences getMessage(String msg);  
}  

public class MethodReferences {
	
	public MethodReferences() {
		System.out.println(" Default");
	}
	
	public MethodReferences(String msg) {
		System.out.println("CONSTRUCTOR=="+msg);
	}

	public static void main(String[] args) {
		try {
			System.out.println("METHOD REFERENCE START");
			
			System.out.println("STATIC METHOD REFERENCE");
			Inf6 inf6 = MethodReferences::getProductListStatic;
			List<Product> list = inf6.getProductListStatic();
			System.out.println("getProductListStatic Size==" + list.size());

			BiFunction<Integer, Integer, Integer> adder = MethodReferences::sum;
			int result = adder.apply(10, 20);
			System.out.println("SUM == " + result);

			BiFunction<Integer, Integer, Integer> bifun1 = MethodReferences::sum;
			BiFunction<Integer, Float, Float> bifun2 = MethodReferences::sum;
			BiFunction<Float, Float, Float> bifun3 = MethodReferences::sum;
			int result1 = bifun1.apply(10, 20);
			float result2 = bifun2.apply(10, 20.0f);
			float result3 = bifun3.apply(10.0f, 20.0f);
			System.out.println(result1);
			System.out.println(result2);
			System.out.println(result3);

			System.out.println("IMSTANCE METHOD REFERENCE");
			MethodReferences obj = new MethodReferences();
			Inf7 inf7 = obj::getProductListInstance;
			List<Product> instnceList = inf7.getProductListInstance();
			System.out.println("getProductListInstance Size==" + instnceList.size());
			
			BiFunction<Integer, Integer, Integer> bifun4 = obj::instanceSum;
			BiFunction<Integer, Float, Float> bifun5 = obj::instanceSum;
			BiFunction<Float, Float, Float> bifun6 = obj::instanceSum;
			int result4 = bifun4.apply(10, 20);
			float result5 = bifun5.apply(10, 20.0f);
			float result6 = bifun6.apply(10.0f, 20.0f);
			System.out.println(result4);
			System.out.println(result5);
			System.out.println(result6);
			
			
			System.out.println("CONSTRUCTOR REFERENCE");
			Messageable obj2 = MethodReferences::new;
			obj2.getMessage("initialize constructor reference");
			
			System.out.println("METHOD REFERENCE END");
		} catch (Exception e) {
			System.out.println("error in main " + e.getMessage());
		}
	}

	public static List<Product> getProductListStatic() {
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(1, "Samsung A5", 17000f, 2));
		list.add(new Product(3, "Iphone 6S", 65000f, 3));
		list.add(new Product(2, "Sony Xperia", 25000f, 1));
		list.add(new Product(4, "Nokia Lumia", 15000f, 1));
		list.add(new Product(5, "Redmi4 ", 26000f, 4));
		list.add(new Product(6, "Lenevo Vibe", 19000f, 3));
		return list;
	}
	
	public static int sum(int a, int b) {
		return a + b;
	}

	public static float sum(int a, float b) {
		return a + b;
	}

	public static float sum(float a, float b) {
		return a + b;
	}
	
	public List<Product> getProductListInstance() {
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(1, "Samsung A5", 17000f, 2));
		list.add(new Product(3, "Iphone 6S", 65000f, 3));
		list.add(new Product(2, "Sony Xperia", 25000f, 1));
		list.add(new Product(4, "Nokia Lumia", 15000f, 1));
		list.add(new Product(5, "Redmi4 ", 26000f, 4));
		list.add(new Product(6, "Lenevo Vibe", 19000f, 3));
		return list;
	}

	public int instanceSum(int a, int b) {
		return a + b;
	}

	public float instanceSum(int a, float b) {
		return a + b;
	}

	public float instanceSum(float a, float b) {
		return a + b;
	}
}
