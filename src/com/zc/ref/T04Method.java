package com.zc.ref;

import java.lang.reflect.Method;

public class T04Method {
	public static void main(String[] args) throws Exception {
		Method m1=String.class.getMethod("charAt",int.class);
		String str1=new String("hea1");
		//invoke(类的对象,该方法的参数)
		System.out.println(m1.invoke(str1,1));
		//静态方法 对象名传null
		Method m2=String.class.getMethod("valueOf",int.class);
		System.out.println(m2.invoke(null,1));
	}
}
