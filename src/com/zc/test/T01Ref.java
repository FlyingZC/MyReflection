package com.zc.test;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author zc
 *
 */
public class T01Ref {
	public static void main(String[] args) throws Exception {
		//1.创建Class类的实例clazz的几种方法
		Class<?> clazz=null;
		clazz=Person.class;//
		clazz=new Person(1,1).getClass();//Object类中的方法
		clazz=Class.forName("com.zc.test.Person");
		System.out.println(clazz.getName());
		
		//2.通过Class类的对象clazz实例化其他类的对象,需要强转
		Person p=(Person)clazz.newInstance();
		
		
		//3.通过Class类的对象clazz调用其他类中的构造方法
		clazz=Person.class;
		//(1)遍历顺序按照在类中声明顺序的倒序排列
		Constructor<Person>[] cons=(Constructor<Person>[]) clazz.getConstructors();
		/*
		 * public com.zc.test.Person(java.lang.Integer,java.lang.Integer)
		 * public com.zc.test.Person(int)
		   public com.zc.test.Person(int,int)
		   public com.zc.test.Person()
		 * 
		 * */
		for(Constructor<Person> cin:cons){
			System.out.println(cin);
		}
		clazz=Class.forName("com.zc.test.Person");
		//(2)使用无边界通配符
		Constructor<?>[] conss=clazz.getConstructors();
		//通过构造方法创建对象
		//Person p1=(Person) conss[0].newInstance();//还是要强转
		//构造方法参数必须是Person(Integer a,Integer b)不能是Person(int a,int b)，否则java.lang.NoSuchMethodException
		Constructor<Person> con=(Constructor<Person>) clazz.getConstructor(Integer.class,Integer.class);
		Person pp=con.newInstance(1,2);
		System.out.println(pp);
		
		
		//4.获取类实现的接口的Class实例
		clazz=Person.class;
		Class<?>[] inters=clazz.getInterfaces();
		for(int i=0;i<inters.length;i++){
			System.out.println(inters[i].getName());//com.zc.test.Inter
		}
		
		//5.获取类继承的父类的Class实例
		Class<?> sup=clazz.getSuperclass();
		System.out.println("父类的Class实例"+sup.getName());//父类的Class实例com.zc.test.Sup
		
		//6.获取类中所有属性
		System.out.println("===============本类属性========================");
        // 取得本类的全部属性
        Field[] field = clazz.getDeclaredFields();
        for (int i = 0; i < field.length; i++) {
            // 权限修饰符
            int mo = field[i].getModifiers();
            String priv = Modifier.toString(mo);
            // 属性类型
            Class<?> type = field[i].getType();
            System.out.println(priv + " " + type.getName() + " "
                    + field[i].getName() + ";");
        }
        System.out.println("===============实现的接口或者父类的属性========================");
        // 取得实现的接口或者父类的属性
        Field[] filed1 = clazz.getFields();
        for (int j = 0; j < filed1.length; j++) {
            // 权限修饰符
            int mo = filed1[j].getModifiers();
            String priv = Modifier.toString(mo);
            // 属性类型
            Class<?> type = filed1[j].getType();
            System.out.println(priv + " " + type.getName() + " "
                    + filed1[j].getName() + ";");
        }
       
        
        //7.通过反射调用类中的方法
        //(1)执行无参方法
        Method method=clazz.getMethod("print");
        method.invoke(clazz.newInstance());
        //(2)执行有参方法
        Method method2=clazz.getMethod("print",String.class);
        //invoke(Person类的对象,String类型参数)
        method2.invoke(clazz.newInstance(),"hehe");
        
        //8.通过反射调用类中的属性
        Field fie=clazz.getDeclaredField("age");
        fie.setAccessible(true);
        //设置属性
        fie.set(clazz.newInstance(),11);
        
        //9.通过反射修改数组
        //定义一个数组
        int[] arr={1,2,3,4,5,6};
        Class<?> arrClazz=arr.getClass().getComponentType();
        System.out.println("数组类型："+arrClazz.getName());
        //Array 类提供了动态创建和访问 Java 数组的方法  java.lang.reflect.Array
        System.out.println("数组长度："+Array.getLength(arr));
        System.out.println("数组第一个元素："+Array.get(arr, 0));
        Array.set(arr,0,100);
        System.out.println("数组第一个元素："+Array.get(arr, 0));
    }
	
	
	
	
		
}	
