package com.zc.demo;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.junit.Test;
/*
 * 有了Class的实例后.可以
 * 1.创建对应运行时类的对象
 * 2.获取对应运行时类的完整结构(属性.方法.构造器.内部类.父类.异常...)
 * 3.调用其完整结构
 * 4.反射的应用:动态代理
 * 
 * */

public class T01ReflectionAPI
{
    /**
     * 创建Class
     * 创建对象
     * 获取 类的 属性,方法
     * @throws Exception
     */
    @Test
    public void test01Class() throws Exception
    {
        //创建运行时类(Class类)的对象.栈空间的引用.堆空间的实体
        Class<Person> clazz = Person.class;
        
        //1.创建clazz对应的运行时类Person类的对象
        Person p = clazz.newInstance();
        System.out.println(p);
        //以上两行相当于Person p=new Person();
        
        //2.通过反射获取类的属性
        //获取属性名. lang包默认导入.但是lang包的子包仍需自己导入
        //java.lang.reflect.Field只能获取Person类中的public属性
        Field f1 = clazz.getField("name");
        //属性名.set(类的对象名,"属性值");
        f1.set(p, "heh");

        //获取Person类中的private属性
        Field f2 = clazz.getDeclaredField("age");
        f2.setAccessible(true);
        f2.set(p, 11);
        System.out.println(p);

        //3.通过反射获取运行时类的指定的方法
        //获取无参方法
        Method m1 = clazz.getMethod("show");
        //给方法的形参赋值.注意show()方法本身是无参的.传入的P代表的是运行时类的对象
        m1.invoke(p);

        //getMethod("方法名","Class类型的(参数类型)") 即原来的参数类型.class
        Method m2 = clazz.getMethod("display", String.class);
        m2.invoke(p, "china");
    }

    /**
     * 获取Class 
     */
    @Test
    public void test2Class()
    {
        Person p = new Person();
        //通过运行时类的对象p的getClass()方法 返回运行时类
        //Class就是一个指针指向运行时类
        Class clazz = p.getClass();
        //输出class Person 完整的包名
        System.out.println(clazz);
        //Jvm的类加载器 加载.class文件,.class文件加载到内存后.
        //就是一个运行时类.存在缓存区.这个运行时类本身就是一个Class的实例
        //每一个运行时类只加载一次
    }

    //(1)获取Class实例的方法.(2)通过反射创建运行时类的对象
    @Test
    public void testClass() throws ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        //1.调用运行时类本身的.class属性 
        Class clazz1 = Person.class;
        System.out.println(clazz1.getName());
        
        //2.通过运行时类的对象获取 Class对象
        Person p = new Person();
        Class clazz3 = p.getClass();
        System.out.println(clazz3.getName());
        
        //3.通过Class的静态方法获取 Class对象
        //完整路径.Person默认包下
        //clazz.getName()获取运行时类的全类
        Class<Person> clazz4 = (Class<Person>) Class.forName("Person");
        System.out.println(clazz4.getName());
        //创建运行时类的对象
        Person p1 = clazz4.newInstance();

        //4.通过类的加载器 jvm中的类的加载器 获取Class对象
        ClassLoader classLoader = this.getClass().getClassLoader();
        Class clazz5 = classLoader.loadClass("Person");
        System.out.println(clazz5.getName());
    }

    @Test
    public void test5() throws IOException
    {
        //系统类加载器:负责java-classpath等目录下的类与jar包装入
        //AppClassLoader
        ClassLoader loader1 = ClassLoader.getSystemClassLoader();
        //输出sun.misc.Launcher$AppClassLoader@64fef26a
        System.out.println(loader1);

        //父类是扩展类加载器
        //ExtClassLoader
        ClassLoader loader2 = loader1.getParent();
        System.out.println(loader2);
        //扩展类加载器的父类是引导类加载器.无法直接获得

        //用系统类加载器加载
        Class clazz1 = Person.class;
        ClassLoader loader4 = clazz1.getClassLoader();
        //sun.misc.Launcher$AppClassLoader@28d320d6

        System.out.println(loader4);

        //掌握
        //获取反射对象.获取类的加载器
        ClassLoader loader = this.getClass().getClassLoader();
        //根据地址获取输入流.后面为全类名地址
        InputStream is = loader.getResourceAsStream("jdbc.properties");
        Properties pros = new Properties();
        pros.load(is);
        String name = pros.getProperty("user");
        System.out.println(name);

        String password = pros.getProperty("password");
        System.out.println(password);
    }
}
