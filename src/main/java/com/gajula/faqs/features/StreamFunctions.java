package com.gajula.faqs.features;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFunctions {
    public static void main(String[] args) throws Exception {
        System.out.println("===StreamManipulation=====");

        List<Integer> intList = Arrays.asList(3, 4, 6, 12, 20);
        List<String> strList = Arrays.asList("Gajula", "bakash","Cap", "Gemini");
        List<Product> prodList = getProductList();
        List<Product> prodListOne = getProductListOne();
        List<Product> prodListTwo = getProductListTwo();

        List<Float> priceList = prodList.stream().map(Product::getPrice).collect(Collectors.toList());
        System.out.println("ProdList===="+priceList);

        priceList = prodList.stream().filter(p -> p.price > 20000).map(Product::getPrice).collect(Collectors.toList());
        System.out.println("ProdList===="+priceList);

        long count = prodList.stream().filter(product -> product.price > 20000).count();
        System.out.println("count>20000=="+count);

        Product min = prodList.stream().max((p1, p2) -> p1.price > p2.price ? 1 : -1).get();
        System.out.println("Max Price=="+min.price);

        Product max = prodList.stream().min((p1, p2) -> p1.price > p2.price ? 1 : -1).get();
        System.out.println("Min Price=="+max.price);

        Float totalPrice1 = prodList.stream().map(product -> product.price).reduce(0.0f, (sum, price) -> sum + price);
        Float totalPrice2 = prodList.stream().map(product -> product.price).reduce(0.0f, Float::sum);
        Integer totalPrice3 = prodList.stream().map(product -> product.qty).reduce(0, Integer::sum);
        Double totalPrice4 = prodList.stream().collect(Collectors.summingDouble(product -> product.price));
        System.out.println("Total1="+totalPrice1+" \t Total2="+totalPrice2+" \t Total3="+totalPrice3+" \t Total4="+totalPrice4);

        Integer totalPrice5 = prodList.stream().map(product -> product.price).mapToInt(price -> price.intValue()).reduce(0, Integer::sum);
        System.out.println("Float to Int and total Total5="+totalPrice5);

        Map<Integer, String> productPriceMap = prodList.stream().collect(Collectors.toMap(p -> p.id, p -> p.name));
        System.out.println("productPriceMap=" + productPriceMap);

        List<Product> mergeList = Stream.concat(prodListOne.stream(), prodListTwo.stream()).collect(Collectors.toList());

        boolean answer = intList.stream().anyMatch(n -> (n==4));
        System.out.println(intList+"==anyMatch=="+answer);

        answer = strList.stream().anyMatch(str -> Character.isUpperCase(str.charAt(0)));
        System.out.println("anyMatch start index Capital=="+answer);

        List<String> skippedList = strList.stream().skip(2).collect(Collectors.toList());
        System.out.println("strList=="+strList+" skippedList Range 2 =="+skippedList);

        skippedList.stream().flatMap(str -> Stream.of(str.charAt(2))).forEach(System.out::println);

        Optional<String> findFirst = skippedList.stream().findFirst();
        System.out.println("findFirst==="+findFirst.get());

        List<String> findanystrList = Arrays.asList("gajula", "bakash","Cap", "Gemini", "gajula");
        Optional<String> findAny = findanystrList.stream().filter(str-> str.equalsIgnoreCase("abc")).findAny();
        System.out.println("findanystrList==="+(findAny.isPresent()?findAny.get():"no value"));
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


