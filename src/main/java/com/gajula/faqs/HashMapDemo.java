package com.gajula.faqs;

import java.util.HashMap;

public class HashMapDemo extends Thread {

    public static void main(String[] args) throws  Exception {
        hMap.put(100,"A");
        hMap.put(101,"B");
        hMap.put(102,"C");
        ConcurrentHashMapDemo obj = new ConcurrentHashMapDemo();
        obj.start();
        for (Object o : hMap.entrySet()){
            Object s=o;
            System.out.println(s);
            Thread.sleep(1000);
        }
        System.out.println(hMap);
    }

    static HashMap<Integer,String> hMap = new HashMap<Integer,String>();

    public void run(){
        // Child add new element in the object
        hMap.put(103,"D");
        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){
            System.out.println("Child Thread going to add element");
        }
    }


}
