package com.gajula.faqs;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static java.lang.String.valueOf;

public class AlphaNumericWordCOunt {



    public static void main(String[] args) throws  Exception{
        try{
            System.out.println("==Start==");
            long value= 123423564425l;
            List<String> list = Arrays.asList(valueOf(value).split(""));
            Map<Object, Long> counts = list.stream().map(Integer::valueOf)
                            .collect(Collectors.groupingBy(e -> e,Collectors.counting()));
            System.out.println(counts);

            list = Arrays.asList("gajula","abc","xyz","abc", "bakash","abc");
            counts = list.stream().map(String::valueOf)
                    .collect(Collectors.groupingBy(e -> e,Collectors.counting()));
            System.out.println(counts);

            Map<Object, Long> pnameCount = getProductListOne().stream()
                    .map(Product::getName)
                    .collect(Collectors.groupingBy(p -> p, Collectors.counting()));
            System.out.println("pname count=="+pnameCount);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static List<Product> getProductListOne() {
        List<Product> list = new ArrayList<Product>();
        list.add(new Product(1, "Samsung A5", 17000f, 2));
        list.add(new Product(3, "Iphone 6S", 65000f, 3));
        list.add(new Product(2, "Sony Xperia", 25000f, 1));
        list.add(new Product(4, "Nokia Lumia", 15000f, 1));
        list.add(new Product(5, "Redmi4 ", 26000f, 4));
        list.add(new Product(6, "Lenevo Vibe", 19000f, 3));
        list.add(new Product(7, "Samsung A5", 17000f, 2));
        return list;
    }
}
