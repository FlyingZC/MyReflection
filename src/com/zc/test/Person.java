package com.zc.test;

public class Person extends Sup implements Inter{
	public int age;
	private int no;
	public Person(){
		
	}
	public Person(int age,int no){
		this.age=age;
		this.no=no;
	}
	
	public Person(int age){
		this.age=age;
	}
	
	public Person(Integer age,Integer no){
		this.age=age;
		this.no=no;
	}
	public String name="ball";
	public String str2="basketball";
	public String str3="it";
	
	@Override
	public String toString() {
		return name+" "+str2+" "+str3;
	}
	
	public void print(){
		System.out.println("print方法");
	}
	
	public void print(String str){
		System.out.println("print方法"+str);
	}
}
