package com.gajula.faqs.practice;

interface ABC{
	public void m2();
	default void m1() {
		System.out.println("ABC method");
	}
}

interface XYZ{
	public void m2();
	default void m1() {
		System.out.println("XYZ method");
	}
}

public class IdenticalMethods implements ABC, XYZ{

	public static void main(String[] args) {
		IdenticalMethods a1 = new IdenticalMethods();
		a1.m1();
		ABC a = new IdenticalMethods();
		a.m2();
		XYZ x = new IdenticalMethods();
		x.m2();

	}

	@Override
	public void m1() {
		XYZ.super.m1();
	}

	@Override
	public void m2() {
		System.out.println("M2 method");
		
	}

}
