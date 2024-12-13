package com.gajula.faqs;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.String.valueOf;

public class gajula_1109_test {

    public static void main(String[] args) {
        try{
            System.out.println("==Start==");
            long value= 123423564425l;
            List<Product> prodList = getProductListOne();
            List<String> strList = Arrays.asList("gajula","abc","xyz","abc", "bakash","abc");
            List<String> intList = Arrays.asList(valueOf(value).split(""));
            System.out.println(" strList=="+strList);
            System.out.println(" intList=="+intList);
            System.out.println(" prodList=="+prodList.size());
            //prodList.stream().forEach(product -> { System.out.println("Product=="+product); });

            List<Integer> list1 = prodList.stream().map(Product::getQty).collect(Collectors.toList());
            System.out.println("Quantities=="+list1);
            List<Float> list2 = prodList.stream().map(Product::getPrice).collect(Collectors.toList());
            System.out.println("Pricees=="+list2);
            Integer minQty = prodList.stream().map(Product::getQty).min((p1, p2) -> p1 > p2 ? 1 : -1).get();
            Integer maxQty = prodList.stream().map(Product::getQty).max((p1, p2) -> p1 > p2 ? 1 : -1).get();
            System.out.println("MinQuantity="+minQty+"   MaxQuantity="+maxQty);
            Float sumTotalPrice1 = prodList.stream().map(Product::getPrice).reduce(0.0f, (sum, price) -> sum+price);
            Float sumTotalPrice2 = prodList.stream().map(Product::getPrice).reduce(0.0f, Float::sum);
            Integer sumTotalPrice3 = prodList.stream().map(Product::getPrice).mapToInt(price->price.intValue()).reduce(0, Integer::sum);
            System.out.println("SUM PRICE Logic1="+sumTotalPrice1+"  Logic1="+sumTotalPrice2+"  Logic3="+sumTotalPrice3);
            Map<Object, Object> prodMap = prodList.stream().collect(Collectors.toMap(p -> p.id, p -> p.price));
            System.out.println("Product Map=="+prodMap);

            System.out.println("==END==");

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("ERROR===="+e.getMessage());
        }
    }

    public static List<Product> getProductListOne() {
        List<Product> list = new ArrayList<Product>();
        list.add(new Product(1101, "Samsung A5", 17000f, 23));
        list.add(new Product(1102, "Iphone 6S", 65000f, 13));
        list.add(new Product(1103, "Sony Xperia", 25000f, 7));
        list.add(new Product(1104, "Nokia Lumia", 15000f, 35));
        list.add(new Product(1105, "redmi4 ", 26000f, 9));
        list.add(new Product(1106, "Lenevo Vibe", 19000f, 7));
        list.add(new Product(1107, "Samsung A5", 17000f, 17));
        return list;
    }
}
