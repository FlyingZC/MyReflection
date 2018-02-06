package com.zc.test.factory;

public class T01FactoryRef {
 public static void main(String[] a){
	 //全类名
    fruit f=Factory.getInstance("com.zc.test.factory.Apple");
        if(f!=null){
            f.eat();
        }
    }
}
interface fruit{
    public abstract void eat();
}
 
class Apple implements fruit{
    public void eat(){
        System.out.println("Apple");
    }
}
 
class Orange implements fruit{
    public void eat(){
        System.out.println("Orange");
    }
}
 
class Factory{
    public static fruit getInstance(String ClassName){
        fruit f=null;
        try{
            f=(fruit)Class.forName(ClassName).newInstance();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
}
