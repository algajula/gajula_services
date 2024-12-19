package com.gajula.faqs.features;

@FunctionalInterface
interface InfOne{
	public void methodOne();
	//public void methodTwo();
}
public class FuncInterface implements InfOne{

	public static void main(String[] args) {
		FuncInterface obj = new FuncInterface();
		obj.methodOne();

	}

	@Override
	public void methodOne() {
		System.out.println("method one to user functional interface");
	}

}
