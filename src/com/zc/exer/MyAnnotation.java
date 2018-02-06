package com.zc.exer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//该注解可以在运行期被反射调用,若为SOURCE则只能在编译期调用
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)//该注解只能用在类型上,如class或interface上
public @interface MyAnnotation {
	public String name();
	public String value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyMethodAnno{
	public String name();
	public String value();
}