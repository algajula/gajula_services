package com.gajula.faqs.corejava;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AlogorithemPractice {

    public static void main(String[] args) {
        int a=5;
        int b=30;


        b = (a+b); //35
        a = b-a; //30
        b = b-a; //5
        System.out.println("SWAPPING================= a="+a+" b="+b);

        //method1
        int number1 = 123456;
        int count = countDigit(number1);
        System.out.println("count digits==="+count);
        //method2
        String numberStr = String.valueOf(number1);
        System.out.println("count digits==="+numberStr.length());

        int number = 5;
        int value = IntStream.rangeClosed(2, number).reduce(1, (x, y) -> x * y);
        System.out.println("factorial value of "+number+" is="+value);

        int primeNo = 5;
        int counter = 0;
        for(int i=2; i<=primeNo; i++){
            if ((primeNo%i) == 0){
               counter = counter+1;
                System.out.println("prime counter"+i);
            }
        }
        if(counter ==2) {
            System.out.println(primeNo + " is prime");
        }else{
            System.out.println(primeNo + " is not prime");
        }

        String str = "hello capgemini, i am new to python";
        String result="";
        Map<Character, Integer> lettercount = new HashMap<Character, Integer>();
        char findFirstRepeat = 0;
        int chk = 1;
        for(int i=0;i<str.length();i++) {
            char c=str.charAt(i);
            if(result.indexOf(c)<=0) {
                result = result+c;
            }
            if(!lettercount.containsKey(c)) {
                lettercount.put(c, 1);
            }else {
                lettercount.put(c, (lettercount.get(c) + 1));
            }
            if(lettercount.containsValue(2) && chk <= 1  ){
                findFirstRepeat = c;
                chk = chk+1;
            }
        }
        System.out.println(str+" REMOVE DUPLICATES "+result);
        System.out.println("letter counts=="+lettercount);
        System.out.println("findFirstRepeat==="+findFirstRepeat);

        //Scanner in = new Scanner(System.in);
        str= "gajula allabakash";
        char ch;
        String reverse = "";
        for (int i=0; i<str.length(); i++){
            ch = str.charAt(i);
            reverse = ch+reverse;
            //System.out.println("reverse="+reverse);
        }
        System.out.println(str+"  Reversed=="+ reverse);

        String word = "gajula allabakash";
        String output  = word.chars().
                filter(c -> c != 'a')
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
        System.out.println("Removed charector 'c' from input "+output);

    }

    static int countDigit(long n)
    {
        if (n/10 == 0)
            return 1;
        return 1 + countDigit(n / 10);
    }

}
