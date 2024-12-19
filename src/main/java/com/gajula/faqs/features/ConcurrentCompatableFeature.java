package com.gajula.faqs.features;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConcurrentCompatableFeature {

	public int workerThreads = 100;

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ConcurrentCompatableFeature obj = new ConcurrentCompatableFeature();
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		CompletableFuture<List<Product>> compList11;
		CompletableFuture<List<Product>> compList12;
		CompletableFuture<List<Product>> compList13;
		compList11 = CompletableFuture.supplyAsync((Supplier<List<Product>>) () -> {
			try {
				return obj.getProductListOne().get();
			} catch (Exception e) {
				System.out.println("Exception occurred in compList12:::" + e.getMessage());
			}
			return null;
		}, executorService);

		compList12 = CompletableFuture.supplyAsync((Supplier<List<Product>>) () -> {
			try {
				return obj.getProductListTwo().get();
			} catch (Exception e) {
				System.out.println("Exception occurred in compList12:::" + e.getMessage());
			}
			return null;
		}, executorService);

		compList13 = CompletableFuture.supplyAsync((Supplier<List<Product>>) () -> {
			try {
				return obj.getProductListThree().get();
			} catch (Exception e) {
				System.out.println("Exception occurred in compList12:::" + e.getMessage());
			}
			return null;
		}, executorService);

		//long starttime = System.currentTimeMillis();
		//CompletableFuture<Void> allOf = CompletableFuture.allOf(compList11, compList12, compList13);
		//long endtime = (System.currentTimeMillis() - starttime);
		//System.out.println("ALL-OF time elapsed " + endtime);

		long starttime1 = System.currentTimeMillis();
		Collection<Product> mergeList = Stream.of(compList11.get(), compList12.get(), compList13.get())
				.filter(Objects::nonNull)
				.flatMap(List::stream)
				.collect(Collectors.toMap(Product::getId, d -> d, (Product x, Product y) -> x == null ? y : x))
				.values();
		long endtime1 = (System.currentTimeMillis() - starttime1);
		System.out.println("OF time elapsed " + endtime1);

		mergeList.forEach(p -> {
			System.out.println("LIST1==" + p.id + " " + p.name);
		});

	}

	public CompletableFuture<List<Product>> getProductListOne() throws Exception {
		long starttime = System.currentTimeMillis();
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(1, "Samsung A5", 17000f, 2));
		list.add(new Product(3, "Iphone 6S", 65000f, 3));
		list.add(new Product(2, "Sony Xperia", 25000f, 1));
		list.add(new Product(4, "Nokia Lumia", 15000f, 1));
		list.add(new Product(5, "Redmi4 ", 26000f, 4));
		list.add(new Product(6, "Lenevo Vibe", 19000f, 3));
		long endtime = (System.currentTimeMillis() - starttime);
		System.out.println("getProductListOne time elapsed " + endtime);
		return CompletableFuture.completedFuture(list);
	}

	public CompletableFuture<List<Product>> getProductListTwo() throws Exception {
		long starttime = System.currentTimeMillis();
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(7, "DELL", 17000f, 2));
		list.add(new Product(8, "HP", 65000f, 1));
		list.add(new Product(9, "LENOVA", 25000f, 1));
		long endtime = (System.currentTimeMillis() - starttime);
		System.out.println("getProductListtwo time elapsed " + endtime);
		return CompletableFuture.completedFuture(list);
	}

	public CompletableFuture<List<Product>> getProductListThree() throws Exception {
		long starttime = System.currentTimeMillis();
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(10, "REALME", 17000f, 1));
		list.add(new Product(11, "SAMSUNG", 65000f, 2));
		list.add(new Product(12, "ONEPLUS", 25000f, 3));
		long endtime = (System.currentTimeMillis() - starttime);
		System.out.println("getProductListtwo time elapsed " + endtime);
		return CompletableFuture.completedFuture(list);
	}

}
