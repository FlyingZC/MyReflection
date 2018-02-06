package com.zc.ref;

public class Person {
	public int age;
	private int no;
	public Person(){
		
	}
	public String name="ball";
	public String str2="basketball";
	public String str3="it";
	public Person(int age,int no){
		this.age=age;
		this.no=no;
	}
	
	public Person(Integer age,Integer no){
		this.age=age;
		this.no=no;
	}
	
	@Override
	public String toString() {
		return name+" "+str2+" "+str3;
	}
}
