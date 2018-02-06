package com.zc.test;

/**
 * @author zc
 *
 */
public class R01Factory {
	public static void main(String[] args) {
		AnimalFactory f=new AnimalFactory();
		f.getInstance("Dog");
	}
}

interface Animal{
	
}

class Dog implements Animal{
	public Dog(){
		System.out.println("dog...");
	}
}

class Cat implements Animal{
	public Cat(){
		System.out.println("cat...");
	}
}

//工厂方法
class AnimalFactory{
	public Animal getInstance(String name){
		Animal a=null;
		System.out.println(name);
		if("Dog".equals(name)){
			a=new Dog();
		}
		if("Cat".equals(name)){
			a=new Cat();
		}
		return a;
	}
}
