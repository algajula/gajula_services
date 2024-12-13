package com.gajula.faqs;

public class FinalTest {

	public static void main(String[] args) {
		MyFinalClass f = new MyFinalClass();
		f.setName("gajula");
		System.out.println("NAME--"+f.getName());
		f.setName("allabakash");
		System.out.println("NAME--"+f.getName());
		
		MyFinalClass f2 = new MyFinalClass();
		f.setName("nandyal");
		System.out.println("NAME--"+f.getName());
		
		if("gajula" == "gajula") {
			System.out.println("== EQUAL");
		}else {
			System.out.println("== NOT EQUAL");
		}
		
		if("gajula".equals("gajula")) {
			System.out.println("equals() EQUAL");
		}else {
			System.out.println("equals() NOT EQUAL");
		}
		
		String s1 = new String("gajula");
		String s2 = "gajula";
		String s3 = new String("gajula");

		boolean flag1 = (s1==s2)?true:false;
		boolean flag2 = (s1.equals(s2))?true:false;

		boolean flag3 = (s1==s3)?true:false;
		boolean flag4 = (s1.equals(s3))?true:false;

		System.out.println("s1==s2 "+flag1+" s1.equals(s2) "+flag2);
		System.out.println("s1==s3 "+flag3+" s1.equals(s3) "+flag4);


	}

}
