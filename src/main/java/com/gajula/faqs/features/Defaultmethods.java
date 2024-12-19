package com.gajula.faqs.features;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface defaultInf{
	default List<Product> getProductListDefault() {
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(1, "Samsung A5", 17000f, 2));
		list.add(new Product(3, "Iphone 6S", 65000f, 3));
		list.add(new Product(2, "Sony Xperia", 25000f, 1));
		list.add(new Product(4, "Nokia Lumia", 15000f, 1));
		list.add(new Product(5, "Redmi4 ", 26000f, 4));
		list.add(new Product(6, "Lenevo Vibe", 19000f, 3));
		return list;
	}
	
	public List<Product> getProductList();
}
public class Defaultmethods implements defaultInf{

	public static void main(String[] args) {
		Defaultmethods obj = new Defaultmethods();
		List<Product> list1 = obj.getProductListDefault();
		List<Product> list2 = obj.getProductList();
		list1.forEach(p -> {
			System.out.println("LIST1=="+p.id+" "+p.name);
		});
		list2.forEach(p -> {
			System.out.println("LIST2=="+p.id+" "+p.name);
		});
		

	}

	@Override
	public List<Product> getProductList() {
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(7, "DELL", 17000f, 1));
		list.add(new Product(8, "HP", 65000f, 2));
		list.add(new Product(9, "LENOVA", 25000f, 1));
		return list;
	}

}
