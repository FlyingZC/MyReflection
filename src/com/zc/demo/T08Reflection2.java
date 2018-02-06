package com.zc.demo;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class T08Reflection2
{
    /**
     * 反射 获取 构造方法
     * @throws Exception
     */
    @Test
    public void test01() throws Exception
    {
        Class<Person> clazz = Person.class;
        //1.获取单个构造方法 
        //方式一
        Constructor<Person> construct = clazz.getConstructor(String.class, int.class);
        //方式二
        Constructor<Person> construct2 = clazz.getConstructor(new Class[] {String.class, int.class});
        System.out.println(construct.toGenericString());
        System.out.println(construct2.toString());

        //查看构造方法是否被...修饰
        int modifier = construct.getModifiers();
        String mod = Modifier.toString(modifier);
        System.out.println(mod);//public

        //2.获取所有构造方法
        Constructor<Person>[] consts = (Constructor<Person>[]) clazz.getDeclaredConstructors();
        for (int i = 0; i < consts.length; i++)
        {
            Constructor<Person> constructor = consts[i];
            System.out.println("是否允许使用可变个数的形参:" + constructor.isVarArgs());
            Class<Person>[] paramTypes = (Class<Person>[]) constructor.getParameterTypes();
            for (int j = 0; i < paramTypes.length; j++)
            {
                System.out.println(paramTypes[j]);
            }
            if (i == 0)
            {
                constructor.newInstance();
            }
            else if (i == 1)
            {
                Person p = constructor.newInstance("zc", 123);
                System.out.println(p);
            }
        }
    }
}
