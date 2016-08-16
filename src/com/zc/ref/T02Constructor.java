package com.zc.ref;

import java.lang.reflect.Constructor;

public class T02Constructor {
	public static void main(String[] args) throws Exception {
		//获取某个构造方法
		String.class.getConstructor(StringBuffer.class);
		//实现new String(new StringBuffer("abc"));
		Constructor constructor1=String.class.getConstructor(StringBuffer.class);
		//Object str1 = constructor1.newInstance(new StringBuffer("abc"));
		//编译期不执行.所以要有严格的语法检查
		String str1 = (String) constructor1.newInstance(new StringBuffer("abc"));
		System.out.println(str1.charAt(1));
		//getDeclaringClass()
	}
}
