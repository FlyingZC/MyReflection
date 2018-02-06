package com.zc.exer;

import java.io.Serializable;
import java.util.List;
@MyAnnotation(name = "person", value = "personValue`")
public class Person implements Serializable,Cloneable,Comparable{
	public String name;
	private int age;
	public Person() {
		System.out.println("Person类中的无参构造方法");
	}
	public Person(String name, int age) {
		System.out.println("Person类中的有参构造方法");
		this.name = name;
		this.age = age;
	}
	
	private Person(int age,String name){
		System.out.println("Person类中的私有化构造方法");
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	private void show(){
		
		System.out.println("Person类中的show方法,我是一个人");
	}
	
	public void display(String gj){
		System.out.println("Person类中的display方法,我是一个"+gj);
	}
	
	@Override
	public String toString() {
		return "Person--name:"+" "+getName()+" "+"age:"+getAge();
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public List<String> getList(){
		return null;
	}
}

class Student extends Person
{
    
}
