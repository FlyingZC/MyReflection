package com.zc.exer;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

import org.junit.Test;

//important
public class T02Reflect
{
    @Test //获取Class对象
    public void test01() throws ClassNotFoundException
    {
        //方式1 字面量方式,安全,编译期检查,所以不需要try..catch,类字面量方式 可用于 接口,数组,基本数据类型
        Class<Person> clazz1 = Person.class;
        //方式2.需要强转,要捕获编译器异常ClassNotFoundException
        Class<Person> clazz2 = (Class<Person>) Class.forName("Person");
        //方式3.Object类中定义的方法,用对象调
        Class<Person> clazz3 = (Class<Person>) new Person().getClass();
        //方式4.用ClassLoader来加载
        Class<Person> clazz4 = (Class<Person>) Person.class.getClassLoader().loadClass("Person");
    }

    @Test //测试Class
    public void testClass()
    {
        Class<Person> clazz = Person.class;
        //返回全类名
        System.out.println(clazz.getName());//com.zc.exer.Person
        //返回不含包名的 类名
        System.out.println(clazz.getSimpleName());//Person
        //访问类的修饰符,返回int数值.1对应public
        System.out.println(clazz.getModifiers());//1
        System.out.println(Modifier.toString(clazz.getModifiers()));
        //访问包信息
        Package pack = clazz.getPackage();//package com.zc.exer
        System.out.println(pack.getName());//返回String类型  com.zc.exer
        System.out.println(pack);
        //获取父类
        Class<?> superClazz = clazz.getSuperclass();//class java.lang.Object
        System.out.println(superClazz);
        //获取实现的接口集合.getInterfaces()方法仅仅只返回当前类所实现的接口。当前类的父类如果实现了接口，这些接口是不会在返回的Class集合中的，尽管实际上当前类其实已经实现了父类接口。
        Class<?>[] interfaces = clazz.getInterfaces();
        //[interface java.io.Serializable, interface java.lang.Cloneable, interface java.lang.Comparable]
        System.out.println(Arrays.toString(interfaces));

    }

    @Test //用Class对象创建Person类的对象
    public void test02() throws InstantiationException, IllegalAccessException, NoSuchMethodException,
            SecurityException, IllegalArgumentException, InvocationTargetException
    {
        //方式1:使用Class对象创建
        Person p = Person.class.newInstance();
        System.out.println(p);
        //方式2:使用Constructor对象创建
        Constructor<?> con1 = Person.class.getConstructor(String.class, int.class);
        Person p2 = (Person) con1.newInstance("heh", 2);
        System.out.println(p2);

    }

    @Test //用Class对象获取构造器
    public void test03() throws NoSuchMethodException, SecurityException, InstantiationException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
        Class<Person> clazz = Person.class;
        //1.获取无参构造方法,只是获取,并不执行
        Constructor<Person> con1 = clazz.getConstructor();
        //输出:public com.zc.exer.Person()
        System.out.println(con1);
        //2.获取有参构造方法
        Constructor<Person> con2 = clazz.getConstructor(String.class, int.class);
        System.out.println(con2);
        //3.获取私有化构造方法
        Constructor<Person> con3 = clazz.getDeclaredConstructor(int.class, String.class);
        System.out.println(con3);//private com.zc.exer.Person(int,java.lang.String)
        //4.获取所有构造方法(public的),获取不到私有构造方法
        System.out.println("4.获取所有构造方法");
        Constructor<Person>[] cons1 = (Constructor<Person>[]) clazz.getConstructors();
        for (Constructor<Person> c : cons1)
        {
            System.out.println(c);
        }
        //4.获取所有构造方法,包括私有构造方法
        System.out.println("4.获取所有构造方法,包括私有构造方法");
        Constructor<?>[] cons2 = clazz.getDeclaredConstructors();
        for (Constructor<?> c : cons2)
        {
            System.out.println(c);
        }
        //5.获取构造方法信息的相关方法
        int modifier = con2.getModifiers();
        System.out.println("获取构造方法信息的相关方法");
        System.out.println("getModifiers方法获取权限修饰符,返回值为int");
        System.out.println(modifier);
        System.out.println(Modifier.toString(modifier));

