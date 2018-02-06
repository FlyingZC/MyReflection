package com.zc.test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class T06Ref {
	public static void main(String[] args) {
		Class clazz=Person.class;
		//getGenericSuperclass()返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的直接超类的 Type。
		//获取直接父类的Class类型
		System.out.println(clazz.getGenericSuperclass());//class com.zc.test.Sup
		Type genType=clazz.getGenericSuperclass();
		Type [] params = ((ParameterizedType)genType).getActualTypeArguments();
		for(Type t:params){
			System.out.println(t);
		}
	}
}
