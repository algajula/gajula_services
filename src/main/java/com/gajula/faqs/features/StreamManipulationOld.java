package com.gajula.faqs.features;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamManipulationOld {



	public static void main(String... args){
		List strArrayList = getList();
		List prodList = getProductList();
		List prodListOne = getProductListOne();
		List prodListTwo = getProductListTwo();
		StreamManipulationOld.printPriceList(prodList);
		StreamManipulationOld.filterPriceListAsFloat(prodList);
		StreamManipulationOld.printPriceListAsFloat(prodList);
		StreamManipulationOld.iterateElements();
		StreamManipulationOld.forEachElements(prodList);
		StreamManipulationOld.sumTotalProductProces(prodList);
		StreamManipulationOld.productMinMaxPrice(prodList);
		StreamManipulationOld.productsCountbasedOnFilter(prodList);
		StreamManipulationOld.fetchProductsbasedonFilter(prodList);
		StreamManipulationOld.convertListToSetAndMap(prodList);
		StreamManipulationOld.mergeProductList(prodListOne, prodListTwo);
	}

	public static void printPriceList(List<Product> prodList) {
		System.out.println("printPriceList");
		prodList.stream().forEach(p -> {
			System.out.println(p.getPrice());
		});
	}

	public static void filterPriceListAsFloat(List<Product> prodList) {
		System.out.println("printPriceListAsFloat");
		System.out.println("---- FILTER -- MAP -- COLLECT -------");
		List<Float> productPriceList = prodList.stream()
				.filter(p -> p.price > 20000)// filtering data
				.map(p -> p.price) // fetching price
				.collect(Collectors.toList()); // collecting as list
		System.out.println(productPriceList);
	}

	public static void printPriceListAsFloat(List<Product> prodList) {
		System.out.println("printPriceListAsFloat");
		Set<Float> priceList = prodList.stream()
				.map(p -> p.price) // fetching price
				.collect(Collectors.toSet());
		System.out.println("priceList=" + priceList);
	}

	public static void iterateElements() {
		System.out.println("----iterateElements-----");
		Stream.iterate(1, element -> element + 1)
				.filter(element -> element % 5 == 0).limit(5)
				.forEach(System.out::println);
	}

	public static void forEachElements(List<Product> prodList) {
		System.out.println("----forEachElements-----");
		System.out.println("-- FOR EACH -----------");
		prodList.stream().filter(product -> product.price > 10000)
				.forEach(product ->
						System.out.println(" FOREACH PRODUCT NAME=" + product.name)
				);
	}

	public static void sumTotalProductProces(List<Product> prodList) {
		System.out.println("----sumTotalProductProces-----");
		Float totalPrice1 = prodList.stream()
				.map(product -> product.price).reduce(0.0f,
						(sum, price) -> sum + price); // accumulating price
		System.out.println("SUM Float One " + totalPrice1);

		// More precise code
		float totalPrice2 = prodList.stream()
				.map(product -> product.price)
				.reduce(0.0f, Float::sum); // accumulating
		System.out.println("SUM Float Two " + totalPrice2);

		Integer totalPrice3 = prodList.stream()
				.map(product -> product.id)
				.reduce(0, Integer::sum); // accumulating
		System.out.println("SUM Ineteger " + totalPrice3);

		double totalPrice4 = prodList.stream()
				.collect(Collectors.summingDouble(product -> product.price));
		System.out.println("SUM Using Collectors " + totalPrice4);
	}

	public static void productMinMaxPrice(List<Product> prodList) {
		System.out.println("productMinMaxPrice");
		// max() method to get max Product price
		Product productA = prodList.stream()
				.max((p1, p2) -> p1.price > p2.price ? 1 : -1)
				.get();
		System.out.println("MAX==" + productA.price);

		// min() method to get min Product price
		Product productB = prodList.stream()
				.min((p1, p2) -> p1.price > p2.price ? 1 : -1)
				.get();
		System.out.println("MIN==" + productB.price);
	}

	public static void productsCountbasedOnFilter(List<Product> prodList) {
		System.out.println("productsCountbasedOnFilter");
		// count number of products based on the filter
		long count = prodList.stream()
				.filter(product -> product.price < 30000)
				.count();
		System.out.println("COUNT Whse price<30000 " + count);
	}

	public static void fetchProductsbasedonFilter(List<Product> prodList) {
		System.out.println("fetchProductsbasedonFilter");
		List<Float> productPriceMethodRefList = prodList.stream()
				.filter(p -> p.price <= 30000) // filtering data
				.map(Product::getPrice) // fetching price by referring getPrice method
				.collect(Collectors.toList()); // collecting as list
		System.out.println("METHOD Reference List " + productPriceMethodRefList);
	}

	public static void convertListToSetAndMap(List<Product> prodList) {
		System.out.println("====convertListToSetAndMap=======");
		// Converting product List into Set
		Set<Float> productPriceSet = prodList.stream()
				.filter(product -> product.price < 30000) // filter product on
				.map(product -> product.price)
				.collect(Collectors.toSet()); // collect it as Set(remove duplicate
		// elements)
		System.out.println("Convert List to Set " + productPriceSet);

		// Converting Product List into a Map
		Map<Integer, String> productPriceMap = prodList.stream()
				.collect(Collectors.toMap(p -> p.id, p -> p.name));
		System.out.println("productPriceMap=" + productPriceMap);
	}

	public static void mergeProductList(List<Product> productListOne, List<Product> productListTwo) {
		System.out.println("====mergeProductList=======");
		System.out.println("MERGE TWO LIST");
		List<Product> mergeList = Stream.concat(productListOne.stream(), productListTwo.stream())
				.collect(Collectors.toList());
		mergeList.forEach(p -> {
			System.out.println("Merge==" + p.id + " " + p.name);
		});
	}

	public static List<String> getList() {
		List<String> list = new ArrayList<String>();
		list.add("ankit");
		list.add("mayank");
		list.add("irfan");
		list.add("jai");
		return list;
	}

	public static List<Product> getProductList() {
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(1, "Samsung A5", 17000f, 1));
		list.add(new Product(3, "Iphone 6S", 65000f, 2));
		list.add(new Product(2, "Sony Xperia", 25000f, 4));
		list.add(new Product(4, "Nokia Lumia", 15000f, 3));
		list.add(new Product(5, "Redmi4 ", 26000f, 2));
		list.add(new Product(6, "Lenevo Vibe", 19000f, 1));
		return list;
	}

	public static List<Product> getProductListOne() {
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(1, "Samsung A5", 17000f, 2));
		list.add(new Product(3, "Iphone 6S", 65000f, 3));
		list.add(new Product(2, "Sony Xperia", 25000f, 1));
		list.add(new Product(4, "Nokia Lumia", 15000f, 1));
		list.add(new Product(5, "Redmi4 ", 26000f, 4));
		list.add(new Product(6, "Lenevo Vibe", 19000f, 3));
		return list;
	}

	public static List<Product> getProductListTwo() {
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(7, "DELL", 17000f, 2));
		list.add(new Product(8, "HP", 65000f, 3));
		list.add(new Product(9, "LENOVA", 25000f,1));
		return list;
	}
}