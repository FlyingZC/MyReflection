package com.zc.ref;

public class T01 {
	public static void main(String[] args) throws Exception {
		String str1="abc";
		Class clazz1=str1.getClass();
		Class clazz2=String.class;
		Class clazz3=Class.forName("java.lang.String");
		System.out.println(clazz1==clazz2);//true
		System.out.println(clazz2==clazz3);//true
		
		//原始类型?
		System.out.println(clazz1.isPrimitive());//false
		System.out.println(int.class.isPrimitive());//true
		System.out.println(int.class==Integer.class);//false
		System.out.println(int.class==Integer.TYPE);//true
		
		System.out.println(int[].class.isPrimitive());//false
		
		System.out.println(int[].class.isArray());
	}
}
