package com.zc.ref;

public class T06Arr {
	public static void main(String[] args) {
		int[] a1=new int[4];
		int[] a2=new int[5];
		System.out.println(a1==a2);//false
		System.out.println(a1.getClass()==a2.getClass());//true
		System.out.println(a1.getClass().getName());//[I
		System.out.println(a1.getClass().getSuperclass());//class java.lang.Object
	}
}
