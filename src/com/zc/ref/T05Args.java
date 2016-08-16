package com.zc.ref;

import java.lang.reflect.Method;

public class T05Args {
	public static void main(String[] args) throws Exception {
		//main方法有参数列表
		Method me=T04Method.class.getMethod("main",String[].class);
		//以下两种方法都可以.main方法需要传一个数组参数.但是jdk1.4中将数组当做多个参数.所以
		//方法一:再包一层.让其拆
		me.invoke(null,new Object[]{new String[]{"1","2","3"}});
		//方式二:告知编译器.传的是一个Object对象.而不是数组
		//me.invoke(null,(Object)new String[]{"1","2","3"});
	}
}
