package com.zc.ref;

import java.lang.reflect.Field;

public class T03Field {
	public static void main(String[] args) throws Exception {
		Person p=new Person(3,5);
		//根据属性名获取属性.代表属性
		Field field=p.getClass().getField("age");
		//public int com.zc.ref.Person.age
		System.out.println(field);
		
		Field field2=p.getClass().getDeclaredField("no");
		//必须加上.否则抛异常
		field2.setAccessible(true);
		//java.lang.IllegalAccessException:
		//打印对象p的属性no的值
		System.out.println(field2.get(p));
		
		changeString(p);
		System.out.println(p);
	}
	
	public static void changeString(Object obj) throws Exception{
		Field[] fields=obj.getClass().getFields();
		for(Field field:fields){
			//如果属性是String类型
			if(field.getType()==String.class){
				String oldValue=(String)(field.get(obj));
				//将所有b用a替换
				String newValue=oldValue.replace('b','a');
				//给对象obj的属性赋值
				field.set(obj,newValue);
			}
		}
	}
}
