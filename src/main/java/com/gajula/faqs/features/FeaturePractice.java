package com.gajula.faqs.features;

import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface practiceFunction1{
    public int getSum(int a, int b);
}

@FunctionalInterface
interface practiceFunction2{
    public boolean checkisEMptyOrNull(String str);
}

public class FeaturePractice {

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(3, 4, 6, 12, 20);
        List<String> strList = Arrays.asList("Gajula", "bakash","Cap", "Gemini");

        practiceFunction1 l1 = (int a, int b)-> (a+b);
        System.out.println("Sum="+l1.getSum(10,13));

        practiceFunction2 l2 = StringUtils::isEmpty;
        System.out.println("String is empty or null="+l2.checkisEMptyOrNull("gajula"));

    }
}
