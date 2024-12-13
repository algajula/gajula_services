package com.gajula.faqs;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo extends Thread {

	public static void main(String[] args) throws  Exception {
		ConcurrentHashMap<Integer, String> m = new ConcurrentHashMap<>();

		m.put(100, "Hello");
		m.put(101, "Geeks");
		m.put(102, "Geeks");
		m.putIfAbsent(101, "Hello");
		m.remove(101, "Geeks");
		m.putIfAbsent(103, "Hello");
		m.replace(101, "Hello", "For");
		System.out.println(m);

		l.put(100,"A");
		l.put(101,"B");
		l.put(102,"C");
		ConcurrentHashMapDemo obj = new ConcurrentHashMapDemo();
		obj.start();
		for (Object o : l.entrySet()){
			Object s=o;
			System.out.println(s);
			Thread.sleep(1000);
		}
		System.out.println(l);
	}

	static ConcurrentHashMap<Integer,String> l = new ConcurrentHashMap<Integer,String>();

	public void run(){
		// Child add new element in the object
		l.put(103,"D");
		try{
			Thread.sleep(2000);
		}catch(InterruptedException e){
			System.out.println("Child Thread going to add element");
		}
	}


}