        System.out.println("getGenericParameterTypes方法返回Type[]类型的参数列表");
        Type[] parameterTypes = con2.getGenericParameterTypes();
        for (Type t : parameterTypes)
        {
            System.out.println(t);
        }

        String name = con2.getName();
        System.out.println("getName方法:" + name);

        System.out.println("getParameterTypes方法返回Class[]类型的参数列表");
        Class<?>[] paramTypes = con2.getParameterTypes();
        for (Class<?> t : paramTypes)
        {
            System.out.println(t);
        }

        System.out.println("isAccessible方法:" + con2.isAccessible());
        //使用构造器实例的newInstance()创建person对象.需要传入具体参数
        Person p = con2.newInstance("hehe", 1);
        System.out.println(p);

        con2.setAccessible(true);
    }

    @Test //用Class对象获取属性Field
    public void test04() throws NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException
    {
        Class<Person> clazz = Person.class;
        //1.获取单个属性
        Field f1 = clazz.getField("name");
        //2.获取单个private修饰的属性
        Field f2 = clazz.getDeclaredField("age");
        //3.获取所有Field数组
        Field[] fs1 = clazz.getFields();
        //4.获取所有Field数组,包括private
        Field[] fs2 = clazz.getDeclaredFields();
        for (Field f : fs2)
        {
            //private 修饰的属性 或 方法 都需要设置setAccessible
            f.setAccessible(true);
            System.out.println(f);
            //public java.lang.String com.zc.exer.Person.name
            //private int com.zc.exer.Person.age
        }
        
        //5.修改某个对象的属性值
        Person p = clazz.newInstance();
        //设置属性值
        f1.set(p, "haha");
        //获取属性值
        System.out.println(f1.get(p));
        //6.获取属性相关信息
        System.out.println(f2.getModifiers());//2
        System.out.println(f2.getName());//age
        Class type = f2.getType();
        System.out.println(type);//int
        Type genType = f2.getGenericType();
        System.out.println(genType);//int
        //获取属性名..
        System.out.println(f1.getName());//name
        //获取属性类型
        System.out.println(f1.getType());//class java.lang.String
    }

    @Test //获取方法
    public void test05() throws NoSuchMethodException, SecurityException, InstantiationException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
        Class clazz = Person.class;
        //1.获取方法
        Method m1 = clazz.getMethod("display", String.class);
        System.out.println(m1);
        Method m2 = clazz.getDeclaredMethod("show");
        clazz.getMethods();
        System.out.println("获取所有方法");
        Method[] ms = clazz.getDeclaredMethods();
        for (Method m : ms)
        {
            System.out.println(m);
        }
        //2.调用方法
        Person p = (Person) clazz.newInstance();
        m1.invoke(p, "hahha");
        //调用private修饰的方法
        m2.setAccessible(true);
        m2.invoke(p, null);
        //3.获取方法的参数列表类型
        m1.getParameterTypes();
        Type[] ts = m1.getGenericParameterTypes();
        for (Type t : ts)
        {
            System.out.println(t);
        }
        //获取方法 返回值类型
        System.out.println(m1.getReturnType());//void
        //获取 方法 异常类型
        System.out.println(m1.getExceptionTypes());//返回Class<T>[]异常数组
    }

    @Test //操作getter和setter方法
    public void testGetSet()
    {
        Class<Person> clazz = Person.class;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods)
        {
            if (isGetter(method))
                System.out.println("这是一个getter方法:" + method.getName());
            if (isSetter(method))
                System.out.println("这是一个setter方法" + method.getName());
        }
    }

    /**
     * 判断是否为getter方法
     * @param method
     * @return
     */
    public boolean isGetter(Method method)
    {
        if (!method.getName().startsWith("get"))
            return false;
        if (method.getParameterTypes().length != 0)//get方法参数列表为空
            return false;
        if (void.class.equals(method.getReturnType()))//get方法返回值不能为空
            return false;
        return true;
    }

    public boolean isSetter(Method method)
    {
        if (!method.getName().startsWith("set"))
            return false;
        if (method.getParameterTypes().length != 1)
            return false;
        //不添加返回值判断
        return true;
    }

    @Test //调用user中setId方法
    public void isUserSetName() throws Exception
    {
        Class<User> clazz = User.class;
        User user = clazz.newInstance();
        for (Method m : clazz.getMethods())
        {
            if (m.getName() == "setId" && isSetter(m))
                m.invoke(user, "1");
        }
        System.out.println(user.getId());
    }

    @Test //获取注解
    public void testAnno() throws Exception
    {
        //注解信息可以在编译期使用预编译工具进行处理,也可以在运行期使用Java反射机制进行处理
        Class clazz = Person.class;
        //获取类上所有注解
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation anno : annotations)
        {
            if (anno instanceof MyAnnotation)
            {
                MyAnnotation myAnno = (MyAnnotation) anno;
                System.out.println("Annotation-name属性:" + myAnno.name());
                System.out.println("Annotation-value属性:" + myAnno.value());
            }
        }
        //根据注解名 获取 一个注解
        Annotation oneAnno = clazz.getAnnotation(MyAnnotation.class);
        //获取方法上的注解
        Method method = clazz.getMethod("getName", null);
        method.getAnnotation(MyMethodAnno.class);
        //获取方法参数注解
        method.getParameterAnnotations();
        //访问变量注解
        Field field = clazz.getField("name");
        field.getAnnotations();
    }

    @Test //获取泛型参数
    public void testRef() throws Exception
    {
        Class<Person> clazz = Person.class;
        Method method = clazz.getMethod("getList", null);
        Type returnType = method.getGenericReturnType();
        if (returnType instanceof ParameterizedType)
        {
            ParameterizedType type = (ParameterizedType) returnType;
            System.out.println(type.getRawType());//interface java.util.List
            Type[] typeArguments = type.getActualTypeArguments();//泛型数组
            for (Type typeArgument : typeArguments)
            {
                Class typeArgClass = (Class) typeArgument;
                System.out.println("typeArgClass=" + typeArgClass);//typeArgClass=class java.lang.String
            }
        }
    }

    @Test //获取类相关信息
    public void test06()
    {
        Class clazz = Person.class;
        System.out.println(clazz.getName());//com.zc.exer.Person
        clazz.getInterfaces();
        clazz.getGenericInterfaces();
        clazz.getSuperclass();
        clazz.getGenericSuperclass();
    }

    @Test //获取数组信息
    public void testArr() throws Exception
    {
        //通过java.lang.reflect.Array类创建数组
        int[] intArr = (int[]) Array.newInstance(int.class, 3);
        //访问一个数组
        Array.set(intArr, 0, 123);
        Array.set(intArr, 1, 456);
        Array.set(intArr, 2, 789);
        System.out.println(Array.get(intArr, 0));

        //获取Class对象
        //方式1.
        Class strArrClazz = String[].class;
        //方式2.若获取原生数据类型(primitive)
        Class intArr2 = Class.forName("[I");
        //若获取原生数据类型
        Class strArrClass2 = Class.forName("[Ljava.lang.String;");
        System.out.println(intArr2);
        System.out.println(strArrClass2);
    }
    
    @Test
    public void testClassAPI()
    {
        Class<Person> personClazz = Person.class;
        //Class对象.isInstance(对象)
        System.out.println(personClazz.isInstance(new Person()));//true
        
        //Class.isAssignableFrom()
        //判定此 Class 对象所表示的类或接口与指定的 Class 参数所表示的类或接口是否相同，或是前者否是后者的超类或超接口。
        System.out.println(personClazz.isAssignableFrom(Person.class));//true
        personClazz.isAssignableFrom(Student.class);//true
        Student.class.isAssignableFrom(personClazz);//false
        
    }
    
    @Test
    public void testArrayAPI()
    {
        Integer[] arr = (Integer[])Array.newInstance(Integer.class, 10);
    }
    
}
